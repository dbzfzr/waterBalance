package com.zy.gis.mapper;

import com.zy.gis.pojo.flexem.FlexState;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlexStateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FlexState record);

    int insertSelective(FlexState record);

    FlexState selectByPrimaryKey(Integer id);

    Integer updateByBoxNoKeySelective(FlexState record);

    int updateByPrimaryKey(FlexState record);

    Integer selectFlexStateCountByBoxNo(@Param("boxNo")String boxNo);
    /**
    @author Wangchong
    @date 2021/11/5 16:10
    @description TODO 查询繁易屏设备信息
    @param flexState
    @return 繁易屏设备信息
    */
    List<FlexState> selectFlexStateList(FlexState flexState);
}