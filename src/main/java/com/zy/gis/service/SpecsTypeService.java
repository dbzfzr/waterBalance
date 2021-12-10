package com.zy.gis.service;

import com.zy.gis.pojo.devAndFacility.SpecsTypeInfo;
import com.zy.gis.pojo.devAndFacility.SystemTypeInfo;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/6 9:20
 */
public interface SpecsTypeService {

    int insert(SpecsTypeInfo record);

    int updateByPrimaryKeySelective(SpecsTypeInfo record);

    int deleteByPrimaryKey(Integer id);

    SpecsTypeInfo selectByPrimaryKey(Integer id);

    List<SpecsTypeInfo> getAllSpecsType(SpecsTypeInfo specsTypeInfo);

    int getAllSpecsTypeCount(SpecsTypeInfo specsTypeInfo);
}
