package com.zy.gis.service.impl;

import com.zy.gis.mapper.devAndFacility.MaterialTypeInfoMapper;
import com.zy.gis.pojo.devAndFacility.MaterialTypeInfo;
import com.zy.gis.service.MaterialTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/4 16:24
 */
@Service
public class MaterialTypeServiceImpl implements MaterialTypeService {

    @Autowired
    MaterialTypeInfoMapper materialTypeInfoMapper;

    @Override
    public int insert(MaterialTypeInfo record) {
        return materialTypeInfoMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(MaterialTypeInfo record) {
        return materialTypeInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return materialTypeInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public MaterialTypeInfo selectByPrimaryKey(Integer id) {
        return materialTypeInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<MaterialTypeInfo> getAllMaterialType(MaterialTypeInfo materialTypeInfo) {
        return materialTypeInfoMapper.getAllMaterialType(materialTypeInfo);
    }

    @Override
    public int getAllMaterialTypeCount(MaterialTypeInfo materialTypeInfo) {
        return materialTypeInfoMapper.getAllMaterialTypeCount(materialTypeInfo);
    }
}
