package com.zy.gis.flexem.mqtt.client;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.utils.DateUtil;
import com.zy.gis.common.utils.SpringUtil;
import com.zy.gis.device.data.common.DeviceDataHandle;
import com.zy.gis.pojo.devAndFacility.DevControlPanelInfo;
import com.zy.gis.pojo.flexem.FlexState;
import com.zy.gis.service.*;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/10/13 11:37
 */
public class MqttReceiveCallback implements MqttCallback {

    private static Logger logger = LoggerFactory.getLogger(MqttReceiveCallback.class);

    private DevControlPanelService devControlPanelService = null;

    //private RainMonitorFlexDataService rainMonitorFlexDataService = null;

    private FlexStateService flexStateService = SpringUtil.getBean(FlexStateService.class);

//    private PumpStationFlexDataService pumpStationFlexDataService = SpringUtil.getBean(PumpStationFlexDataService.class);
//
//    private SewageMonitorFlexDataService sewageMonitorFlexDataService = SpringUtil.getBean(SewageMonitorFlexDataService.class);
//
//    private AlarmRuleService alarmRuleService = SpringUtil.getBean(AlarmRuleService.class);
//
//    private AlarmRecordService alarmRecordService = SpringUtil.getBean(AlarmRecordService.class);

    private DeviceDataHandle deviceDataHandle = SpringUtil.getBean(DeviceDataHandle.class);

    public MqttReceiveCallback() {
        // 202110291651 Wangchong 获取业务逻辑处理类
        devControlPanelService = SpringUtil.getBean(DevControlPanelService.class);
        //rainMonitorFlexDataService = SpringUtil.getBean(RainMonitorFlexDataService.class);
    }

