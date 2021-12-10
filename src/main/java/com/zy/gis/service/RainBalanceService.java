package com.zy.gis.service;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.pojo.waterbalance.RainBalance;

import java.util.List;

public interface RainBalanceService {
    Integer insertSelective(RainBalance record);

    /**
     @author Wangchong
     @date 2021/11/29 11:03
     @description TODO 查询雨水平衡记录信息
     @param paramJSONObject
     @return
     */
    List<RainBalance> selectRainBalanceList(JSONObject paramJSONObject);

    /**
     @author Wangchong
     @date 2021/11/29 11:04
     @description TODO 查询雨水平衡记录信息数量
     @param  paramJSONObject
     @return
     */
    Integer selectRainBalanceListCount(JSONObject paramJSONObject);
}
