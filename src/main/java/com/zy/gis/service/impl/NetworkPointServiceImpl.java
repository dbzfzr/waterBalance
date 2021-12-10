package com.zy.gis.service.impl;

import com.zy.gis.mapper.devAndFacility.NetworkPointInfoMapper;
import com.zy.gis.orm.vo.GisPointHaveFlexemInfo;
import com.zy.gis.orm.vo.NetworkPointWithAlarmId;
import com.zy.gis.pojo.devAndFacility.DevControlPanelInfo;
import com.zy.gis.pojo.devAndFacility.NetworkPointInfo;
import com.zy.gis.service.NetworkPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/6 15:59
 */
@Service
public class NetworkPointServiceImpl implements NetworkPointService {

    @Autowired
    NetworkPointInfoMapper networkPointInfoMapper;

    @Override
    public int insert(NetworkPointInfo record) {
        return networkPointInfoMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(NetworkPointInfo record) {
        return networkPointInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return networkPointInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public NetworkPointInfo selectByPrimaryKey(Integer id) {
        return networkPointInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<NetworkPointInfo> getAllNetworkPoint(NetworkPointInfo record) {
        return networkPointInfoMapper.getAllNetworkPoint(record);
    }

    @Override
    public int getAllNetworkPointCount(NetworkPointInfo record) {
        return networkPointInfoMapper.getAllNetworkPointCount(record);
    }

    /**
     @author Wangchong
     @date 2021/11/1 10:43
     @description TODO 查询有繁易屏设备的管网点位的信息
     @return 管网点位的信息,包括设备报警状态
     */
    public List<GisPointHaveFlexemInfo> selectGisPointHaveFlexemList(){
        return networkPointInfoMapper.selectGisPointHaveFlexemList();
    }

    /**
     @author Wangchong
     @date 2021/11/1 11:53
     @description TODO 查询繁易屏设备对应的管网的系统类型
     @param boxNo 繁易屏设备编号
     @return 繁易屏设备对应的管网的系统类型
     */
    public String selectSystemTypeInfoByBoxNo(String boxNo){
        return networkPointInfoMapper.selectSystemTypeInfoByBoxNo(boxNo);
    }

    /**
     @author Wangchong
     @date 2021/11/5 9:28
     @description TODO 查询一条有繁易屏设备的点位的信息
     @param devControlPanelInfo
     @return 信息
     */
    public GisPointHaveFlexemInfo selectNetworkPointHaveFlexem(DevControlPanelInfo devControlPanelInfo){
        return networkPointInfoMapper.selectNetworkPointHaveFlexem(devControlPanelInfo);
    }

    /**
     @author Wangchong
     @date 2021/11/13 17:23
     @description TODO 查询管网点位信息，附带相应点位的报警记录id
     @param networkPointInfo
     @return {@link NetworkPointWithAlarmId}
     */
    public List<NetworkPointWithAlarmId> selectNetworkPointWithAlarmIdList(NetworkPointInfo networkPointInfo){
        return networkPointInfoMapper.selectNetworkPointWithAlarmIdList(networkPointInfo);
    }
	
	  @Override
    public int getNetworkSystemTypeRainNum() {
        return networkPointInfoMapper.getNetworkSystemTypeRainNum();
    }

    @Override
    public int getNetworkSystemTypeSewageNum() {
        return networkPointInfoMapper.getNetworkSystemTypeSewageNum();
    }

    @Override
    public int getNetworkSystemTypeRainPollutionNum() {
        return networkPointInfoMapper.getNetworkSystemTypeRainPollutionNum();
    }

    @Override
    public int getNetworkSystemTypeOilwaterNum() {
        return networkPointInfoMapper.getNetworkSystemTypeOilwaterNum();
    }

    @Override
    public int getNetworkSystemTypePumpingNum() {
        return networkPointInfoMapper.getNetworkSystemTypePumpingNum();
    }

    /**
     @author Wangchong
     @date 2021/11/19 14:38
     @description TODO 查询点位编号,名称 添加工控屏时用
     @param
     @return Map<String, String>
     */
    public List<Map<String, String>>selectNetworkPointNoAndName(){
        return networkPointInfoMapper.selectNetworkPointNoAndName();
    }

    /**
     @author Wangchong
     @date 2021/12/1 17:49
     @description TODO 查询有安装设备的管网点位的信息
     @param gisPointHaveFlexemInfo
     @return {@link GisPointHaveFlexemInfo}
     */
    public List<GisPointHaveFlexemInfo> selectNetworkPointHaveDeviceList(GisPointHaveFlexemInfo gisPointHaveFlexemInfo){
        return networkPointInfoMapper.selectNetworkPointHaveDeviceList(gisPointHaveFlexemInfo);
    }
}
