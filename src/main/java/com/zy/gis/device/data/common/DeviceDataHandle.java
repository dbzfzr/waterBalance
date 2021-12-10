package com.zy.gis.device.data.common;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.orm.qo.QueryParameter;
import com.zy.gis.pojo.AlarmRule;
import com.zy.gis.pojo.flexem.PumpStationFlexData;
import com.zy.gis.pojo.flexem.RainMonitorFlexData;
import com.zy.gis.pojo.flexem.SewageMonitorFlexData;
import com.zy.gis.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

/**
@author Wangchong
@date 2021/12/9 10:00
@description TODO 具体的设备上传来的数据处理，包括繁易屏设备，凯铭DTU等
*/
@Component
public class DeviceDataHandle {

    @Autowired
    private RainMonitorFlexDataService rainMonitorFlexDataService;

    @Autowired
    private SewageMonitorFlexDataService sewageMonitorFlexDataService;

    @Autowired
    private PumpStationFlexDataService pumpStationFlexDataService;

    @Autowired
    private AlarmRuleService alarmRuleService;

    @Autowired
    private AlarmRecordService alarmRecordService;

    /**
     * @param boxNo
     * @param msgJson
     * @author Wangchong
     * @date 2021/11/4 14:17
     * @description TODO 处理雨水监测点数据
     */
    public void handleRainMonitorData(String boxNo, JSONObject msgJson) {

        RainMonitorFlexData rainMonitorFlexData = msgJson.toJavaObject(RainMonitorFlexData.class);
        rainMonitorFlexData.setBoxNo(boxNo);
        rainMonitorFlexDataService.insertSelective(rainMonitorFlexData);
    }

    /**
     * @param boxNo
     * @param msgJson
     * @author Wangchong
     * @date 2021/11/8 10:22
     * @description TODO 处理泵站数据
     */
    public void handlePumpStationFlexData(String boxNo, JSONObject msgJson) {

        PumpStationFlexData pumpStationFlexData = msgJson.toJavaObject(PumpStationFlexData.class);
        pumpStationFlexData.setBoxNo(boxNo);
        pumpStationFlexDataService.insertSelective(pumpStationFlexData);
    }

    /**
     * @param boxNo
     * @param msgJson
     * @author Wangchong
     * @date 2021/12/7 16:18
     * @description TODO 处理污水监测点数据,判断数值是否处于正常范围内
     */
    public void handleSewageMonitorFlexData(String boxNo, JSONObject msgJson) {

        SewageMonitorFlexData sewageMonitorFlexData = msgJson.toJavaObject(SewageMonitorFlexData.class);

        QueryParameter<AlarmRule> queryParameter = new QueryParameter<>();

        AlarmRule alarmRule = new AlarmRule();
        alarmRule.setControlSystemType("污水监测点");
        List<AlarmRule> alarmRuleList = alarmRuleService.listGetAlarmRule(queryParameter);
        //Iterator<AlarmRule> alarmRuleIterator = alarmRuleList.iterator();

        // 氨氮
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

        sewageMonitorFlexData.setBoxNo(boxNo);
        sewageMonitorFlexDataService.insertSelective(sewageMonitorFlexData);
    }
}
