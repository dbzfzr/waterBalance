package com.zy.gis.service;

import com.zy.gis.pojo.devAndFacility.MaterialTypeInfo;
import com.zy.gis.pojo.devAndFacility.SystemTypeInfo;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/4 18:08
 */
public interface SystemTypeService {
    int insert(SystemTypeInfo record);

    int updateByPrimaryKeySelective(SystemTypeInfo record);

    int deleteByPrimaryKey(Integer id);

    SystemTypeInfo selectByPrimaryKey(Integer id);

    List<SystemTypeInfo> getAllSystemType(SystemTypeInfo systemTypeInfo);

    int getAllSystemTypeCount(SystemTypeInfo systemTypeInfo);

    List<SystemTypeInfo>  getDevTypeNameGroup(String systemTypeName);

}
