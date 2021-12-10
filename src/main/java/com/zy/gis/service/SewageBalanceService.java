package com.zy.gis.service;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.pojo.waterbalance.SewageBalance;

import java.util.List;

public interface SewageBalanceService {

    Integer insertSelective(SewageBalance record);

    List<SewageBalance> selectNewSewageBalance();

    /**
     @author Wangchong
     @date 2021/11/27 14:40
     @description TODO 查询污水平衡记录信息
     @param paramJSONObject
     @return
     */
    List<SewageBalance> selectSewageBalanceList(JSONObject paramJSONObject);

    /**
     @author Wangchong
     @date 2021/11/27 15:05
     @description TODO 查询污水平衡记录信息数量
     @param  paramJSONObject
     @return
     */
    Integer selectSewageBalanceListCount(JSONObject paramJSONObject);
}
