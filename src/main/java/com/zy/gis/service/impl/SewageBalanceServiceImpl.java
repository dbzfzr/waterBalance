package com.zy.gis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.mapper.SewageBalanceMapper;
import com.zy.gis.pojo.waterbalance.SewageBalance;
import com.zy.gis.service.SewageBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
@author Wangchong
@date 2021/11/25 16:45
@description TODO
*/
@Service
public class SewageBalanceServiceImpl implements SewageBalanceService {

    @Autowired
    private SewageBalanceMapper sewageBalanceMapper;

    @Override
    public Integer insertSelective(SewageBalance record) {
        return sewageBalanceMapper.insertSelective(record);
    }

    public List<SewageBalance> selectNewSewageBalance(){
        return sewageBalanceMapper.selectNewSewageBalance();
    }

    /**
     @author Wangchong
     @date 2021/11/27 14:40
     @description TODO 查询污水平衡记录信息
     @param paramJSONObject，可传递起始时间，分页参数
     @return
     */
    public List<SewageBalance> selectSewageBalanceList(JSONObject paramJSONObject){
        return sewageBalanceMapper.selectSewageBalanceList(paramJSONObject);
    }

    /**
     @author Wangchong
     @date 2021/11/27 15:05
     @description TODO 查询污水平衡记录信息数量
     @param  paramJSONObject
     @return
     */
    public Integer selectSewageBalanceListCount(JSONObject paramJSONObject){
        return sewageBalanceMapper.selectSewageBalanceListCount(paramJSONObject);
    }
}
