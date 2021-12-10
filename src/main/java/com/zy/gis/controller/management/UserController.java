package com.zy.gis.controller.management;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.exception.ServiceException;
import com.zy.gis.common.layui.LayuiTableResult;
import com.zy.gis.common.response.ResponseJSONObject;
import com.zy.gis.pojo.RoleInfo;
import com.zy.gis.pojo.UserInfo;
import com.zy.gis.service.RoleInfoService;
import com.zy.gis.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户信息操作控制器
 * @author Wangchong
 * @date 202108201726
 *
 */
@Controller
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RoleInfoService roleInfoService;

    @Autowired
    private UserService userService;


    /**
     * 查询用户信息
     * @author Wangchong
     * @date 202108201742
     * @param userInfo
     * @return 用户信息
     */
    @RequestMapping("getUserInfoList")
    @ResponseBody
    public LayuiTableResult getUserInfoList(@RequestBody UserInfo userInfo){
        logger.info("userInfo:" + userInfo);
//        if (userInfo.getPage() != null && userInfo.getLimit() != null){
//            userInfo.setOffSet((userInfo.getPage() - 1) * userInfo.getLimit());
//        }
        List<UserInfo> userInfoList = userService.getUserInfoList(userInfo);
        Integer count = userService.getUserInfoListCount(userInfo);

        return new LayuiTableResult(count, userInfoList);
    }

    /**
     * 添加用户
     * @author Wangchong
     * @date 202108231721
     * @param userInfo 用户信息
     * @return{"code":,"message"}
     */
    @RequestMapping("addUser")
    @ResponseBody
    public JSONObject addUser(@RequestBody UserInfo userInfo){
        String userName = userInfo.getUserName();
        if (StringUtils.isEmpty(userName)){
            throw new ServiceException("用户名为空");
        }

        UserInfo tempUserInfo = userService.getUserInfoByUserName(userName);
        if (null != tempUserInfo){
            throw new ServiceException("用户已存在");
        }

        String password = userInfo.getPassword();
        if (StringUtils.isEmpty(password)){
            throw new ServiceException("密码为空");
        }
        userService.insertUserSelective(userInfo);
        return ResponseJSONObject.success("添加用户成功");
    }

    @RequestMapping("userAddPage")
    public String userAddPage(Model model){
        List<RoleInfo> roleInfoList = roleInfoService.getRoleInfoList(new RoleInfo());
        model.addAttribute("roleInfoList", roleInfoList);
        return "management/userManagement/userAddPage";
    }

    /**
     * 删除用户信息
     * @author Wangchong
     * @date 202108261720
     * @param userInfo
     * @return
     */
    @RequestMapping("delUserInfo")
    @ResponseBody
    public JSONObject delUserInfo(@RequestBody UserInfo userInfo){
         if (null == userInfo){
             throw new ServiceException("用户信息为空!");
         }

         userService.deleteByPrimaryKey(userInfo.getUserId());

         return ResponseJSONObject.success("删除用户成功!");
    }
}