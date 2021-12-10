package com.zy.gis.service;

import com.zy.gis.pojo.RoleInfo;
import com.zy.gis.pojo.devAndFacility.DevTypeInfo;

import java.util.List;

public interface RoleInfoService {
    List<RoleInfo> getRoleInfoList(RoleInfo roleInfo);

    int insert(RoleInfo record);

    int updateByPrimaryKeySelective(RoleInfo record);

    int deleteByPrimaryKey(Integer roleId);

    RoleInfo selectByPrimaryKey(Integer roleId);

    List<RoleInfo> getAllRoleInfo(RoleInfo roleInfo);

    int getAllRoleInfoCount(RoleInfo roleInfo);

}
