package com.zy.gis.service.impl;

import com.zy.gis.mapper.devAndFacility.NetworkPointTypeInfoMapper;
import com.zy.gis.pojo.devAndFacility.NetworkPointTypeInfo;
import com.zy.gis.service.NetworkPointTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/4 15:26
 */
@Service
public class NetworkPointTypeServiceImpl implements NetworkPointTypeService {

    @Autowired
    NetworkPointTypeInfoMapper networkPointTypeInfoMapper;


    @Override
    public int insert(NetworkPointTypeInfo record) {
        return networkPointTypeInfoMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(NetworkPointTypeInfo record) {
        return networkPointTypeInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return networkPointTypeInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public NetworkPointTypeInfo selectByPrimaryKey(Integer id) {
        return networkPointTypeInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<NetworkPointTypeInfo> getAllNetworkPointType(NetworkPointTypeInfo networkPointTypeInfo) {
        return networkPointTypeInfoMapper.getAllNetworkPointType(networkPointTypeInfo);
    }

    @Override
    public int getAllNetworkPointTypeCount(NetworkPointTypeInfo networkPointTypeInfo) {
        return networkPointTypeInfoMapper.getAllNetworkPointTypeCount(networkPointTypeInfo);
    }
}
