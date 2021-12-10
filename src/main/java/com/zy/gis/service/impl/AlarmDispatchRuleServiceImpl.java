package com.zy.gis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.mapper.AlarmDispatchRuleMapper;
import com.zy.gis.pojo.AlarmDispatchRule;
import com.zy.gis.service.AlarmDispatchRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
@author Wangchong
@date 2021/11/30 18:45
@description TODO
*/
@Service
public class AlarmDispatchRuleServiceImpl implements AlarmDispatchRuleService {

    @Autowired
    private AlarmDispatchRuleMapper alarmDispatchRuleMapper;

    @Override
    public Integer insertSelective(AlarmDispatchRule record) {
        return alarmDispatchRuleMapper.insertSelective(record);
    }

    /**
     @author Wangchong
     @date 2021/11/30 19:33
     @description TODO 查询报警派单规则
     @param paramJSONObject
     @return
     */
    public List<AlarmDispatchRule> selectAlarmDispatchRuleList(JSONObject paramJSONObject){
        return alarmDispatchRuleMapper.selectAlarmDispatchRuleList(paramJSONObject);
    }

    public Integer selectAlarmDispatchRuleCount(JSONObject paramJSONObject){
        return alarmDispatchRuleMapper.selectAlarmDispatchRuleCount(paramJSONObject);
    }
}
