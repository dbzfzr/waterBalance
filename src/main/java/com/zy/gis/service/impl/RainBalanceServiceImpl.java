package com.zy.gis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.mapper.RainBalanceMapper;
import com.zy.gis.pojo.waterbalance.RainBalance;
import com.zy.gis.service.RainBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
@author Wangchong
@date 2021/11/29 10:57
@description TODO
*/
@Service
public class RainBalanceServiceImpl implements RainBalanceService {

    @Autowired
    private RainBalanceMapper rainBalanceMapper;
    @Override
    public Integer insertSelective(RainBalance record) {
        return rainBalanceMapper.insertSelective(record);
    }

    /**
     @author Wangchong
     @date 2021/11/29 11:03
     @description TODO 查询雨水平衡记录信息
     @param paramJSONObject
     @return
     */
    public List<RainBalance> selectRainBalanceList(JSONObject paramJSONObject){
        return rainBalanceMapper.selectRainBalanceList(paramJSONObject);
    }

    /**
     @author Wangchong
     @date 2021/11/29 11:04
     @description TODO 查询雨水平衡记录信息数量
     @param  paramJSONObject
     @return
     */
    public Integer selectRainBalanceListCount(JSONObject paramJSONObject){
        return rainBalanceMapper.selectRainBalanceListCount(paramJSONObject);
    }
}
