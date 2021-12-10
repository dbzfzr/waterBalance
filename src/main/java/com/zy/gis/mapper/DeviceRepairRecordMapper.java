package com.zy.gis.mapper;

import com.zy.gis.orm.qo.DeviceRepairRecordQueryParameter;
import com.zy.gis.pojo.DeviceRepairRecordWithBLOBs;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
@author Wangchong
@date 2021/12/3 15:35
@description TODO
*/
@Repository
public interface DeviceRepairRecordMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insertSelective(DeviceRepairRecordWithBLOBs record);

    DeviceRepairRecordWithBLOBs selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(DeviceRepairRecordWithBLOBs record);

    /**
    @author Wangchong
    @date 2021/12/3 15:55
    @description TODO 查询设备维修记录信息
    @param deviceRepairRecordQueryParameter
    @return {@link DeviceRepairRecordWithBLOBs }
    */
    List<DeviceRepairRecordWithBLOBs> selectDeviceRepairRecordList(DeviceRepairRecordQueryParameter deviceRepairRecordQueryParameter);

    /**
    @author Wangchong
    @date 2021/12/3 15:57
    @description TODO 查询设备维修记录信息数量
    @param deviceRepairRecordQueryParameter
    @return
    */
    Integer selectDeviceRepairRecordCount(DeviceRepairRecordQueryParameter deviceRepairRecordQueryParameter);
}