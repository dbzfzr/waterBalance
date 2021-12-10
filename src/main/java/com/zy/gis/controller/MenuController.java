package com.zy.gis.controller;

import com.zy.gis.pojo.EasyUITreeInfo;

import com.zy.gis.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
@author Wangchong
@date 2021/9/16 19:48
@description TODO
@param
@return
*/
@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
    @author Wangchong
    @date 2021/9/16 19:52
    @description TODO 获取所有菜单信息
    @param
    @return  List<EasyUITreeInfo>
    */
    @RequestMapping("getAllMenuInfoList")
    @ResponseBody
    public List<EasyUITreeInfo> getAllMenuInfoList(){

        Session session = SecurityUtils.getSubject().getSession();
        if (null == session){
            return null;
        }

        return (List<EasyUITreeInfo>) menuService.getMenuEasyUITreeInfo(null).get("menuTree");
    }

    /**
    @author Wangchong
    @date 2021/9/17 14:30
    @description TODO 根据角色id查询所对应的菜单信息树形结构
    @param roleId
    @return List<EasyUITreeInfo>
    */
    @RequestMapping("getMenuInfoListByRoleId")
    @ResponseBody
    public List<EasyUITreeInfo> getMenuInfoListByRoleId(@RequestParam("roleId")Integer roleId){

        return (List<EasyUITreeInfo>) menuService.getMenuEasyUITreeInfo(roleId).get("menuTree");
    }
}
