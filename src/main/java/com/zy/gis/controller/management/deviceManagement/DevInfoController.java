package com.zy.gis.controller.management.deviceManagement;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.layui.LayuiTableResult;
import com.zy.gis.common.response.ResponseJSONObject;
import com.zy.gis.pojo.OrganizeInfo;
import com.zy.gis.pojo.devAndFacility.*;
import com.zy.gis.service.*;
import com.zy.gis.util.MyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/9 9:51
 */
@Controller
public class DevInfoController {
    Logger logger = LoggerFactory.getLogger(DevInfoController.class);
    @Autowired
    DevControlPanelService devControlPanelService;
    @Autowired
    DevInfoService devInfoService;
    @Autowired
    DevTypeService devTypeService;
    @Autowired
    SystemTypeService systemTypeService;
    @Autowired
    NetworkPointService networkPointService;
    @Autowired
    NetworkPipelineService networkPipelineService;
    /**
     * @Description: 获取设备信息
     * @author hhp
     * @date 2021/9/9 14:39 
     * @param devInfo: 
     * @return {@link LayuiTableResult}
     */
    @RequestMapping(value = "getAllDev",method = RequestMethod.POST)
    @ResponseBody
    public LayuiTableResult getAllDev(@RequestBody DevInfo devInfo){
        logger.info("devInfo:"+devInfo);
        int count = devInfoService.getAllDevInfoCount(devInfo);
        List<DevInfo> list = devInfoService.getAllDevInfo(devInfo);

        DevControlPanelInfo devControlPanelInfo = new DevControlPanelInfo();
        devControlPanelInfo.setDevNum(count);
        devControlPanelInfo.setBoxNo(devInfo.getBoxNo());
        devControlPanelInfo.setBoxAlias(devInfo.getBoxAlias());
        devControlPanelService.updateDevControlPanelByBoxNo(devControlPanelInfo);//更新工控屏下的设备数量

        return new LayuiTableResult(count,list);
    }


    /**
     * @Description: 跳转至设备新增编辑页面
     * @author hhp
     * @date 2021/9/9 14:39
     * @return {@link String}
     */
    @RequestMapping("toAddDevPage")
    public String toAddDevPage(String systemType,Model model){
        System.out.println("---------------------->"+systemType);
        SystemTypeInfo systemTypeInfo = new SystemTypeInfo();
        systemTypeInfo.setSystemTypeName(systemType);
        List<SystemTypeInfo> systemTypeInfoList = systemTypeService.getAllSystemType(systemTypeInfo);
//        List<DevTypeInfo> devTypeInfoList = devTypeService.getAllDevType(new DevTypeInfo());
        List<DevTypeInfo> devTypeInfoList = new ArrayList<>();
        String[] devTypes = systemTypeInfoList.get(0).getDevTypeNameGroup().split(",");
        for(int i=0; i<devTypes.length; i++){
            DevTypeInfo devTypeInfo = new DevTypeInfo();
            devTypeInfo.setDevTypeName(devTypes[i]);
            devTypeInfoList.add(devTypeInfo);
        }
        model.addAttribute("devTypeInfoList", devTypeInfoList);
        return "management/deviceManagement/devControlPanelManagement/addDev";
    }
    /**
     * @Description: 新增设备
     * @author hhp
     * @date 2021/9/9 14:39
     * @param devInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("insertDevData")
    @ResponseBody
    public JSONObject insertDevData(DevInfo devInfo) {

        List<DevInfo> devInfoList = devInfoService.getAllDevInfo(devInfo);
        if(devInfoList.size() > 0){
            return ResponseJSONObject.fail("设备序列号已存在");
        }

        devInfo.setCreateTime(MyUtil.getNowDateTime());
        devInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = devInfoService.insertDev(devInfo);
        if(iRet == -2){
            return ResponseJSONObject.fail("设备类型为空");
        }
        if(iRet == -3){
            return ResponseJSONObject.fail("数据库中没有该数据库的表");
        }
        return ResponseJSONObject.retMsg(iRet,"设备新增");
    }

    /**
     * @Description: 更新设备数据
     * @author hhp
     * @date 2021/9/9 14:39
     * @param devInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("updateDevData")
    @ResponseBody
    public JSONObject updateDevData(DevInfo devInfo) {
        devInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = devInfoService.updateDev(devInfo);
        return ResponseJSONObject.retMsg(iRet,"设备更新");
    }

    /**
     * @Description: 删除设备
     * @author hhp
     * @date 2021/9/9 14:39
     * @param devInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("delDevData")
    @ResponseBody
    public JSONObject delDevData(DevInfo devInfo) {
        int iRet = devInfoService.delDev(devInfo);
        if(iRet == -2){
            return ResponseJSONObject.fail("设备类型为空");
        }
        if(iRet == -3){
            return ResponseJSONObject.fail("数据库中没有该数据库的表");
        }
        return ResponseJSONObject.retMsg(iRet,"设备删除");
    }

    @RequestMapping("getAllDevPoint")
    @ResponseBody
    public List<DevInfo> getAllDevPoint() {
        List<DevInfo> devInfoList = devInfoService.getAllDevInfo(new DevInfo());
        for(DevInfo info : devInfoList){
            if(info.getFacilityType().equals("点位")){
                NetworkPointInfo networkPointInfo = new NetworkPointInfo();
                networkPointInfo.setPointNo(info.getFacilityNo());
                List<NetworkPointInfo> pointInfoList = networkPointService.getAllNetworkPoint(networkPointInfo);
                info.setLongitude(pointInfoList.get(0).getLongitude());
                info.setLatitude(pointInfoList.get(0).getLatitude());
                info.setAddress(pointInfoList.get(0).getAddressName());
                info.setNetworkType(pointInfoList.get(0).getNetworkType());
            }else{
                NetworkPipelineInfo networkPipelineInfo = new NetworkPipelineInfo();
                networkPipelineInfo.setPipelineNo(info.getFacilityNo());
                List<NetworkPipelineInfo> pipelineInfoList = networkPipelineService.getAllNetworkPipeline(networkPipelineInfo);
                info.setLongitude(pipelineInfoList.get(0).getLongitude());//管线经纬度为空，具体数值后期再考虑
                info.setLatitude(pipelineInfoList.get(0).getLatitude());
                info.setAddress(pipelineInfoList.get(0).getAddressName());
                info.setNetworkType(pipelineInfoList.get(0).getNetworkType());
            }
        }
        return devInfoList;
    }
}
