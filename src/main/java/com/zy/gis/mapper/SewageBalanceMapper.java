package com.zy.gis.mapper;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.pojo.waterbalance.SewageBalance;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SewageBalanceMapper {
    int deleteByPrimaryKey(Integer id);

    Integer insertSelective(SewageBalance record);

    SewageBalance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SewageBalance record);

    int updateByPrimaryKey(SewageBalance record);

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