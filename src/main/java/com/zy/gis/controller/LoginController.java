package com.zy.gis.controller;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.exception.ServiceException;
import com.zy.gis.common.utils.ConfigUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录控制器
 * @author Wangchong
 * @date 202108201220
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("loginPage")
    public String loginPage(Model model){
        model.addAttribute("projectName", ConfigUtil.projectName);
        return "loginPage";
    }

    @RequestMapping("yuwuloginPage")
    public String yuwufenliuName(Model model){
        model.addAttribute("yuwufenliuName", ConfigUtil.yuwufenliuName);
        return "yuwuloginPage";
    }

    @RequestMapping("youshuiloginPage")
    public String youshuifenliName(Model model){
        model.addAttribute("youshuifenliName", ConfigUtil.youshuifenliName);
        return "youshuiloginPage";
    }


    /**
     * 登录系统
     * @author Wangchong
     * @date 202108201501
     * @param requestBody{"username":"", "password":""}
     * @return
     */
    @RequestMapping(value = "checkLogin", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject checkLogin(@RequestBody JSONObject requestBody) {

        JSONObject responseBody = new JSONObject();

//        String username = (String)requestBody.get("username");
//
//        if (StringUtils.isBlank(username)){
//               throw new ServiceException("用户名为空");
//        }

        String phone = requestBody.getString("username");
        if (StringUtils.isBlank(phone)){
            throw new ServiceException("手机号为空");
        }

        String password = (String)requestBody.get("password");

        if (StringUtils.isBlank(password)){
               throw new ServiceException("密码为空");
        }

        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(phone, password);
            try {
                currentUser.login(usernamePasswordToken);
            }catch (RuntimeException exception){
                throw new ServiceException("手机号或密码错误!");
            }
        }

        logger.info(phone + "登录成功");
        responseBody.put("code" , 1);
        responseBody.put("message" , "登录成功");
        return responseBody;
    }
}
