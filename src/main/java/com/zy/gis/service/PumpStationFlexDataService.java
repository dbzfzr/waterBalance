package com.zy.gis.service;

import com.zy.gis.orm.qo.RainMonitorDataQueryParameter;
import com.zy.gis.pojo.flexem.PumpStationFlexData;

import java.util.List;

public interface PumpStationFlexDataService {
    Integer insertSelective(PumpStationFlexData record);

    PumpStationFlexData selectLatestData(String boxNo);

    List<PumpStationFlexData> selectPumpStationFlexDataList(RainMonitorDataQueryParameter rainMonitorDataQueryParameter);

    Integer selectPumpStationFlexDataCount(RainMonitorDataQueryParameter queryParameter);

    Integer deleteAll();

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
