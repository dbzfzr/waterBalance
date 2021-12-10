package com.zy.gis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.utils.DateUtil;
import com.zy.gis.mapper.AlarmRecordMapper;
import com.zy.gis.mapper.devAndFacility.DevControlPanelInfoMapper;
import com.zy.gis.mapper.devAndFacility.NetworkPipelineInfoMapper;
import com.zy.gis.orm.qo.AlarmRecordQueryParameter;
import com.zy.gis.pojo.AlarmRecord;
import com.zy.gis.pojo.AlarmRule;
import com.zy.gis.pojo.devAndFacility.DevControlPanelInfo;
import com.zy.gis.pojo.devAndFacility.NetworkPointInfo;
import com.zy.gis.service.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;


/**
@author Wangchong
@date 2021/10/22 19:44
*/
@Service
public class AlarmRecordServiceImpl implements AlarmRecordService {

    private static final Logger logger = LoggerFactory.getLogger(AlarmRecordServiceImpl.class);

    @Autowired
    private AlarmRecordMapper alarmRecordMapper;

    @Autowired
    private NetworkPipelineService networkPipelineService;

    @Autowired
    private NetworkPointService networkPointService;

    @Autowired
    private NetworkPipelineInfoMapper networkPipelineInfoMapper;

    @Autowired
    private AlarmDispatchService alarmDispatchService;

    @Autowired
    private DevControlPanelInfoMapper devControlPanelInfoMapper;
    /**
     @author Wangchong
     @date 2021/10/22 19:26
     @description 查询报警记录列表
     @param
     @return
     */
    public List<AlarmRecord> getAlarmRecordList(AlarmRecordQueryParameter alarmRecordQueryParameter){
        return alarmRecordMapper.getAlarmRecordList(alarmRecordQueryParameter);
    }

    public Integer getAlarmRecordCount(AlarmRecordQueryParameter alarmRecordQueryParameter){
        return alarmRecordMapper.getAlarmRecordCount(alarmRecordQueryParameter);
    }

    /**
     @author Wangchong
     @date 2021/10/23 14:26
     @description TODO 统计报警记录处理状态的数量
     @return {"handleState": ,"recordCount": }
     */
    public List<JSONObject> statisticAlarmHandleStateCount(){
        return  alarmRecordMapper.statisticAlarmHandleStateCount();
    }

    /**
    @author Wangchong
    @date 2021/11/15 16:59
    @description TODO 接收管道堵塞事件
    @param
    @return
    */
    public void handlePipelineBlockUp(AlarmRecord alarmRecord){

        String devFacilityNo = alarmRecord.getDevFacilityNo();
        NetworkPointInfo networkPointInfo = new NetworkPointInfo();
        networkPointInfo.setPointNo(devFacilityNo);
        networkPointInfo = networkPointService.getAllNetworkPoint(networkPointInfo).get(0);
        if (networkPointInfo == null){
            return;
        }

        JSONObject paramJSONObject = new JSONObject();
        paramJSONObject.put("pointNo", devFacilityNo);
        paramJSONObject.put("alarmState", "true");

        networkPipelineService.updateByPointNoSelective(paramJSONObject);
        // 上级点位
        NetworkPointInfo netLinkPointInfo = new NetworkPointInfo();

        String netLinkPointNo = networkPointInfo.getNextLinkPointNo();
        if (StringUtils.isEmpty(netLinkPointNo)){
            return;
        }
        netLinkPointInfo.setPointNo(networkPointInfo.getNextLinkPointNo());
        netLinkPointInfo = networkPointService.getAllNetworkPoint(netLinkPointInfo).get(0);

        AlarmRecord linkAlarmRecord = new AlarmRecord();
        linkAlarmRecord.setLinkAlarmId(alarmRecord.getId());
        linkAlarmRecord.setDevFacilityNo(netLinkPointNo);
        linkAlarmRecord.setAlarmDescription("联动预警:由点位" + networkPointInfo.getPointName() + "预警所致!");
        linkAlarmRecord.setAlarmType(alarmRecord.getAlarmType());
        linkAlarmRecord.setAlarmStation(netLinkPointInfo.getPointName());
        linkAlarmRecord.setAlarmTime(alarmRecord.getAlarmTime());
        linkAlarmRecord.setHandleState("未处理");
        alarmRecordMapper.insertSelective(linkAlarmRecord);

        alarmDispatchService.insertAlarmDispatch(linkAlarmRecord);
    }

    /**
    @author Wangchong
    @date 2021/12/7 20:17
    @description TODO 插入报警信息
    @param record
    @return
    */
    @Transactional(rollbackFor = RuntimeException.class)
    public Integer insertSelective(AlarmRecord record){
        Integer result = 1;

        DevControlPanelInfo devControlPanelInfo = new DevControlPanelInfo();
        devControlPanelInfo.setBoxNo(record.getAlarmDevCode());

        List<DevControlPanelInfo> devControlPanelInfoList = devControlPanelInfoMapper.getAllDevControlPanelInfo(devControlPanelInfo);
        if (devControlPanelInfoList.size() == 0){
            logger.error(record.getAlarmDevCode() + "设备为空");
            return 0;
        }

        devControlPanelInfo = devControlPanelInfoList.get(0);

        record.setAlarmStation(devControlPanelInfo.getBoxAlias());
        record.setDevFacilityNo(devControlPanelInfo.getFacilityNo());

        String alarmType = record.getAlarmType();

        if ("管网堵塞".equals(alarmType)){
            handlePipelineBlockUp(record);
        }

        result = alarmRecordMapper.insertSelective(record);

//        if ("设备故障".equals(alarmType)){
//            result = alarmRecordMapper.insertSelective(record);
//        } else if ("管网堵塞".equals(alarmType)){
//            result = alarmRecordMapper.insertSelective(record);
//            handlePipelineBlockUp(record);
//        }else{
//            result = alarmRecordMapper.insertSelective(record);
//        }

        alarmDispatchService.insertAlarmDispatch(record);
        return result;
    }

