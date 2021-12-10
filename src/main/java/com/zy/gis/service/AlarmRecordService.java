package com.zy.gis.service;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.orm.qo.AlarmRecordQueryParameter;
import com.zy.gis.pojo.AlarmRecord;
import com.zy.gis.pojo.AlarmRule;

import java.util.Iterator;
import java.util.List;

public interface AlarmRecordService {
    /**
     @author Wangchong
     @date 2021/10/22 19:26
     @description 查询报警记录列表
     @param
     @return
     */
    List<AlarmRecord> getAlarmRecordList(AlarmRecordQueryParameter alarmRecordQueryParameter);

    Integer getAlarmRecordCount(AlarmRecordQueryParameter alarmRecordQueryParameter);

    /**
     @author Wangchong
     @date 2021/10/23 14:26
     @description TODO 统计报警记录处理状态的数量
     @return {"handleState": ,"recordCount": }
     */
    List<JSONObject> statisticAlarmHandleStateCount();

    Integer insertSelective(AlarmRecord record);


    /**
     @author Wangchong
     @date 2021/11/12 10:05
     @description TODO 根据报警id查找报警记录
     @param  alarmIdList 报警id
     @return {@link AlarmRecord}
     */
    List<AlarmRecord> selectAlarmRecordListByIdList(List<Integer> alarmIdList);

    Integer updateByPrimaryKeySelective(AlarmRecord record);

    /**
     * @param boxNo 设备编号
     * @param alarmRuleIterator 报警规则迭代器
     * @param receiveValue 接收到的数值字符串
     * @param sensorParameterName 报警规则中对应的报警参数字符串
     * @return
     * @author Wangchong
     * @date 2021/12/7 19:46
     * @description TODO 检查传感器的数值，判断是否触发报警信息
     */
    void inspectSensorValueIsTriggerAlarm(String boxNo, Iterator<AlarmRule> alarmRuleIterator, String receiveValue, String sensorParameterName);
}
