package com.zy.gis.service;

import com.zy.gis.pojo.AlarmRecord;
import com.zy.gis.pojo.flexem.AlarmDispatch;

import java.util.List;

public interface AlarmDispatchService {
    List<AlarmDispatch> selectAlarmDispatchList(AlarmDispatch alarmDispatch);

    Integer insertSelective(AlarmDispatch record);

    Integer selectAlarmDispatchCount(AlarmDispatch alarmDispatch);

    Integer updateSelective(AlarmDispatch record);

    Integer insertAlarmDispatch(AlarmRecord record);
}
