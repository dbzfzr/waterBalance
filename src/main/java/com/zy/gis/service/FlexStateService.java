package com.zy.gis.service;

import com.zy.gis.pojo.flexem.FlexState;

import java.util.List;

public interface FlexStateService {

    Integer insertSelective(FlexState record);

    Integer selectFlexStateCountByBoxNo(String boxNo);

    Integer updateByBoxNoKeySelective(FlexState record);

    /**
     @author Wangchong
     @date 2021/11/5 16:10
     @description TODO 查询繁易屏设备信息
     @param flexState
     @return 繁易屏设备信息
     */
    List<FlexState> selectFlexStateList(FlexState flexState);
}