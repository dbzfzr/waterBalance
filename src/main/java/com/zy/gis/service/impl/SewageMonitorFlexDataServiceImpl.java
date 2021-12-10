package com.zy.gis.service.impl;

import com.zy.gis.mapper.SewageMonitorFlexDataMapper;
import com.zy.gis.orm.qo.RainMonitorDataQueryParameter;
import com.zy.gis.pojo.flexem.SewageMonitorFlexData;
import com.zy.gis.service.SewageMonitorFlexDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
@author Wangchong
@date 2021/11/9 17:30
@description TODO 污水监测点数据处理
*/
@Service
public class SewageMonitorFlexDataServiceImpl implements SewageMonitorFlexDataService {

    @Autowired
    private SewageMonitorFlexDataMapper sewageMonitorFlexDataMapper;
    @Override
    public Integer insertSelective(SewageMonitorFlexData record) {
        sewageMonitorFlexDataMapper.insertHistorySelective(record);
        return sewageMonitorFlexDataMapper.insertSelective(record);
    }

    @Override
    public SewageMonitorFlexData selectLatestData(String boxNo) {
        return sewageMonitorFlexDataMapper.selectLatestData(boxNo);
    }

    @Override
    public List<SewageMonitorFlexData> selectSewageMonitorFlexDataList(RainMonitorDataQueryParameter queryParameter) {
        return sewageMonitorFlexDataMapper.selectSewageMonitorFlexDataList(queryParameter);
    }

    @Override
    public Integer selectSewageMonitorFlexDataCount(RainMonitorDataQueryParameter queryParameter) {
        return sewageMonitorFlexDataMapper.selectSewageMonitorFlexDataCount(queryParameter);
    }

    @Override
    public Integer deleteAll() {
        return sewageMonitorFlexDataMapper.deleteAll();
    }

    /**
    @author Wangchong
    @date 2021/11/10 16:31
    @description TODO 查询污水监测点历史数据
    @param queryParameter
    @return
    */
    public List<SewageMonitorFlexData> selectSewageMonitorFlexHistoryDataList(RainMonitorDataQueryParameter queryParameter){
        return sewageMonitorFlexDataMapper.selectSewageMonitorFlexHistoryDataList(queryParameter);
    }
    /**
    @author Wangchong
    @date 2021/11/10 16:32
    @description TODO 查询污水监测点历史数据数量
    @param queryParameter
    @return
    */
    public Integer selectSewageMonitorFlexHistoryDataCount(RainMonitorDataQueryParameter queryParameter){
        return sewageMonitorFlexDataMapper.selectSewageMonitorFlexHistoryDataCount(queryParameter);
    }
}
