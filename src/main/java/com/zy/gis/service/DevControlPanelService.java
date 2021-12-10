package com.zy.gis.service;

import com.zy.gis.pojo.devAndFacility.DevControlPanelInfo;
import com.zy.gis.pojo.devAndFacility.NetworkPointInfo;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/8 15:43
 */
public interface DevControlPanelService {

    int insertSelective(DevControlPanelInfo record);

    int updateByPrimaryKeySelective(DevControlPanelInfo record);

    int deleteByPrimaryKey(Integer id);

    DevControlPanelInfo selectByPrimaryKey(Integer id);

    List<DevControlPanelInfo> getAllDevControlPanelInfo(DevControlPanelInfo record);

    List<DevControlPanelInfo> getAllDevControlPanelInfo(String organizeId);

    int getAllDevControlPanelCount(DevControlPanelInfo record);

    int updateDevControlPanelByBoxNo(DevControlPanelInfo record);

    /**
     @author Wangchong
     @date 2021/10/30 11:23
     @description TODO 查询所有繁易屏设备编号
     @return 设备编号
     */
    List<String> selectAllBoxNo();
}
