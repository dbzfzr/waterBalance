package com.zy.gis.mapper;

import com.zy.gis.orm.qo.RainMonitorDataQueryParameter;
import com.zy.gis.pojo.flexem.SewageMonitorFlexData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SewageMonitorFlexDataMapper {
    int deleteByPrimaryKey(Integer id);

    Integer insertSelective(SewageMonitorFlexData record);

    /**
    @author Wangchong
    @date 2021/11/9 17:28
    @description TODO 查询最新的一条数据记录
    @param boxNo
    @return 污水监测点数据
    */
    SewageMonitorFlexData selectLatestData(@Param("boxNo")String boxNo);

    List<SewageMonitorFlexData> selectSewageMonitorFlexDataList(RainMonitorDataQueryParameter queryParameter);

    Integer selectSewageMonitorFlexDataCount(RainMonitorDataQueryParameter queryParameter);

    Integer deleteAll();

    Integer insertHistorySelective(SewageMonitorFlexData record);

    List<SewageMonitorFlexData> selectSewageMonitorFlexHistoryDataList(RainMonitorDataQueryParameter queryParameter);

    Integer selectSewageMonitorFlexHistoryDataCount(RainMonitorDataQueryParameter queryParameter);
}