    @Override
    public void connectionLost(Throwable cause) {
        cause.printStackTrace();
        logger.error("MQTT 服务器连接断开:{}", cause.getMessage());
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {

        System.out.println("Client 接收消息主题 : " + topic);
        System.out.println("Client 接收消息Qos : " + message.getQos());
        System.out.println("Client 接收消息内容 : " + new String(message.getPayload()));

        String[] topicSplitArray = topic.split("/");

        // 繁易外接的设备数据
        if (topic.contains("reply/getDevData")) {
            handleFlexemData(topicSplitArray[0], message);
        }

        // 繁易屏盒子状态信息
        if (topic.contains("reply/getBoxInfo")) {
            handleFlexemStateMessage(topicSplitArray[0], message);
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {

        logger.info("发送成功");
    }

    /**
     * @param boxNo       繁易屏设备编号
     * @param mqttMessage 消息
     * @author Wangchong
     * @date 2021/10/29 15:24
     * @description TODO 处理繁易屏设备外接设备的数据
     */
    public void handleFlexemData(String boxNo, MqttMessage mqttMessage) {
        String message = mqttMessage.toString();

        JSONObject msgJSONObject = JSONObject.parseObject(message);

        String timeStr = DateUtil.parseTimeLong(msgJSONObject.getLongValue("flexemTimeStamp") * 1000L);
        msgJSONObject.put("flexemTimeStamp", timeStr);

        DevControlPanelInfo devControlPanelInfo = new DevControlPanelInfo();
        devControlPanelInfo.setBoxNo(boxNo);

        List<DevControlPanelInfo> devControlPanelInfoList = devControlPanelService.getAllDevControlPanelInfo(devControlPanelInfo);
        if (devControlPanelInfoList.size() == 0) {
            logger.error("{}繁易屏设备信息不存在,请检查", boxNo);
            return;
        }

        devControlPanelInfo = devControlPanelInfoList.get(0);
        if (devControlPanelInfo == null) {
            logger.error("{}繁易屏设备信息不存在,请检查", boxNo);
            return;
        }

        devControlPanelInfo.setBoxState("true");
//        Integer flexemOnlineSta = msgJSONObject.getInteger("flexemOnlineSta");
//
//        if (1 == msgJSONObject.getInteger("flexemOnlineSta")){
//            devControlPanelInfo.setBoxState("true");
//        }else {
//            devControlPanelInfo.setBoxState("false");
//        }

        devControlPanelService.updateDevControlPanelByBoxNo(devControlPanelInfo);

        // 接收状态信息
        FlexState flexState = msgJSONObject.toJavaObject(FlexState.class);

        flexState.setBoxNo(boxNo);
        flexState.setFlexemOnlineSta(1);
        flexStateService.updateByBoxNoKeySelective(flexState);

        // 设备系统类型
        String systemType = devControlPanelInfo.getSystemType();

        switch (systemType) {
            case "雨水监测点":
                deviceDataHandle.handleRainMonitorData(boxNo, msgJSONObject);
                break;
            case "污水监测点":
                deviceDataHandle.handleSewageMonitorFlexData(boxNo, msgJSONObject);
                break;
            case "泵站":
                deviceDataHandle.handlePumpStationFlexData(boxNo, msgJSONObject);
                break;
        }
    }

    /**
     * @param boxNo       繁易屏设备编号
     * @param mqttMessage 消息
     * @author Wangchong
     * @date 2021/10/30 15:22
     * @description TODO 处理繁易屏状态信息
     */
    public void handleFlexemStateMessage(String boxNo, MqttMessage mqttMessage) {
        String message = mqttMessage.toString();

        JSONObject msgJSONObject = JSONObject.parseObject(message);

        String errorCode = msgJSONObject.getString("");
    }

//    /**
//     * @param boxNo
//     * @param msgJson
//     * @author Wangchong
//     * @date 2021/11/4 14:17
//     * @description TODO 处理雨水监测点数据
//     */
//    public void handleRainMonitorData(String boxNo, JSONObject msgJson) {
//
//        RainMonitorFlexData rainMonitorFlexData = msgJson.toJavaObject(RainMonitorFlexData.class);
//        rainMonitorFlexData.setBoxNo(boxNo);
//        rainMonitorFlexDataService.insertSelective(rainMonitorFlexData);
//    }
//
//    /**
//     * @param boxNo
//     * @param msgJson
//     * @author Wangchong
//     * @date 2021/11/8 10:22
//     * @description TODO 处理泵站数据
//     */
//    public void handlePumpStationFlexData(String boxNo, JSONObject msgJson) {
//
//        PumpStationFlexData pumpStationFlexData = msgJson.toJavaObject(PumpStationFlexData.class);
//        pumpStationFlexData.setBoxNo(boxNo);
//        pumpStationFlexDataService.insertSelective(pumpStationFlexData);
//    }
//
//    /**
//     * @param boxNo
//     * @param msgJson
//     * @author Wangchong
//     * @date 2021/12/7 16:18
//     * @description TODO 处理污水监测点数据,判断数值是否处于正常范围内
//     */
//    public void handleSewageMonitorFlexData(String boxNo, JSONObject msgJson) {
//
//        SewageMonitorFlexData sewageMonitorFlexData = msgJson.toJavaObject(SewageMonitorFlexData.class);
//
//        QueryParameter<AlarmRule> queryParameter = new QueryParameter<>();
//
//        AlarmRule alarmRule = new AlarmRule();
//        alarmRule.setControlSystemType("污水监测点");
//        List<AlarmRule> alarmRuleList = alarmRuleService.listGetAlarmRule(queryParameter);
//        Iterator<AlarmRule> alarmRuleIterator = alarmRuleList.iterator();
//
//        // 氨氮
//        String ammoniaNitrogen = sewageMonitorFlexData.getAmmoniaNitrogen();
//        if (StringUtils.isNotEmpty(ammoniaNitrogen)){
//            alarmRecordService.inspectSensorValueIsTriggerAlarm(boxNo, alarmRuleIterator, ammoniaNitrogen, "氨氮");
//        }
//
//        //ph
//        String ph = sewageMonitorFlexData.getPh();
//        if (StringUtils.isNotEmpty(ph)){
//            alarmRecordService.inspectSensorValueIsTriggerAlarm(boxNo, alarmRuleIterator, ph, "PH");
//        }
//
//        // COD
//        String cod = sewageMonitorFlexData.getCod();
//        if (StringUtils.isNotEmpty(cod)){
//            alarmRecordService.inspectSensorValueIsTriggerAlarm(boxNo, alarmRuleIterator, cod, "COD");
//        }
//
//        // 瞬时流量
//        String currentFlow = sewageMonitorFlexData.getCurrentFlow();
//        if (StringUtils.isNotEmpty(currentFlow)){
//            alarmRecordService.inspectSensorValueIsTriggerAlarm(boxNo, alarmRuleIterator, currentFlow, "瞬时流量");
//        }
//
//        // 累计流量
//        String cumulativeFlow = sewageMonitorFlexData.getCumulativeFlow();
//        if (StringUtils.isNotEmpty(cumulativeFlow)){
//            alarmRecordService.inspectSensorValueIsTriggerAlarm(boxNo, alarmRuleIterator, currentFlow, "累计流量");
//        }
//
//        sewageMonitorFlexData.setBoxNo(boxNo);
//        sewageMonitorFlexDataService.insertSelective(sewageMonitorFlexData);
//    }

    /**
     * @param boxNo
     * @param alarmRuleIterator
     * @param receiveValue
     * @param sensorParameterName
     * @return
     * @author Wangchong
     * @date 2021/12/7 19:46
     * @description TODO 检查传感器的数值，判断是否触发报警信息
     */
//    public void inspectSensorValueIsTriggerAlarm(String boxNo, Iterator<AlarmRule> alarmRuleIterator, String receiveValue, String sensorParameterName) {
//
//        if (StringUtils.isEmpty(receiveValue)) {
//            return;
//        }
//
//        Float superiorLimit = null;
//        Float lowerLimit = null;
//
//        Float sensorValue;
//
//        StringBuilder stringBuilder = new StringBuilder();
//
//        sensorValue = Float.valueOf(receiveValue);
//
//        AlarmRule alarmRule = null;
//
//        while (alarmRuleIterator.hasNext()) {
//            alarmRule = alarmRuleIterator.next();
//            if (!sensorParameterName.equals(alarmRule.getAlarmParameter())) {
//                continue;
//            }
//
//            superiorLimit = Float.valueOf(alarmRule.getAlarmSuperiorLimit());
//
//            if (superiorLimit == null) {
//                stringBuilder.append(alarmRule.getControlSystemType()).append(sensorParameterName).append("报警上限为null");
//                logger.error(stringBuilder.toString());
//                return;
//            }
//            lowerLimit = Float.valueOf(alarmRule.getAlarmLowerLimit());
//
//            if (superiorLimit == null) {
//                stringBuilder.append(alarmRule.getControlSystemType()).append(sensorParameterName).append("报警下限为null");
//                logger.error(stringBuilder.toString());
//                return;
//            }
//
//            if (!(sensorValue < lowerLimit || sensorValue > superiorLimit)) {
//                return;
//            }
//
//            // 触发报警
//            AlarmRecord alarmRecord = new AlarmRecord();
//            alarmRecord.setAlarmDevCode(boxNo);
//            alarmRecord.setHandleState("未处理");
//            alarmRecord.setAlarmValue(receiveValue);
//            alarmRecord.setAlarmTime(DateUtil.getNowTime());
//            alarmRecord.setAlarmType(alarmRule.getAlarmType());
//            stringBuilder.append(sensorParameterName).append("异常");
//            alarmRecord.setAlarmDescription(stringBuilder.toString());
//            if (logger.isInfoEnabled()) {
//                logger.info("报警记录:{}", alarmRecord.toString());
//            }
//
//            Integer count = alarmRecordService.insertSelective(alarmRecord);
//            if (count == 0) {
//                logger.error("插入报警记录失败:{}", alarmRecord.toString());
//            }
//
//            alarmRuleIterator.remove();
//            return;
//        }
//    }
}
