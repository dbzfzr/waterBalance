package com.zy.gis.mapper.devAndFacility;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.pojo.devAndFacility.NetworkPipelineInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NetworkPipelineInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table network_pipeline_info
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table network_pipeline_info
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    int insert(NetworkPipelineInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table network_pipeline_info
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    int insertSelective(NetworkPipelineInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table network_pipeline_info
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    NetworkPipelineInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table network_pipeline_info
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    int updateByPrimaryKeySelective(NetworkPipelineInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table network_pipeline_info
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    int updateByPrimaryKey(NetworkPipelineInfo record);

    /**
     * @Description:获取所有管网管线设施数据
     * @author hhp
     * @date 2021/9/7 14:19
     * @param record:
     * @return {@link List< NetworkPipelineInfo>}
     */
    List<NetworkPipelineInfo> getAllNetworkPipeline(NetworkPipelineInfo record);

    /**
     * @Description:获取所有管网管线设施数量
     * @author hhp
     * @date 2021/9/7 14:19
     * @param record:
     * @return {@link int}
     */
    int getAllNetworkPipelineCount(NetworkPipelineInfo record);

    /**
    @author Wangchong
    @date 2021/11/15 16:31
    @description TODO 根据管线的终点查询起点
    @param endPointNoList
    @return
    */
    List<String> selectStartNetworkPointByEndPoint(List<String> endPointNoList);

    /**
    @author Wangchong
    @date 2021/11/16 16:33
    @description TODO 根据点位编号，查找起点或是终点为此点的管线更新信息
    @param paramJSONObject
    @return 
    */
    Integer updateByPointNoSelective(JSONObject paramJSONObject);
}