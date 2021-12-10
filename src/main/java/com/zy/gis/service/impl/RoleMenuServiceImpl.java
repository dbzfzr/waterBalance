package com.zy.gis.service.impl;

import com.alibaba.fastjson.JSONObject;

import com.zy.gis.mapper.RoleMenuMapper;
import com.zy.gis.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Transactional
    public void modifyRoleMenu(JSONObject param){

        if (null != param.getObject("menuIds", String[].class)) {

            JSONObject tempPrarm = new JSONObject();
            tempPrarm.put("roleId", param.getString("roleId"));
            deleteRoleMenu(tempPrarm);//先清空原先的角色菜单信息

            roleMenuMapper.insertRoleMenu(param);
        }
    }

    @Transactional
    public Integer deleteRoleMenu(JSONObject param){

        return roleMenuMapper.deleteRoleMenu(param);
    }

    /**
     * 根据角色id获取角色所对应的菜单权限的id
     * @param roleId 角色id
     * @return
     */
    public List<Integer> getRoleMenuIds(Integer roleId) {
        return roleMenuMapper.selectMenuId(roleId);
    }

    /**
     * 添加角色信息
     * @author Wangchong
     * @date 20201023
     * @param param  {"roleId":"","menuIds":[]}参数
     * @return 条数
     */
    @Transactional
    public Integer addRoleMenu(JSONObject param){

        return roleMenuMapper.insertRoleMenu(param);
    }
}
