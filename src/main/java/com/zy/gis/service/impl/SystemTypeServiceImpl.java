package com.zy.gis.service.impl;

import com.zy.gis.mapper.devAndFacility.SystemTypeInfoMapper;
import com.zy.gis.pojo.devAndFacility.SystemTypeInfo;
import com.zy.gis.service.SystemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/4 18:09
 */
@Service
public class SystemTypeServiceImpl implements SystemTypeService {

    @Autowired
    SystemTypeInfoMapper systemTypeInfoMapper;

    @Override
    public int insert(SystemTypeInfo record) {
        return systemTypeInfoMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(SystemTypeInfo record) {
        return systemTypeInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return systemTypeInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SystemTypeInfo selectByPrimaryKey(Integer id) {
        return systemTypeInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SystemTypeInfo> getAllSystemType(SystemTypeInfo systemTypeInfo) {
        return systemTypeInfoMapper.getAllSystemType(systemTypeInfo);
    }

    @Override
    public int getAllSystemTypeCount(SystemTypeInfo systemTypeInfo) {
        return systemTypeInfoMapper.getAllSystemTypeCount(systemTypeInfo);
    }

    @Override
    public List<SystemTypeInfo> getDevTypeNameGroup(String  systemTypeName) {
        return systemTypeInfoMapper.getDevTypeNameGroup(systemTypeName);
    }
}
