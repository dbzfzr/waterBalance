package com.zy.gis.service;

import com.zy.gis.orm.qo.DeviceRepairRecordQueryParameter;
import com.zy.gis.pojo.DeviceRepairRecordWithBLOBs;

import java.util.List;

/**
@author Wangchong
@date 2021/12/3 15:37
@description TODO
*/
public interface DeviceRepairRecordService {
    Integer insertSelective(DeviceRepairRecordWithBLOBs record);

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
