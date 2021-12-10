package com.zy.gis.service;

import com.zy.gis.pojo.devAndFacility.NetworkPointTypeInfo;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/4 15:26
 */
public interface NetworkPointTypeService {

    int insert(NetworkPointTypeInfo record);

    int updateByPrimaryKeySelective(NetworkPointTypeInfo record);

    int deleteByPrimaryKey(Integer id);

    NetworkPointTypeInfo selectByPrimaryKey(Integer id);

    List<NetworkPointTypeInfo> getAllNetworkPointType(NetworkPointTypeInfo networkPointTypeInfo);

    int getAllNetworkPointTypeCount(NetworkPointTypeInfo networkPointTypeInfo);
}
