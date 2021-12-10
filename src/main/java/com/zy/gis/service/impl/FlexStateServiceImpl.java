package com.zy.gis.service.impl;

import com.zy.gis.mapper.FlexStateMapper;
import com.zy.gis.pojo.flexem.FlexState;
import com.zy.gis.service.FlexStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
@author Wangchong
@date 2021/10/30 11:11
@description TODO 繁易屏设备业务逻辑处理类
*/
@Service
public class FlexStateServiceImpl implements FlexStateService {

    @Autowired
    private FlexStateMapper flexStateMapper;

    @Override
    public Integer insertSelective(FlexState record) {
        return flexStateMapper.insertSelective(record);
    }

    @Override
    public Integer selectFlexStateCountByBoxNo(String boxNo) {
        return flexStateMapper.selectFlexStateCountByBoxNo(boxNo);
    }

    public Integer updateByBoxNoKeySelective(FlexState record){
        return flexStateMapper.updateByBoxNoKeySelective(record);
    }

    /**
     @author Wangchong
     @date 2021/11/5 16:10
     @description TODO 查询繁易屏设备信息
     @param flexState
     @return 繁易屏设备信息
     */
    public List<FlexState> selectFlexStateList(FlexState flexState){
        return flexStateMapper.selectFlexStateList(flexState);
    }
}
