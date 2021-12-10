package com.zy.gis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.mapper.RoleInfoMapper;
import com.zy.gis.mapper.RoleMenuMapper;
import com.zy.gis.pojo.RoleInfo;
import com.zy.gis.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

   public  List<RoleInfo> getRoleInfoList(RoleInfo roleInfo){
       return roleInfoMapper.getRoleInfoList(roleInfo);
   }

    @Override
    @Transactional
    public int insert(RoleInfo record) {
        return roleInfoMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(RoleInfo record) {
        return roleInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int deleteByPrimaryKey(Integer roleId) {

        JSONObject paramJSONObject = new JSONObject();
        paramJSONObject.put("roleId", roleId);
        roleMenuMapper.deleteRoleMenu(paramJSONObject);

        return roleInfoMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public RoleInfo selectByPrimaryKey(Integer roleId) {
        return roleInfoMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public List<RoleInfo> getAllRoleInfo(RoleInfo roleInfo) {
        return roleInfoMapper.getAllRoleInfo(roleInfo);
    }

    @Override
    public int getAllRoleInfoCount(RoleInfo roleInfo) {
        return roleInfoMapper.getAllRoleInfoCount(roleInfo);
    }
}
