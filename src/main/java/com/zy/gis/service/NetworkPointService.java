package com.zy.gis.service;

import com.zy.gis.orm.vo.GisPointHaveFlexemInfo;
import com.zy.gis.orm.vo.NetworkPointWithAlarmId;
import com.zy.gis.pojo.devAndFacility.DevControlPanelInfo;
import com.zy.gis.pojo.devAndFacility.NetworkPointInfo;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/6 15:58
 */
public interface NetworkPointService {
    int insert(NetworkPointInfo record);

    int updateByPrimaryKeySelective(NetworkPointInfo record);

    int deleteByPrimaryKey(Integer id);

    NetworkPointInfo selectByPrimaryKey(Integer id);

    List<NetworkPointInfo> getAllNetworkPoint(NetworkPointInfo record);

    int getAllNetworkPointCount(NetworkPointInfo record);

    int getNetworkSystemTypeRainNum();
     /**@author Wangchong
     @date 2021/11/1 10:43
     @description TODO 查询有繁易屏设备的管网点位的信息
     @return 管网点位的信息,包括设备报警状态
     */
    List<GisPointHaveFlexemInfo> selectGisPointHaveFlexemList();
    int getNetworkSystemTypeSewageNum();
    /**
     @author Wangchong
     @date 2021/11/1 11:53
     @description TODO 查询繁易屏设备对应的管网的系统类型
     @param boxNo 繁易屏设备编号
     @return 繁易屏设备对应的管网的系统类型
     */
    String selectSystemTypeInfoByBoxNo(String boxNo);

    /**
     @author Wangchong
     @date 2021/11/5 9:28
     @description TODO 查询一条有繁易屏设备的点位的信息
     @param devControlPanelInfo
     @return 信息
     */
    GisPointHaveFlexemInfo selectNetworkPointHaveFlexem(DevControlPanelInfo devControlPanelInfo);

    /**
     @author Wangchong
     @date 2021/11/13 17:23
     @description TODO 查询管网点位信息，附带相应点位的报警记录id
     @param networkPointInfo
     @return {@link NetworkPointWithAlarmId}
     */
    List<NetworkPointWithAlarmId> selectNetworkPointWithAlarmIdList(NetworkPointInfo networkPointInfo);

    /**
     @author Wangchong
     @date 2021/11/19 14:38
     @description TODO 查询点位编号,名称 添加工控屏时用
     @param
     @return Map<String, String>
     */
    List<Map<String, String>>selectNetworkPointNoAndName();

    /**
     @author Wangchong
     @date 2021/12/1 17:49
     @description TODO 查询有安装设备的管网点位的信息
     @param gisPointHaveFlexemInfo
     @return {@link GisPointHaveFlexemInfo}
     */
    List<GisPointHaveFlexemInfo> selectNetworkPointHaveDeviceList(GisPointHaveFlexemInfo gisPointHaveFlexemInfo);
	
	 int getNetworkSystemTypeRainPollutionNum();
    int getNetworkSystemTypeOilwaterNum();
    int getNetworkSystemTypePumpingNum();
}
