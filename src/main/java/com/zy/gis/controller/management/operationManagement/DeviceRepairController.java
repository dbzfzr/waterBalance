package com.zy.gis.controller.management.operationManagement;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.layui.LayuiTableResult;
import com.zy.gis.common.response.ResponseJSONObject;
import com.zy.gis.orm.qo.DeviceRepairRecordQueryParameter;
import com.zy.gis.orm.vo.GisPointHaveFlexemInfo;
import com.zy.gis.pojo.DeviceRepairRecordWithBLOBs;
import com.zy.gis.pojo.OrganizeInfo;
import com.zy.gis.pojo.UserInfo;
import com.zy.gis.pojo.devAndFacility.NetworkPointInfo;
import com.zy.gis.service.DeviceRepairRecordService;
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

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
@author Wangchong
@date 2021/12/3 11:19
@description TODO 设备维修记录页面
*/
@Controller
public class DeviceRepairController {

    @Autowired
    private OrganizeService organizeService;

    @Autowired
    private NetworkPointService networkPointService;

    @Autowired
    private DeviceRepairRecordService deviceRepairRecordService;
    /**
     @author Wangchong
     @date 2021/12/03 11:20
     @description TODO 设备维修记录页面
     @return
     */
    @RequestMapping("deviceRepairRecordPage")
    public String operationManagementPage(){
        return "management/operationManagement/deviceRepairRecord";
    }

    /**
     @author Wangchong
     @date 2021/10/26 16:59
     @description TODO 新建设备维修记录页面
     @return
     */
    @RequestMapping("addDeviceRepairRecordPage")
    public String addRoutineMaintenancePage(Model model){
        Session session = SecurityUtils.getSubject().getSession();
        UserInfo userInfo = null;
        Object obj = session.getAttribute("users");

        if (obj instanceof UserInfo) {
            userInfo = (UserInfo) obj;
            OrganizeInfo organizeInfo = new OrganizeInfo();
            organizeInfo = organizeService.selectByPrimaryKey(Integer.valueOf(userInfo.getOrganizationCode()));

            model.addAttribute("organizeInfo", organizeInfo);

//            // 设备安装位置和设备
            GisPointHaveFlexemInfo gisPointHaveFlexemInfo = new GisPointHaveFlexemInfo();
            gisPointHaveFlexemInfo.setAddressId(userInfo.getOrganizationCode());
            List<GisPointHaveFlexemInfo> gisPointHaveFlexemInfoList = networkPointService.selectNetworkPointHaveDeviceList(gisPointHaveFlexemInfo);

            gisPointHaveFlexemInfoList = gisPointHaveFlexemInfoList.stream()
                    .sorted(Comparator.comparing(GisPointHaveFlexemInfo::getPointName))
                    .collect(Collectors.toList());

            model.addAttribute("gisPointHaveFlexemInfoList", gisPointHaveFlexemInfoList);

            model.addAttribute("user", userInfo);
        }
        return "management/operationManagement/addDeviceRepairRecord";
    }

    /**
    @author Wangchong
    @date 2021/12/2 14:36
    @description TODO 添加设备维修记录
    @param deviceRepairRecordWithBLOBs
    @return
    */
    @RequestMapping(value = "addDeviceRepairRecord", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addRoutineMaintenance(@RequestBody DeviceRepairRecordWithBLOBs deviceRepairRecordWithBLOBs){

        deviceRepairRecordService.insertSelective(deviceRepairRecordWithBLOBs);
        return ResponseJSONObject.success("添加成功");
    }
    
    /**
    @author Wangchong
    @date 2021/12/2 15:22
    @description TODO 查询日常维护记录信息
    @param deviceRepairRecordQueryParameter
    @return {@link LayuiTableResult }
    */
    @RequestMapping(value ="selectDeviceRepairRecordList", method = RequestMethod.POST)
    @ResponseBody
    public LayuiTableResult selectRoutineMaintenanceList(@RequestBody DeviceRepairRecordQueryParameter deviceRepairRecordQueryParameter){

        Session session = SecurityUtils.getSubject().getSession();
        UserInfo userInfo = null;
        Object obj = session.getAttribute("users");

        if (obj instanceof UserInfo) {
            userInfo = (UserInfo) obj;
            String roleName = userInfo.getRoleName();
            if (StringUtils.isNotEmpty(roleName)){
                  if (roleName.equals("运维操作人员")){
                      deviceRepairRecordQueryParameter.setUserId(userInfo.getUserId());
                  }

                  if (roleName.equals("小区单位人员") || roleName.equals("社区单位人员")){
                      deviceRepairRecordQueryParameter.setOrganizationCode(userInfo.getOrganizationCode());
                  }
            }
        }

        List<DeviceRepairRecordWithBLOBs> deviceRepairRecordWithBLOBList = deviceRepairRecordService.selectDeviceRepairRecordList(deviceRepairRecordQueryParameter);
        Integer count = deviceRepairRecordService.selectDeviceRepairRecordCount(deviceRepairRecordQueryParameter);

        return new LayuiTableResult(count, deviceRepairRecordWithBLOBList);
    }
}
