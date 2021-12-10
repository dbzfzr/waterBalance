package com.zy.gis.service;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.pojo.AlarmDispatchRule;

import java.util.List;

public interface AlarmDispatchRuleService {
    Integer insertSelective(AlarmDispatchRule record);

    /**
    @author Wangchong
    @date 2021/11/30 19:33
    @description TODO 查询报警派单规则
    @param paramJSONObject
    @return
    */
    List<AlarmDispatchRule> selectAlarmDispatchRuleList(JSONObject paramJSONObject);

    Integer selectAlarmDispatchRuleCount(JSONObject paramJSONObject);
}
