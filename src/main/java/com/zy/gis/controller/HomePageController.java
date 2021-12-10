package com.zy.gis.controller;

import com.zy.gis.common.utils.ConfigUtil;
import com.zy.gis.pojo.MenuInfo;
import com.zy.gis.pojo.UserInfo;
import com.zy.gis.pojo.flexem.AlarmDispatch;
import com.zy.gis.service.AlarmDispatchService;
import com.zy.gis.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private AlarmDispatchService alarmDispatchService;

    /**
    @author Wangchong
    @date 2021/9/16 17:04
    @description TODO 返回主页面的标题 导航栏
    @param
    @return
    */
    @RequestMapping("mainHeadTitle")
    public String mainHeadTitlePage(Model model){

        model.addAttribute("projectName", ConfigUtil.projectName);

        Session session = SecurityUtils.getSubject().getSession();
        UserInfo userInfo = null;
        Object obj = session.getAttribute("users");

        if (obj instanceof UserInfo){
            userInfo = (UserInfo)obj;
            List<MenuInfo> menuInfoList = menuService.selectMenuInfo(userInfo.getUserId());
            model.addAttribute("menuInfoList", menuInfoList);

            Integer roleId = userInfo.getRoleId();
            String roleName = userInfo.getRoleName();

            if (roleName.equals("运维操作人员") || roleId == 14){
                AlarmDispatch alarmDispatch = new AlarmDispatch();
                alarmDispatch.setDispatchToUserId(userInfo.getUserId());
                alarmDispatch.setHandleState("未处理");
                Integer alarmDispatchCount = alarmDispatchService.selectAlarmDispatchCount(alarmDispatch);
                if (alarmDispatchCount != 0){
                    model.addAttribute("alarmDispatchCount", alarmDispatchCount);
                }
            }
        }
        return "mainHeadTitle";
    }

    @RequestMapping("yuwuHeadTitle")
    public String yuwuHeadTitlePage(Model model){

        model.addAttribute("yuwufenliuName", ConfigUtil.yuwufenliuName);

        Session session = SecurityUtils.getSubject().getSession();
        UserInfo userInfo = null;
        Object obj = session.getAttribute("users");

        if (obj instanceof UserInfo){
            userInfo = (UserInfo)obj;
            List<MenuInfo> menuInfoList = menuService.selectMenuInfo(userInfo.getUserId());
            model.addAttribute("menuInfoList", menuInfoList);

            Integer roleId = userInfo.getRoleId();
            String roleName = userInfo.getRoleName();

            if (roleName.equals("运维操作人员") || roleId == 14){
                AlarmDispatch alarmDispatch = new AlarmDispatch();
                alarmDispatch.setDispatchToUserId(userInfo.getUserId());
                alarmDispatch.setHandleState("未处理");
                Integer alarmDispatchCount = alarmDispatchService.selectAlarmDispatchCount(alarmDispatch);
                if (alarmDispatchCount != 0){
                    model.addAttribute("alarmDispatchCount", alarmDispatchCount);
                }
            }
        }
        return "yuwuHeadTitle";
    }


    @RequestMapping("youshuiHeadTitle")
    public String youshuiHeadTitlePage(Model model){

        model.addAttribute("youshuifenliName", ConfigUtil.youshuifenliName);

        Session session = SecurityUtils.getSubject().getSession();
        UserInfo userInfo = null;
        Object obj = session.getAttribute("users");

        if (obj instanceof UserInfo){
            userInfo = (UserInfo)obj;
            List<MenuInfo> menuInfoList = menuService.selectMenuInfo(userInfo.getUserId());
            model.addAttribute("menuInfoList", menuInfoList);

            Integer roleId = userInfo.getRoleId();
            String roleName = userInfo.getRoleName();

            if (roleName.equals("运维操作人员") || roleId == 14){
                AlarmDispatch alarmDispatch = new AlarmDispatch();
                alarmDispatch.setDispatchToUserId(userInfo.getUserId());
                alarmDispatch.setHandleState("未处理");
                Integer alarmDispatchCount = alarmDispatchService.selectAlarmDispatchCount(alarmDispatch);
                if (alarmDispatchCount != 0){
                    model.addAttribute("alarmDispatchCount", alarmDispatchCount);
                }
            }
        }
        return "youshuiHeadTitle";
    }





    @RequestMapping("/")
    public String indexPage(Model model){
        return mainHeadTitlePage(model);
    }


    @RequestMapping("homePage")
    public String homePage(Model model){
        model.addAttribute("projectName", ConfigUtil.projectName);
        return "homePage";
    }


    @RequestMapping("oilWaterSubPage")
    public String oilWaterSubPage(Model model){
        model.addAttribute("youshuifenliName", ConfigUtil.youshuifenliName);
        return "oilWaterSubPage";
    }

    @RequestMapping("rainPollutionSubPage")
    public String rainPollutionSubPage(Model model){
        model.addAttribute("yuwufenliuName", ConfigUtil.youshuifenliName);
        return "rainPollutionSubPage";
    }


    /**
     @author Wangchong
     @date 2021/10/18 10:04
     @description TODO 返回 gis 三维地图页面 并携带模型地址数据
     @param model
     @return
     */
    @RequestMapping("gisPage")
    public String gisPage(Model model){
        model.addAttribute("gisModelHost", ConfigUtil.getGisModelHost());
        return "gis";
    }

    @RequestMapping("main")
    public String mainPage(Model model){
        model.addAttribute("projectName", ConfigUtil.projectName);
        return "main";
    }
}
