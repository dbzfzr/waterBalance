package com.zy.gis.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMenuService {

    /**
     * 更改角色菜单信息
     * @param param
     */
   void modifyRoleMenu(JSONObject param);

   Integer deleteRoleMenu(JSONObject param);

    /**
     * 根据角色id获取角色所对应的菜单权限的id
     * @param roleId 角色id
     * @return
     */
     List<Integer> getRoleMenuIds(Integer roleId);

    /**
     * 添加角色信息
     * @author Wangchong
     * @date 20201023
     * @param param 参数
     * @return 条数
     */
    Integer addRoleMenu(JSONObject param);
}
