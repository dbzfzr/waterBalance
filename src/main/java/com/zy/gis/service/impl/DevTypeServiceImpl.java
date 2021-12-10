package com.zy.gis.service.impl;

import com.zy.gis.mapper.devAndFacility.DevTypeInfoMapper;
import com.zy.gis.pojo.devAndFacility.DevTypeInfo;
import com.zy.gis.service.DevTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/2 17:56
 */
@Service
public class DevTypeServiceImpl implements DevTypeService {

    @Autowired
    DevTypeInfoMapper devTypeInfoMapper;

    @Override
    public int insert(DevTypeInfo record) {
        return devTypeInfoMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(DevTypeInfo record) {
        return devTypeInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return devTypeInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public DevTypeInfo selectByPrimaryKey(Integer id) {
        return devTypeInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DevTypeInfo> getAllDevType(DevTypeInfo devTypeInfo) {
        return devTypeInfoMapper.getAllDevType(devTypeInfo);
    }

    @Override
    public int getAllDevTypeCount(DevTypeInfo devTypeInfo) {
        return devTypeInfoMapper.getAllDevTypeCount(devTypeInfo);
    }
}
