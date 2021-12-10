package com.zy.gis.service.impl;

import com.zy.gis.mapper.PumpStationFlexDataMapper;
import com.zy.gis.orm.qo.RainMonitorDataQueryParameter;
import com.zy.gis.pojo.flexem.PumpStationFlexData;
import com.zy.gis.service.PumpStationFlexDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
@author Wangchong
@date 2021/11/8 10:19
*/
@Service
public class PumpStationFlexDataServiceImpl implements PumpStationFlexDataService {

    @Autowired
    private PumpStationFlexDataMapper pumpStationFlexDataMapper;

    @Override
    public Integer insertSelective(PumpStationFlexData record) {
        pumpStationFlexDataMapper.insertHistorySelective(record);
        return pumpStationFlexDataMapper.insertSelective(record);
    }

    @Override
    public PumpStationFlexData selectLatestData(String boxNo) {
        return pumpStationFlexDataMapper.selectLatestData(boxNo);
    }

    @Override
    public List<PumpStationFlexData> selectPumpStationFlexDataList(RainMonitorDataQueryParameter queryParameter) {
        return pumpStationFlexDataMapper.selectPumpStationFlexDataList(queryParameter);
    }

    @Override
    public Integer selectPumpStationFlexDataCount(RainMonitorDataQueryParameter queryParameter) {
        return pumpStationFlexDataMapper.selectPumpStationFlexDataCount(queryParameter);
    }

    @Override
    public Integer deleteAll() {
        return pumpStationFlexDataMapper.deleteAll();
    }

    /**
     @author Wangchong
     @date 2021/11/10 15:44
     @description TODO 查询多条泵站历史数据
     @param queryParameter
     @return
     */
    public List<PumpStationFlexData> selectPumpStationFlexHistoryDataList(RainMonitorDataQueryParameter queryParameter){
        return pumpStationFlexDataMapper.selectPumpStationFlexHistoryDataList(queryParameter);
    }

    /**
     @author Wangchong
     @date 2021/11/10 15:45
     @description TODO 查询泵站历史数据条数
     @param queryParameter
     @return
     */
    public Integer selectPumpStationFlexHistoryDataCount(RainMonitorDataQueryParameter queryParameter){
        return pumpStationFlexDataMapper.selectPumpStationFlexHistoryDataCount(queryParameter);
    }
}
