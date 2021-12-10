package com.zy.gis.mapper;

import com.zy.gis.pojo.flexem.AlarmDispatch;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlarmDispatchMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insertSelective(AlarmDispatch record);

    AlarmDispatch selectByPrimaryKey(Integer id);

    Integer updateSelective(AlarmDispatch record);

    List<AlarmDispatch> selectAlarmDispatchList(AlarmDispatch alarmDispatch);

    Integer selectAlarmDispatchCount(AlarmDispatch alarmDispatch);
}