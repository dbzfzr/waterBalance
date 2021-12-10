package com.zy.gis.mapper;

import com.zy.gis.orm.qo.RainMonitorDataQueryParameter;
import com.zy.gis.pojo.flexem.PumpStationFlexData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PumpStationFlexDataMapper {
    int deleteByPrimaryKey(Integer id);

    Integer insert(PumpStationFlexData record);

    Integer insertSelective(PumpStationFlexData record);

    PumpStationFlexData selectByPrimaryKey(Integer id);

    PumpStationFlexData selectLatestData(@Param("boxNo")String boxNo);

    List<PumpStationFlexData> selectPumpStationFlexDataList(RainMonitorDataQueryParameter queryParameter);

    Integer selectPumpStationFlexDataCount(RainMonitorDataQueryParameter queryParameter);

    Integer deleteAll();

    Integer insertHistorySelective(PumpStationFlexData record);

    /**
    @author Wangchong
    @date 2021/11/10 15:44
    @description TODO 查询多条泵站历史数据
    @param queryParameter
    @return
    */
    List<PumpStationFlexData> selectPumpStationFlexHistoryDataList(RainMonitorDataQueryParameter queryParameter);

    /**
    @author Wangchong
    @date 2021/11/10 15:45
    @description TODO 查询泵站历史数据条数
    @param queryParameter
    @return
    */
    Integer selectPumpStationFlexHistoryDataCount(RainMonitorDataQueryParameter queryParameter);
}