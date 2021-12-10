package com.zy.gis.controller.management.operationManagement;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.layui.LayuiTableResult;
import com.zy.gis.common.response.ResponseJSONObject;
import com.zy.gis.orm.qo.RoutineMaintenanceQueryParameter;
import com.zy.gis.orm.vo.GisPointHaveFlexemInfo;
import com.zy.gis.pojo.OrganizeInfo;
import com.zy.gis.pojo.RoutineMaintenance;
import com.zy.gis.pojo.UserInfo;
import com.zy.gis.pojo.devAndFacility.NetworkPointInfo;
import com.zy.gis.service.NetworkPointService;
import com.zy.gis.service.OrganizeService;
import com.zy.gis.service.RoutineMaintenanceService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
@author Wangchong
@date 2021/10/26 15:40
@description TODO 日常维护记录
*/
@Controller
public class RoutineMaintenanceController {

    @Autowired
    private OrganizeService organizeService;

    @Autowired
    private NetworkPointService networkPointService;

    @Autowired
    private RoutineMaintenanceService routineMaintenanceService;

    /**
     @author Wangchong
     @date 2021/10/26 15:36
     @description TODO 日常维护记录页面
     @return
     */
    @RequestMapping("routineMaintenancePage")
    public String operationManagementPage(){
        return "management/operationManagement/routineMaintenance";
    }

    /**
     @author Wangchong
     @date 2021/10/26 16:59
     @description TODO 新建日常维护记录页面
     @return
     */
    @RequestMapping("addRoutineMaintenancePage")
    public String addRoutineMaintenancePage(Model model){
        Session session = SecurityUtils.getSubject().getSession();
        UserInfo userInfo = null;
        Object obj = session.getAttribute("users");

        if (obj instanceof UserInfo) {
            userInfo = (UserInfo) obj;
            OrganizeInfo organizeInfo = new OrganizeInfo();
            organizeInfo = organizeService.selectByPrimaryKey(Integer.valueOf(userInfo.getOrganizationCode()));

            model.addAttribute("organizeInfo", organizeInfo);

            NetworkPointInfo networkPointInfo = new NetworkPointInfo();
            networkPointInfo.setAddressId(userInfo.getOrganizationCode());
            // 点位
            GisPointHaveFlexemInfo gisPointHaveFlexemInfo = new GisPointHaveFlexemInfo();
            gisPointHaveFlexemInfo.setAddressId(userInfo.getOrganizationCode());
            List<GisPointHaveFlexemInfo> gisPointHaveFlexemInfoList = networkPointService.selectNetworkPointHaveDeviceList(gisPointHaveFlexemInfo);
            model.addAttribute("gisPointHaveFlexemInfoList", gisPointHaveFlexemInfoList);

            model.addAttribute("user", userInfo);
        }
        return "management/operationManagement/addRoutineMaintenance";
    }

    /**
    @author Wangchong
    @date 2021/12/2 14:36
    @description TODO 添加日常维护记录
    @param routineMaintenance
    @return
    */
    @RequestMapping(value = "addRoutineMaintenance", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addRoutineMaintenance(@RequestBody RoutineMaintenance routineMaintenance){

        routineMaintenanceService.insertSelective(routineMaintenance);
        return ResponseJSONObject.success("添加成功");
    }
    
    /**
    @author Wangchong
    @date 2021/12/2 15:22
    @description TODO 查询日常维护记录信息
    @param routineMaintenanceQueryParameter
    @return {@link LayuiTableResult }
    */
    @RequestMapping(value ="selectRoutineMaintenanceList", method = RequestMethod.POST)
    @ResponseBody
    public LayuiTableResult selectRoutineMaintenanceList(@RequestBody RoutineMaintenanceQueryParameter routineMaintenanceQueryParameter){

        Session session = SecurityUtils.getSubject().getSession();
        UserInfo userInfo = null;
        Object obj = session.getAttribute("users");

        if (obj instanceof UserInfo) {
            userInfo = (UserInfo) obj;
            String roleName = userInfo.getRoleName();
            if (StringUtils.isNotEmpty(roleName)){
                if (roleName.equals("运维操作人员")){
                    routineMaintenanceQueryParameter.setUserId(userInfo.getUserId());
                }

                if (roleName.equals("小区单位人员") || roleName.equals("社区单位人员")){
                    routineMaintenanceQueryParameter.setOrganizationCode(userInfo.getOrganizationCode());
                }
            }
        }
         
        List<RoutineMaintenance> routineMaintenanceList = routineMaintenanceService.selectRoutineMaintenanceList(routineMaintenanceQueryParameter);
        Integer count = routineMaintenanceService.selectRoutineMaintenanceCount(routineMaintenanceQueryParameter);
        
        return new LayuiTableResult(count, routineMaintenanceList);
    }
}
