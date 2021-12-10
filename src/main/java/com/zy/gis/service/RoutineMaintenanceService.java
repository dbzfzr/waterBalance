package com.zy.gis.service;

import com.zy.gis.orm.qo.RoutineMaintenanceQueryParameter;
import com.zy.gis.pojo.RoutineMaintenance;

import java.util.List;

public interface RoutineMaintenanceService {

    Integer insertSelective(RoutineMaintenance record);

    /**
     @author Wangchong
     @date 2021/12/2 15:03
     @description TODO 查询日常维护记录信息
     @param routineMaintenanceQueryParameter
     @return
     */
    List<RoutineMaintenance> selectRoutineMaintenanceList(RoutineMaintenanceQueryParameter routineMaintenanceQueryParameter);

    /**
     @author Wangchong
     @date 2021/12/2 15:20
     @description TODO 查询日常维护记录信息数量
     @param routineMaintenanceQueryParameter
     @return
     */
    Integer selectRoutineMaintenanceCount(RoutineMaintenanceQueryParameter routineMaintenanceQueryParameter);
}
