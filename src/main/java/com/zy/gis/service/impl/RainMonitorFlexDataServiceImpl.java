package com.zy.gis.service.impl;

import com.zy.gis.mapper.RainMonitorFlexDataMapper;
import com.zy.gis.orm.qo.RainMonitorDataQueryParameter;
import com.zy.gis.pojo.flexem.RainMonitorFlexData;
import com.zy.gis.service.RainMonitorFlexDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
@author Wangchong
@date 2021/10/29 15:47
@description TODO 雨水监测点数据业务处理逻辑
*/
@Service
public class RainMonitorFlexDataServiceImpl implements RainMonitorFlexDataService {

    @Autowired
    private RainMonitorFlexDataMapper  rainMonitorFlexDataMapper;

    @Override
    public Integer insertSelective(RainMonitorFlexData record) {
        rainMonitorFlexDataMapper.insertHistorySelective(record);
        return rainMonitorFlexDataMapper.insertSelective(record);
    }

    @Override
    public RainMonitorFlexData selectLatestData(String boxNo) {
        return rainMonitorFlexDataMapper.selectLatestData(boxNo);
    }

    /**
     @author Wangchong
     @date 2021/11/2 16:43
     @description TODO 查询多条雨水监测点数据
     @param rainMonitorDataQueryParameter 查询参数u
     @return 记录
     */
    public List<RainMonitorFlexData> selectRainMonitorDataList(RainMonitorDataQueryParameter rainMonitorDataQueryParameter){
        return rainMonitorFlexDataMapper.selectRainMonitorDataList(rainMonitorDataQueryParameter);
    }

    public Integer selectRainMonitorDataCount(RainMonitorDataQueryParameter rainMonitorDataQueryParameter){
        return rainMonitorFlexDataMapper.selectRainMonitorDataCount(rainMonitorDataQueryParameter);
    }

    @Override
    public Integer deleteAll() {
        return rainMonitorFlexDataMapper.deleteAll();
    }

    /**
     @author Wangchong
     @date 2021/11/10 15:30
     @description TODO 查询历史多条雨水监测点数据
     @param rainMonitorDataQueryParameter
     @return
     */
    public List<RainMonitorFlexData> selectRainMonitorHistoryDataList(RainMonitorDataQueryParameter rainMonitorDataQueryParameter){
        return rainMonitorFlexDataMapper.selectRainMonitorHistoryDataList(rainMonitorDataQueryParameter);
    }

    public Integer selectRainMonitorHistoryDataCount(RainMonitorDataQueryParameter rainMonitorDataQueryParameter){
        return rainMonitorFlexDataMapper.selectRainMonitorDataCount(rainMonitorDataQueryParameter);
    }
}
