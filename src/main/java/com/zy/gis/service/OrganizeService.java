package com.zy.gis.service;

import com.zy.gis.pojo.EasyUITreeInfo;
import com.zy.gis.pojo.OrganizeInfo;
import com.zy.gis.pojo.devAndFacility.SystemTypeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizeService {

    int insertSelective(OrganizeInfo organizeInfo);

    OrganizeInfo selectByPrimaryKey(Integer id);

    List<EasyUITreeInfo> queryChildrenOrganize(@Param("pId") String pId);

    List<EasyUITreeInfo> queryChildrenOrganizeByLevel(@Param("iconCls") String iconCls,List<SystemTypeInfo> systemTypeInfoList);

    List<EasyUITreeInfo> queryRegionSelectionChildrenOrganizeByLevel(@Param("iconCls") String iconCls, List<SystemTypeInfo> systemTypeInfoList);

    List<OrganizeInfo> getAllOrganize(OrganizeInfo organizeInfo);

    List<OrganizeInfo> getNodeLevel(OrganizeInfo organizeInfo);

    int updateByPrimaryKeySelective(OrganizeInfo record);

    int deleteByPrimaryKey(Integer id);
}
