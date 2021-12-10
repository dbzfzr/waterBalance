package com.zy.gis.service;

import com.zy.gis.pojo.devAndFacility.DevTypeInfo;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/2 17:56
 */
public interface DevTypeService {

    int insert(DevTypeInfo record);

    int updateByPrimaryKeySelective(DevTypeInfo record);

    int deleteByPrimaryKey(Integer id);

    DevTypeInfo selectByPrimaryKey(Integer id);

    List<DevTypeInfo> getAllDevType(DevTypeInfo devTypeInfo);

    int getAllDevTypeCount(DevTypeInfo devTypeInfo);
}
