package com.zy.gis.service.impl;

import com.zy.gis.mapper.devAndFacility.SpecsTypeInfoMapper;
import com.zy.gis.pojo.devAndFacility.SpecsTypeInfo;
import com.zy.gis.service.SpecsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/6 9:20
 */
@Service
public class SpecsTypeServiceImpl implements SpecsTypeService {

    @Autowired
    SpecsTypeInfoMapper specsTypeInfoMapper;

    @Override
    public int insert(SpecsTypeInfo record) {
        return specsTypeInfoMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(SpecsTypeInfo record) {
        return specsTypeInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return specsTypeInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SpecsTypeInfo selectByPrimaryKey(Integer id) {
        return specsTypeInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SpecsTypeInfo> getAllSpecsType(SpecsTypeInfo specsTypeInfo) {
        return specsTypeInfoMapper.getAllSpecsType(specsTypeInfo);
    }

    @Override
    public int getAllSpecsTypeCount(SpecsTypeInfo specsTypeInfo) {
        return specsTypeInfoMapper.getAllSpecsTypeCount(specsTypeInfo);
    }
}
