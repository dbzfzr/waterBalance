package com.zy.gis.controller.management;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.layui.LayuiTableResult;
import com.zy.gis.common.response.ResponseJSONObject;
import com.zy.gis.common.utils.DateUtil;
import com.zy.gis.pojo.RoleInfo;
import com.zy.gis.service.MenuService;
import com.zy.gis.service.RoleInfoService;
import com.zy.gis.service.RoleMenuService;
import com.zy.gis.util.MyUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/10 14:24
 */
@Controller
public class RoleController {

    Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    RoleInfoService roleInfoService;

    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private MenuService menuService;
    
    /**
     * @Description:获取所有角色类型
     * @author hhp
     * @date 2021/9/10 14:38 
     * @param roleInfo: 
     * @return {@link LayuiTableResult}
     */
    @RequestMapping(value = "getAllRoleInfo",method = RequestMethod.POST)
    @ResponseBody
    public LayuiTableResult getAllRoleInfo(@RequestBody RoleInfo roleInfo){
        logger.info("RoleInfo:"+roleInfo);
        int count = roleInfoService.getAllRoleInfoCount(roleInfo);
        List<RoleInfo> list = roleInfoService.getAllRoleInfo(roleInfo);

        return new LayuiTableResult(count,list);
    }

    /**
    @author Wangchong
    @date 2021/9/17 13:46
    @description TODO 获取角色信息包括角色的菜单名称
    @param roleInfo
    @return {@link LayuiTableResult}
    */
    @RequestMapping(value = "getRoleInfoList",method = RequestMethod.POST)
    @ResponseBody
    public LayuiTableResult getRoleInfoList(@RequestBody RoleInfo roleInfo){
        logger.info("RoleInfo:"+roleInfo);
        int count = roleInfoService.getAllRoleInfoCount(roleInfo);
        List<RoleInfo> list = roleInfoService.getAllRoleInfo(roleInfo);

        List<Integer> menuIds = null;
        List<String> menuNames = null;
        StringBuilder stringBuilder = new StringBuilder("");

        for (RoleInfo role : list){

            menuIds = roleMenuService.getRoleMenuIds(role.getRoleId());
            menuNames = menuService.selectMenuName(menuIds);

            for (String str : menuNames){
                stringBuilder.append(str).append(",");
            }
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));

            role.setRoleMenuNameStr(stringBuilder.toString());
            stringBuilder.delete(0, stringBuilder.length());
        }
        menuIds.clear();
        menuNames.clear();
        return new LayuiTableResult(count, list);
    }

    /**
     * @Description: 跳转至角色类型新增编辑页面
     * @author hhp
     * @date 2021/9/10 14:38 
     * @param id: 角色类型ID
     * @return {@link ModelAndView}
     */
    @RequestMapping("toAddRoleInfoPage")
    public ModelAndView toAddRoleInfoPage() {
        ModelAndView modelAndView = new ModelAndView("management/userManagement/addRole");
        return modelAndView;
    }

    /**
     * @Description: 新增角色类型
     * @author hhp
     * @date 2021/9/10 14:38
     * @modify 20210917 Wangchong 实现添加角色信息时 添加所拥有的菜单信息
     * @param roleInfo:
     * @param menuIds 菜单id 1,2,3
     * @return {@link JSONObject}
     */
    @RequestMapping("insertRoleInfoData")
    @ResponseBody
    public JSONObject insertRoleInfoData(RoleInfo roleInfo, String menuIds) {

        roleInfo.setCreateTime(MyUtil.getNowDateTime());
        roleInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = roleInfoService.insert(roleInfo);

        JSONObject paramJSONObject = new JSONObject();
        paramJSONObject.put("roleId", roleInfo.getRoleId());
        paramJSONObject.put("menuIds", Arrays.asList(menuIds.split(",")));
        roleMenuService.addRoleMenu(paramJSONObject);

        return ResponseJSONObject.retMsg(iRet,"角色类型新增");
    }

    /**
     * @Description: 更新角色类型数据
     * @author hhp
     * @date 2021/9/10 14:38 
     * @param roleInfo:
     * @return {@link JSONObject}
     */
//    @RequestMapping("updateRoleInfoData")
//    @ResponseBody
//    public JSONObject updateRoleInfoData(RoleInfo roleInfo) {
//        roleInfo.setUpdateTime(MyUtil.getNowDateTime());
//
//        int iRet = roleInfoService.updateByPrimaryKeySelective(roleInfo);
//        return ResponseJSONObject.retMsg(iRet,"角色类型更新");
//    }
    /**
    @author Wangchong
    @date 2021/11/22 16:11
    @description TODO 修改角色信息和角色的菜单信息
    @param paramJSONObject {"roleId": , "menuIds": , "roleName":""}
    @return
    */
    @RequestMapping("updateRoleInfoData")
    @ResponseBody
    public JSONObject updateRoleInfoData(@RequestBody JSONObject paramJSONObject) {
      String roleName = paramJSONObject.getString("roleName");
      if (StringUtils.isNotEmpty(roleName)){
          RoleInfo roleInfo = new RoleInfo();
          roleInfo.setRoleId(paramJSONObject.getInteger("roleId"));
          roleInfo.setRoleName(roleName);
          roleInfo.setUpdateTime(DateUtil.getNowTime());
          roleInfoService.updateByPrimaryKeySelective(roleInfo);
      }

      if (paramJSONObject.get("menuIds") != null){
          roleMenuService.modifyRoleMenu(paramJSONObject);
      }

      return ResponseJSONObject.success("操作成功");
    }

    /**
     * @Description: 删除角色类型
     * @author hhp
     * @date 2021/9/10 14:38 
     * @param roleId:
     * @return {@link JSONObject}
     */
    @RequestMapping("delRoleInfoData")
    @ResponseBody
    public JSONObject delRoleInfoData(int roleId) {
        int iRet = roleInfoService.deleteByPrimaryKey(roleId);
        return ResponseJSONObject.retMsg(iRet,"角色类型删除");
    }
}
