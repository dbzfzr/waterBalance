package com.zy.gis.mapper;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.pojo.AlarmDispatchRule;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
@author Wangchong
@date 2021/11/30 19:32
@description TODO
*/
@Repository
public interface AlarmDispatchRuleMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insertSelective(AlarmDispatchRule record);

    AlarmDispatchRule selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(AlarmDispatchRule record);

    List<AlarmDispatchRule> selectAlarmDispatchRuleList(JSONObject paramJSONObject);

    Integer selectAlarmDispatchRuleCount(JSONObject paramJSONObject);
}