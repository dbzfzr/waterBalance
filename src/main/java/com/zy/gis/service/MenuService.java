package com.zy.gis.service;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.pojo.EasyUITreeInfo;
import com.zy.gis.pojo.MenuInfo;

import java.util.List;

public interface MenuService {

    /**
     * 获取用户对应的菜单信息
     * @param userId 用户id
     * @return  菜单信息
     */
      List<MenuInfo> selectMenuInfo(Integer userId);

    /**
     * 获取所有的菜单信息，封装成easytree的形式，根据角色id对应的菜单权限id设置菜单树形组织的选中状态
     * @param roleId 角色id
     * @return List<EasyUITreeInfo>
     */
    JSONObject getMenuEasyUITreeInfo(Integer roleId);

    /**
     * 递归查询子菜单信息
     * @param EasyUITreeInfoList
     */
    void getChildrenMenuEasyUITreeInfo(List<EasyUITreeInfo> EasyUITreeInfoList);

    /**
     * 设置easytree的选中状态
     * @param roleMenuIds
     * @param menuEasyUITreeInfo
     */
    void setEasyUITreeInfoChecked(List<Integer> roleMenuIds, List<EasyUITreeInfo> menuEasyUITreeInfo);

    /**
     * 获取菜单名称
     * @param menuIds 菜单id
     * @return
     */
    List<String> selectMenuName(List<Integer> menuIds);

    /**
     @author Wangchong
     @date 2021/11/11 11:55
     @description TODO 查询菜单信息
     @param menuInfo
     @return {@Link MenuInfo}
     */
    List<MenuInfo>selectMenuInfoList(MenuInfo menuInfo);

    List<Integer> selectAllMenuIds();

}
