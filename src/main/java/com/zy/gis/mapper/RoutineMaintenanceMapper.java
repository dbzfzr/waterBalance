package com.zy.gis.mapper;

import com.zy.gis.orm.qo.RoutineMaintenanceQueryParameter;
import com.zy.gis.pojo.RoutineMaintenance;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutineMaintenanceMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insertSelective(RoutineMaintenance record);

    RoutineMaintenance selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(RoutineMaintenance record);

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