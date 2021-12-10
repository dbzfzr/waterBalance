package com.zy.gis.service;

import com.zy.gis.pojo.devAndFacility.MaterialTypeInfo;
import com.zy.gis.pojo.devAndFacility.NetworkPointTypeInfo;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/4 16:23
 */
public interface MaterialTypeService {

    int insert(MaterialTypeInfo record);

    int updateByPrimaryKeySelective(MaterialTypeInfo record);

    int deleteByPrimaryKey(Integer id);

    MaterialTypeInfo selectByPrimaryKey(Integer id);

    List<MaterialTypeInfo> getAllMaterialType(MaterialTypeInfo materialTypeInfo);

    int getAllMaterialTypeCount(MaterialTypeInfo materialTypeInfo);
}
