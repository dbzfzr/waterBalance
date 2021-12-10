package com.zy.gis.controller.management.operationManagement;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.layui.LayuiTableResult;
import com.zy.gis.common.response.ResponseJSONObject;
import com.zy.gis.common.utils.DateUtil;
import com.zy.gis.orm.qo.QueryParameter;
import com.zy.gis.pojo.*;
import com.zy.gis.service.AlarmDispatchRuleService;
import com.zy.gis.service.AlarmRuleService;
import com.zy.gis.service.MenuService;
import com.zy.gis.service.OrganizeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
@author Wangchong
@date 2021/10/26 15:34
@description TODO 运维管理
*/
@Controller
public class OperationManagementController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private OrganizeService organizeService;

    @Autowired
    private AlarmDispatchRuleService alarmDispatchRuleService;

    @Autowired
    private AlarmRuleService alarmRuleService;

    /**
    @author Wangchong
    @date 2021/10/26 15:36
    @description TODO 运维管理页面
    @return
    */
    @RequestMapping("operationManagementPage")
    public String operationManagementPage(Model model){
        Session session = SecurityUtils.getSubject().getSession();
        UserInfo userInfo = null;
        Object obj = session.getAttribute("users");

        if (obj instanceof UserInfo) {
            userInfo = (UserInfo) obj;
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("roleName", userInfo.getRoleName());
            jsonObject.put("userId", userInfo.getUserId());
            jsonObject.put("userName", userInfo.getUserName());

            model.addAttribute("user", jsonObject);

            List<MenuInfo> menuInfoList = menuService.selectMenuInfo(userInfo.getUserId());
            model.addAttribute("menuInfoList", menuInfoList);
        }
        return "management/operationManagement/operationManagement";
    }

    /**
    @author Wangchong
    @date 2021/11/30 11:39
    @description TODO 报警派单规则页面
    @param
    @return
    */
    @RequestMapping("alarmDispatchRulePage")
    public String alarmDispatchRulePage(Model model){
        Session session = SecurityUtils.getSubject().getSession();
        UserInfo userInfo = null;
        Object obj = session.getAttribute("users");

        if (obj instanceof UserInfo) {
            userInfo = (UserInfo) obj;
            OrganizeInfo organizeInfo = new OrganizeInfo();
            organizeInfo.setpId(userInfo.getOrganizationCode());
            List<OrganizeInfo> organizeInfoList = organizeService.getAllOrganize(organizeInfo);

            model.addAttribute("organizeInfoList", organizeInfoList);
        }
        return "management/operationManagement/alarmDispatchRule";
    }

    /**
    @author Wangchong
    @date 2021/11/30 19:35
    @description TODO 添加报警派单规则
    @param alarmDispatchRule
    @return
    */
    @RequestMapping("insertAlarmDispatchRule")
    @ResponseBody
    public JSONObject insertAlarmDispatchRule(@RequestBody AlarmDispatchRule alarmDispatchRule){

        JSONObject paramJSONObject = new JSONObject();
        paramJSONObject.put("organizationCode", alarmDispatchRule.getOrganizationCode());
        paramJSONObject.put("dispatchToUserId", alarmDispatchRule.getDispatchToUserId());
        paramJSONObject.put("alarmType", alarmDispatchRule.getAlarmType());

        Integer count = alarmDispatchRuleService.selectAlarmDispatchRuleCount(paramJSONObject);
        if (count > 0){
            return ResponseJSONObject.fail("规则已存在");
        }
        String timeStr = DateUtil.getNowTime();
        alarmDispatchRule.setCreateTime(timeStr);
        alarmDispatchRuleService.insertSelective(alarmDispatchRule);

        return ResponseJSONObject.success("添加成功");
    }

    /**
    @author Wangchong
    @date 2021/11/30 19:39
    @description TODO 查询报警派单规则
    @param paramJSONObject
    @return {@link LayuiTableResult}
    */
    @RequestMapping("selectAlarmDispatchRuleList")
    @ResponseBody
    public LayuiTableResult selectAlarmDispatchRuleList(@RequestBody JSONObject paramJSONObject){
        Integer page = paramJSONObject.getInteger("page");
        Integer limit = paramJSONObject.getInteger("limit");
        if (page != null && limit != null){
            Integer offset = (page - 1) * limit;
            paramJSONObject.put("offset", offset);
        }

        List<AlarmDispatchRule> alarmDispatchRuleList = alarmDispatchRuleService.selectAlarmDispatchRuleList(paramJSONObject);
        Integer count = alarmDispatchRuleService.selectAlarmDispatchRuleCount(paramJSONObject);

        return new LayuiTableResult(count, alarmDispatchRuleList);
    }

    /**
    @author Wangchong
    @date 2021/12/7 9:51
    @description TODO 返回报警事件规则页面
    @param
    @return
    */
    @RequestMapping("alarmRulePage")
    public String alarmRulePage(){
        return "management/operationManagement/alarmRule";
    }

    /**
    @author Wangchong
    @date 2021/12/7 9:56
    @description TODO 添加报警事件规则
    @param alarmRule
    @return
    */
    @RequestMapping("insertAlarmRule")
    @ResponseBody
    public JSONObject insertAlarmRule(@RequestBody AlarmRule alarmRule){
         alarmRule.setCreateTime(DateUtil.getNowTime());
         alarmRuleService.insertSelective(alarmRule);

         return ResponseJSONObject.success("添加成功");
    }

    /**
    @author Wangchong
    @date 2021/12/7 9:59
    @description TODO 查询报警事件规则
    @param queryParameter
    @return
    */
    @RequestMapping("listGetAlarmRule")
    @ResponseBody
    public LayuiTableResult listGetAlarmRule(@RequestBody QueryParameter<AlarmRule> queryParameter){

        System.out.println("参数:" + queryParameter.toString());
        List<AlarmRule> alarmRuleList = alarmRuleService.listGetAlarmRule(queryParameter);

        Integer count = alarmRuleService.countGetAlarmRule(queryParameter);

        return new LayuiTableResult(count, alarmRuleList);
    }
}
