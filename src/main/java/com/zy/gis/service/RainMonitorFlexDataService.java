package com.zy.gis.service;


import com.zy.gis.orm.qo.RainMonitorDataQueryParameter;
import com.zy.gis.pojo.flexem.RainMonitorFlexData;

import java.util.List;

public interface RainMonitorFlexDataService {

    /**
    @author Wangchong
    @date 2021/10/29 15:46
    @description TODO 插入雨水监测点设备数据
    @param
    @return
    */
    Integer insertSelective(RainMonitorFlexData record);

    /**
     @author Wangchong
     @date 2021/11/1 11:29
     @description TODO 查询最新的一条数据记录
     @return RainMonitorFlexData
     */
    RainMonitorFlexData selectLatestData(String boxNo);

    /**
     @author Wangchong
     @date 2021/11/2 16:43
     @description TODO 查询多条雨水监测点数据
     @param rainMonitorDataQueryParameter 查询参数
     @return 记录
     */
    List<RainMonitorFlexData> selectRainMonitorDataList(RainMonitorDataQueryParameter rainMonitorDataQueryParameter);

    Integer selectRainMonitorDataCount(RainMonitorDataQueryParameter rainMonitorDataQueryParameter);

    Integer deleteAll();

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
