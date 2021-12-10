package com.zy.gis.service.impl;

import com.alibaba.fastjson.JSONObject;

import com.zy.gis.mapper.MenuInfoMapper;
import com.zy.gis.mapper.RoleInfoMapper;
import com.zy.gis.mapper.RoleMenuMapper;
import com.zy.gis.mapper.UserInfoMapper;
import com.zy.gis.pojo.EasyUITreeInfo;
import com.zy.gis.pojo.MenuInfo;
import com.zy.gis.pojo.RoleInfo;
import com.zy.gis.service.MenuService;
import com.zy.gis.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Autowired
    private MenuInfoMapper menuInfoMapper;

    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private RoleInfoMapper roleInfoMapper;


    /**
     * 获取用户对应的菜单信息
     * @param userId 用户id
     * @return  菜单信息
     */
    public List<MenuInfo> selectMenuInfo(Integer userId){

        Integer roleId = userInfoMapper.selectByPrimaryKey(userId).getRoleId();
        List<Integer> menuIds = new ArrayList<>();

        if (roleId != 1) {// 管理员
            menuIds =  roleMenuMapper.selectMenuId(roleId);
        }
        List<MenuInfo> menuInfos = menuInfoMapper.selectMenuInfo(menuIds);
        return menuInfos;
    }

    /**
     * 获取所有的菜单信息，封装成easytree的形式，根据角色id对应的菜单权限id设置菜单树形组织的选中状态
     * @author Wangchong
     * @date 20210916
     * @param roleId 角色id 可以为空
     * @return List<EasyUITreeInfo>
     */
    public JSONObject getMenuEasyUITreeInfo(Integer roleId){
        List<EasyUITreeInfo> menuEasyUITreeInfo = menuInfoMapper.selectPrimaryNavigation();

        List<Integer> roleMenuIds = null;
        JSONObject msg = new JSONObject();

        if (null != roleId) {//角色id不为空的话

            RoleInfo roleInfo = roleInfoMapper.selectByPrimaryKey(roleId);

            if ("管理员".equals(roleInfo.getRoleName())){
                roleMenuIds = menuInfoMapper.selectAllMenuIds();
            }else {
                roleMenuIds = roleMenuService.getRoleMenuIds(roleId);// 角色所拥有的菜单权限信息的id
            }
            msg.put("roleMenuIds", roleMenuIds);
        }

        getChildrenMenuEasyUITreeInfo(menuEasyUITreeInfo);

        if ( null != roleMenuIds) {
            setEasyUITreeInfoChecked(roleMenuIds, menuEasyUITreeInfo);
        }

        msg.put("menuTree", menuEasyUITreeInfo);

        return msg;
    }

    /**
     * 递归查询子菜单信息
     * @author Wangchong
     * @date 20210916
     * @param easyUITreeInfoList
     */
    public void getChildrenMenuEasyUITreeInfo(List<EasyUITreeInfo> easyUITreeInfoList){

        for (EasyUITreeInfo easyUITreeInfo : easyUITreeInfoList) {
            List<EasyUITreeInfo> tempEasyUITreeInfo = menuInfoMapper.selectMenuByParentId(Integer.valueOf(easyUITreeInfo.getId()));

           if (tempEasyUITreeInfo.size() > 0){ //递归查询子菜单信息
                easyUITreeInfo.setChildren(tempEasyUITreeInfo);
                getChildrenMenuEasyUITreeInfo(tempEasyUITreeInfo);
            }
        }
    }

    /**
     * 设置EasyUITreeInfo的选中状态
     * @author Wangchong
     * @date 20210916
     * @param roleMenuIds 角色id对应的角色拥有的菜单id
     * @param menuEasyUITreeInfo 菜单信息
     */
    public void setEasyUITreeInfoChecked(List<Integer> roleMenuIds, List<EasyUITreeInfo> menuEasyUITreeInfo) {

            for (EasyUITreeInfo easyUITreeInfo : menuEasyUITreeInfo) {

                // 节点的子节点不为空的话，此节点不能设置为选中。父节点被选中，EasyUITreeInfo会默认所有子节点被选中，会出现渲染不正确的问题
                if (null == easyUITreeInfo.getChildren()) {
                    for (Integer i : roleMenuIds) {
                        if (i == Integer.valueOf(easyUITreeInfo.getId())) {
                            easyUITreeInfo.setChecked(true);
                        }
                    }

                }else {
                    setEasyUITreeInfoChecked(roleMenuIds, easyUITreeInfo.getChildren());//递归设置节点选中状态
                }
            }
    }

    /**
     * 获取菜单名称
     * @param menuIds 菜单id
     * @return
     */
    public List<String> selectMenuName(List<Integer> menuIds){
        return menuInfoMapper.selectMenuName(menuIds);
    }

    /**
     @author Wangchong
     @date 2021/11/11 11:55
     @description TODO 查询菜单信息
     @param menuInfo
     @return {@Link MenuInfo}
     */
    public List<MenuInfo>selectMenuInfoList(MenuInfo menuInfo){
        return menuInfoMapper.selectMenuInfoList(menuInfo);
    }

   public List<Integer> selectAllMenuIds(){
        return menuInfoMapper.selectAllMenuIds();
   }
}
