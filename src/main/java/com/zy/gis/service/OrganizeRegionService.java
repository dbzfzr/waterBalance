package com.zy.gis.service;

import com.zy.gis.pojo.OrganizeRegionInfo;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/28 14:08
 */
public interface OrganizeRegionService {

    int deleteByPrimaryKey(Integer id);

    int insertOrganizeRegionList(List<OrganizeRegionInfo> recordList);

    int updateByPrimaryKeySelective(OrganizeRegionInfo record);

    List<OrganizeRegionInfo> selectRegionInfo(OrganizeRegionInfo record);

    int deleteByOrganizeId(Integer organizeId);
}
