package com.zy.gis.service.impl;

import com.zy.gis.mapper.RoutineMaintenanceMapper;
import com.zy.gis.orm.qo.RoutineMaintenanceQueryParameter;
import com.zy.gis.pojo.RoutineMaintenance;
import com.zy.gis.service.RoutineMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
@author Wangchong
@date 2021/12/2 14:28
@description TODO
*/
@Service
public class RoutineMaintenanceServiceImpl implements RoutineMaintenanceService {

    @Autowired
    private RoutineMaintenanceMapper routineMaintenanceMapper;

    @Override
    public Integer insertSelective(RoutineMaintenance record) {
        return routineMaintenanceMapper.insertSelective(record);
    }

    /**
     @author Wangchong
     @date 2021/12/2 15:03
     @description TODO 查询日常维护记录信息
     @param routineMaintenanceQueryParameter
     @return
     */
    public List<RoutineMaintenance> selectRoutineMaintenanceList(RoutineMaintenanceQueryParameter routineMaintenanceQueryParameter){
        return routineMaintenanceMapper.selectRoutineMaintenanceList(routineMaintenanceQueryParameter);
    }

    /**
     @author Wangchong
     @date 2021/12/2 15:20
     @description TODO 查询日常维护记录信息数量
     @param routineMaintenanceQueryParameter
     @return
     */
    public Integer selectRoutineMaintenanceCount(RoutineMaintenanceQueryParameter routineMaintenanceQueryParameter){
        return routineMaintenanceMapper.selectRoutineMaintenanceCount(routineMaintenanceQueryParameter);
    }
}
