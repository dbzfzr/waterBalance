package com.zy.gis.mapper;

import com.zy.gis.orm.qo.RainMonitorDataQueryParameter;
import com.zy.gis.pojo.flexem.RainMonitorFlexData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RainMonitorFlexDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RainMonitorFlexData record);

    Integer insertSelective(RainMonitorFlexData record);

    RainMonitorFlexData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RainMonitorFlexData record);

    int updateByPrimaryKey(RainMonitorFlexData record);

    /**
    @author Wangchong
    @date 2021/11/1 11:29
    @description TODO 查询最新的一条数据记录
    @return RainMonitorFlexData
    */
    RainMonitorFlexData selectLatestData(@Param("boxNo") String boxNo);

    /**
    @author Wangchong
    @date 2021/11/2 16:43
    @description TODO 查询多条雨水监测点数据
    @param rainMonitorDataQueryParameter 查询参数u
    @return 记录
    */
    List<RainMonitorFlexData> selectRainMonitorDataList(RainMonitorDataQueryParameter rainMonitorDataQueryParameter);

    Integer selectRainMonitorDataCount(RainMonitorDataQueryParameter rainMonitorDataQueryParameter);

    Integer deleteAll();

    Integer insertHistorySelective(RainMonitorFlexData record);

    /**
    @author Wangchong
    @date 2021/11/10 15:30
    @description TODO 查询历史多条雨水监测点数据
    @param rainMonitorDataQueryParameter
    @return
    */
    List<RainMonitorFlexData> selectRainMonitorHistoryDataList(RainMonitorDataQueryParameter rainMonitorDataQueryParameter);

    Integer selectRainMonitorHistoryDataCount(RainMonitorDataQueryParameter rainMonitorDataQueryParameter);
}