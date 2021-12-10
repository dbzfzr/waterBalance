package com.zy.gis.service;

import com.zy.gis.orm.qo.RainMonitorDataQueryParameter;
import com.zy.gis.pojo.flexem.SewageMonitorFlexData;

import java.util.List;

public interface SewageMonitorFlexDataService {
    Integer insertSelective(SewageMonitorFlexData record);

    /**
     @author Wangchong
     @date 2021/11/9 17:28
     @description TODO 查询最新的一条数据记录
     @param boxNo
     @return 污水监测点数据
     */
    SewageMonitorFlexData selectLatestData(String boxNo);

    List<SewageMonitorFlexData> selectSewageMonitorFlexDataList(RainMonitorDataQueryParameter queryParameter);

    Integer selectSewageMonitorFlexDataCount(RainMonitorDataQueryParameter queryParameter);

    Integer deleteAll();

    List<SewageMonitorFlexData> selectSewageMonitorFlexHistoryDataList(RainMonitorDataQueryParameter queryParameter);

    Integer selectSewageMonitorFlexHistoryDataCount(RainMonitorDataQueryParameter queryParameter);
}
