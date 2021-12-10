package com.zy.gis.mapper;

import com.zy.gis.orm.qo.QueryParameter;
import com.zy.gis.pojo.AlarmRule;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
@author Wangchong
@date 2021/12/7 9:28
@description TODO
*/
@Repository
public interface AlarmRuleMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insertSelective(AlarmRule record);

    AlarmRule selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(AlarmRule record);

    /**
    @author Wangchong
    @date 2021/12/7 9:47
    @description TODO 查询报警事件规则
    @param queryParameter {@link QueryParameter }
    @return 
    */
    List<AlarmRule> listGetAlarmRule(QueryParameter<AlarmRule> queryParameter);

    /**
    @author Wangchong
    @date 2021/12/7 9:48
    @description TODO 查询报警事件数量
    @param 
    @return 
    */
    Integer countGetAlarmRule(QueryParameter<AlarmRule> queryParameter);
}