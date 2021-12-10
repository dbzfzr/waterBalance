package com.zy.gis.service;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.pojo.devAndFacility.NetworkPipelineInfo;
import com.zy.gis.pojo.devAndFacility.NetworkPointInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/7 14:20
 */
public interface NetworkPipelineService {

    int insert(NetworkPipelineInfo record);

    int updateByPrimaryKeySelective(NetworkPipelineInfo record);

    int deleteByPrimaryKey(Integer id);

    NetworkPipelineInfo selectByPrimaryKey(Integer id);

    List<NetworkPipelineInfo> getAllNetworkPipeline(NetworkPipelineInfo record);

    int getAllNetworkPipelineCount(NetworkPipelineInfo record);

    /**
     @author Wangchong
     @date 2021/11/15 16:31
     @description TODO 根据管线的终点查询起点
     @param endPointNoList
     @return
     */
    List<String> selectStartNetworkPointByEndPoint(@Param("endPointNoList") List<String> endPointNoList);


    /**
     @author Wangchong
     @date 2021/11/16 16:33
     @description TODO 根据点位编号，查找起点或是终点为此点的管线更新信息
     @param paramJSONObject
     @return
     */
    Integer updateByPointNoSelective(JSONObject paramJSONObject);
}
