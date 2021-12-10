package com.zy.gis.service.impl;

import com.zy.gis.mapper.DeviceRepairRecordMapper;
import com.zy.gis.orm.qo.DeviceRepairRecordQueryParameter;
import com.zy.gis.pojo.DeviceRepairRecordWithBLOBs;
import com.zy.gis.service.DeviceRepairRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
@author Wangchong
@date 2021/12/3 15:37
@description TODO
*/
@Service
public class DeviceRepairRecordServiceImpl implements DeviceRepairRecordService {

    @Autowired
    private DeviceRepairRecordMapper deviceRepairRecordMapper;

    @Override
    public Integer insertSelective(DeviceRepairRecordWithBLOBs record) {
        return deviceRepairRecordMapper.insertSelective(record);
    }

    /**
     @author Wangchong
     @date 2021/12/3 15:55
     @description TODO 查询设备维修记录信息
     @param deviceRepairRecordQueryParameter
     @return {@link DeviceRepairRecordWithBLOBs }
     */
    public List<DeviceRepairRecordWithBLOBs> selectDeviceRepairRecordList(DeviceRepairRecordQueryParameter deviceRepairRecordQueryParameter){
        return deviceRepairRecordMapper.selectDeviceRepairRecordList(deviceRepairRecordQueryParameter);
    }

    /**
     @author Wangchong
     @date 2021/12/3 15:57
     @description TODO 查询设备维修记录信息数量
     @param deviceRepairRecordQueryParameter
     @return
     */
    public Integer selectDeviceRepairRecordCount(DeviceRepairRecordQueryParameter deviceRepairRecordQueryParameter){
        return deviceRepairRecordMapper.selectDeviceRepairRecordCount(deviceRepairRecordQueryParameter);
    }
}