    /**
     @author Wangchong
     @date 2021/11/12 10:05
     @description TODO 根据报警id查找报警记录
     @param  alarmIdList 报警id
     @return {@link AlarmRecord}
     */
    public List<AlarmRecord> selectAlarmRecordListByIdList(List<Integer> alarmIdList){
        return alarmRecordMapper.selectAlarmRecordListByIdList(alarmIdList);
    }

    /**
    @author Wangchong
    @date 2021/12/1 10:19
    @description TODO 更新报警事件的状态
    @param record
    @return
    */
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Integer updateByPrimaryKeySelective(AlarmRecord record){
        String handleState = record.getHandleState();
        if ("已处理".equals(handleState)){

            AlarmRecord newAlarmRecord = alarmRecordMapper.selectByPrimaryKey(record.getId());

            if ("已处理".equals(newAlarmRecord.getHandleState())){
                return 0;
            }

            String devFacilityNo = newAlarmRecord.getDevFacilityNo();

            JSONObject paramJSONObject = new JSONObject();
            paramJSONObject.put("pointNo", devFacilityNo);
            // 报警解除
            paramJSONObject.put("alarmState", "false");
            networkPipelineInfoMapper.updateByPointNoSelective(paramJSONObject);

            // 联动报警事件解除
            AlarmRecordQueryParameter alarmRecordQueryParameter = new AlarmRecordQueryParameter();
            alarmRecordQueryParameter.setLinkAlarmId(record.getId());
            List<AlarmRecord> linkAlarmRecordList = alarmRecordMapper.getAlarmRecordList(alarmRecordQueryParameter);

            for (AlarmRecord alarmRecord : linkAlarmRecordList){
                 alarmRecord.setHandleState("已处理");
                 alarmRecord.setUpdateTime(record.getUpdateTime());
                alarmRecordMapper.updateByPrimaryKeySelective(alarmRecord);
            }
        }

        return alarmRecordMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * @param boxNo 设备编号
     * @param alarmRuleIterator 报警规则迭代器
     * @param receiveValue 接收到的数值字符串
     * @param sensorParameterName 报警规则中对应的报警参数字符串
     * @author Wangchong
     * @date 2021/12/7 19:46
     * @description TODO 检查传感器的数值，判断是否触发报警信息
     */
    public void inspectSensorValueIsTriggerAlarm(String boxNo, Iterator<AlarmRule> alarmRuleIterator, String receiveValue, String sensorParameterName){
        if (StringUtils.isEmpty(receiveValue)) {
            return;
        }

        Float superiorLimit = null;
        Float lowerLimit = null;

        Float sensorValue;

        StringBuilder stringBuilder = new StringBuilder();

        sensorValue = Float.valueOf(receiveValue);

        AlarmRule alarmRule = null;

        while (alarmRuleIterator.hasNext()) {
            alarmRule = alarmRuleIterator.next();
            if (!sensorParameterName.equals(alarmRule.getAlarmParameter())) {
                continue;
            }

            superiorLimit = Float.valueOf(alarmRule.getAlarmSuperiorLimit());
            if (superiorLimit == null) {
                stringBuilder.append(alarmRule.getControlSystemType()).append(sensorParameterName).append("报警上限为null");
                logger.error(stringBuilder.toString());
                alarmRuleIterator.remove();
                return;
            }

            lowerLimit = Float.valueOf(alarmRule.getAlarmLowerLimit());
            if (superiorLimit == null) {
                stringBuilder.append(alarmRule.getControlSystemType()).append(sensorParameterName).append("报警下限为null");
                logger.error(stringBuilder.toString());
                alarmRuleIterator.remove();
                return;
            }

            if (!(sensorValue < lowerLimit || sensorValue > superiorLimit)) {
                alarmRuleIterator.remove();
                return;
            }

            // 触发报警
            AlarmRecord alarmRecord = new AlarmRecord();
            alarmRecord.setAlarmDevCode(boxNo);
            alarmRecord.setHandleState("未处理");
            alarmRecord.setAlarmValue(receiveValue);
            alarmRecord.setAlarmTime(DateUtil.getNowTime());
            alarmRecord.setAlarmType(alarmRule.getAlarmType());
            stringBuilder.append(sensorParameterName).append("异常");
            alarmRecord.setAlarmDescription(stringBuilder.toString());

            if (logger.isInfoEnabled()) {
                logger.info("报警记录:{}", alarmRecord.toString());
            }

            Integer count = insertSelective(alarmRecord);
            if (count == 0) {
                logger.error("插入报警记录失败:{}", alarmRecord.toString());
            }

            alarmRuleIterator.remove();
            return;
        }
    }

}
