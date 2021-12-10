package com.zy.gis.service.impl;

import com.zy.gis.mapper.AlarmRuleMapper;
import com.zy.gis.orm.qo.QueryParameter;
import com.zy.gis.pojo.AlarmRule;
import com.zy.gis.service.AlarmRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
@author Wangchong
@date 2021/12/7 9:31
*/
@Service
public class AlarmRuleServiceImpl implements AlarmRuleService {

    @Autowired
    private AlarmRuleMapper alarmRuleMapper;

    @Override
    public Integer insertSelective(AlarmRule record) {
        return alarmRuleMapper.insertSelective(record);
    }

    /**
     @author Wangchong
     @date 2021/12/7 9:47
     @description TODO 查询报警事件规则
     @param queryParameter {@link QueryParameter}
     @return
     */
    @Override
    public List<AlarmRule> listGetAlarmRule(QueryParameter<AlarmRule> queryParameter) {
        return alarmRuleMapper.listGetAlarmRule(queryParameter);
    }

    /**
     @author Wangchong
     @date 2021/12/7 9:48
     @description TODO 查询报警事件数量
     @param
     @return
     */
    @Override
    public Integer countGetAlarmRule(QueryParameter<AlarmRule> queryParameter) {
        return alarmRuleMapper.countGetAlarmRule(queryParameter);
    }
}
