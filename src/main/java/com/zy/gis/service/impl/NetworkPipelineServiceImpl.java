package com.zy.gis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.mapper.devAndFacility.NetworkPipelineInfoMapper;
import com.zy.gis.pojo.devAndFacility.NetworkPipelineInfo;
import com.zy.gis.service.NetworkPipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/7 14:21
 */
@Service
public class NetworkPipelineServiceImpl implements NetworkPipelineService {

    @Autowired
    NetworkPipelineInfoMapper networkPipelineInfoMapper;

    @Override
    public int insert(NetworkPipelineInfo record) {
        return networkPipelineInfoMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(NetworkPipelineInfo record) {
        return networkPipelineInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return networkPipelineInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public NetworkPipelineInfo selectByPrimaryKey(Integer id) {
        return networkPipelineInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<NetworkPipelineInfo> getAllNetworkPipeline(NetworkPipelineInfo record) {
        return networkPipelineInfoMapper.getAllNetworkPipeline(record);
    }

    @Override
    public int getAllNetworkPipelineCount(NetworkPipelineInfo record) {
        return networkPipelineInfoMapper.getAllNetworkPipelineCount(record);
    }

    /**
     @author Wangchong
     @date 2021/11/15 16:31
     @description TODO 根据管线的终点查询起点
     @param endPointNoList
     @return
     */
    public List<String> selectStartNetworkPointByEndPoint(List<String> endPointNoList){
        return networkPipelineInfoMapper.selectStartNetworkPointByEndPoint(endPointNoList);
    }


    /**
     @author Wangchong
     @date 2021/11/16 16:33
     @description TODO 根据点位编号，查找起点或是终点为此点的管线更新信息
     @param paramJSONObject
     @return
     */
    public Integer updateByPointNoSelective(JSONObject paramJSONObject){
        return networkPipelineInfoMapper.updateByPointNoSelective(paramJSONObject);
    }
}
