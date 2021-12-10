package com.zy.gis.mapper;

import com.zy.gis.pojo.OrganizeRegionInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizeRegionInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrganizeRegionInfo record);

    int insertSelective(OrganizeRegionInfo record);

    OrganizeRegionInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrganizeRegionInfo record);

    int updateByPrimaryKey(OrganizeRegionInfo record);

    List<OrganizeRegionInfo> selectRegionInfo(OrganizeRegionInfo record);

    int deleteByOrganizeId(Integer organizeId);
}