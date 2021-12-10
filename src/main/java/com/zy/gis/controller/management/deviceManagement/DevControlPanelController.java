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
import java.util.Map;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/8 15:40
 */
@Controller
public class DevControlPanelController {
    
    Logger logger = LoggerFactory.getLogger(DevControlPanelController.class);
    @Autowired
    DevControlPanelService devControlPanelService;
    @Autowired
    NetworkPointService networkPointService;
    @Autowired
    NetworkPipelineService networkPipelineService;

    /**
     * @Description: 获取工控屏信息
     * @author hhp
     * @date 2021/9/8 15:40
     * @param devControlPanelInfo:
     * @return {@link LayuiTableResult}
     */
    @RequestMapping(value = "getAllDevControlPanelInfo",method = RequestMethod.POST)
    @ResponseBody
    public LayuiTableResult getAllDevControlPanelInfo(@RequestBody DevControlPanelInfo devControlPanelInfo){
        logger.info("devControlPanelInfo:"+devControlPanelInfo);
//        if (devControlPanelInfo.getPage() != null && devControlPanelInfo.getLimit() != null){
//            devControlPanelInfo.setOffSet((devControlPanelInfo.getPage() - 1) * devControlPanelInfo.getLimit());
//        }
        int count = devControlPanelService.getAllDevControlPanelCount(devControlPanelInfo);
        List<DevControlPanelInfo> list = devControlPanelService.getAllDevControlPanelInfo(devControlPanelInfo);

//        for(DevControlPanelInfo info : list){
//            if(info.getFacilityType().equals("点位")){
//                NetworkPointInfo networkPointInfo = new NetworkPointInfo();
//                networkPointInfo.setPointNo(info.getFacilityNo());
//                List<NetworkPointInfo> pointInfoList = networkPointService.getAllNetworkPoint(networkPointInfo);
//                info.setSystemType(pointInfoList.get(0).getSystemType());
//            }else{
//                NetworkPipelineInfo networkPipelineInfo = new NetworkPipelineInfo();
//                networkPipelineInfo.setPipelineNo(info.getFacilityNo());
//                List<NetworkPipelineInfo> pipelineInfoList = networkPipelineService.getAllNetworkPipeline(networkPipelineInfo);
//                info.setSystemType(pipelineInfoList.get(0).getSystemType());
//            }
//        }
        return new LayuiTableResult(count,list);
    }


    /**
     * @Description: 跳转至工控屏新增编辑页面
     * @author hhp
     * @date 2021/9/8 15:40
     * @return {@link String}
     */
//    @RequestMapping("toAddDevControlPanelPage")
//    public String toAddDevControlPanelPage(Model model){
//        List<NetworkPointInfo> networkPointInfoList = networkPointService.getAllNetworkPoint(new NetworkPointInfo());
//        List<NetworkPipelineInfo> networkPipelineInfoList = networkPipelineService.getAllNetworkPipeline(new NetworkPipelineInfo());
//        List<NetworkPipelineInfo> newList = new ArrayList<>();
//        for(NetworkPipelineInfo networkPipelineInfo : networkPipelineInfoList){
//            String systemType = networkPipelineInfo.getSystemType();
//            if(!(systemType == null || systemType.equals(""))){
//                newList.add(networkPipelineInfo);
//            }
//        }
//
//
//        model.addAttribute("networkPointInfoList", networkPointInfoList);
//        model.addAttribute("networkPipelineInfoList", newList);
//        return "management/deviceManagement/devControlPanelManagement/addControlPanelDev";
//    }
    /**
    @author Wangchong
    @date 2021/11/19 14:40 改
    @description TODO 编辑，添加工控屏页面，查询能够添加设备的点位信息
    */
    @RequestMapping("toAddDevControlPanelPage")
    public String toAddDevControlPanelPage(Model model){
        //List<NetworkPointInfo> networkPointInfoList = networkPointService.getAllNetworkPoint(new NetworkPointInfo());
        List<NetworkPipelineInfo> networkPipelineInfoList = networkPipelineService.getAllNetworkPipeline(new NetworkPipelineInfo());
        List<NetworkPipelineInfo> newList = new ArrayList<>();
        for(NetworkPipelineInfo networkPipelineInfo : networkPipelineInfoList){
            String systemType = networkPipelineInfo.getSystemType();
            if(!(systemType == null || systemType.equals(""))){
                newList.add(networkPipelineInfo);
            }
        }

        List<Map<String, String>> networkPointList = networkPointService.selectNetworkPointNoAndName();
        //model.addAttribute("networkPointInfoList", networkPointInfoList);
        model.addAttribute("networkPointInfoList", networkPointList);
        model.addAttribute("networkPipelineInfoList", newList);
        return "management/deviceManagement/devControlPanelManagement/addControlPanelDev";
    }
    /**
     * @Description: 新增工控屏
     * @author hhp
     * @date 2021/9/8 15:40
     * @param devControlPanelInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("insertDevControlPanelData")
    @ResponseBody
    public JSONObject insertDevControlPanelData(DevControlPanelInfo devControlPanelInfo) {

        List<DevControlPanelInfo> devControlPanelInfoList = devControlPanelService.getAllDevControlPanelInfo(devControlPanelInfo);
        if(devControlPanelInfoList.size() > 0){
            return ResponseJSONObject.fail("该设施下工控屏已存在");
        }

        devControlPanelInfo.setCreateTime(MyUtil.getNowDateTime());
        devControlPanelInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = devControlPanelService.insertSelective(devControlPanelInfo);
        return ResponseJSONObject.retMsg(iRet,"工控屏新增");
    }

    /**
     * @Description: 更新工控屏数据
     * @author hhp
     * @date 2021/9/8 15:40
     * @param devControlPanelInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("updateDevControlPanelData")
    @ResponseBody
    public JSONObject updateDevControlPanelData(DevControlPanelInfo devControlPanelInfo) {
        devControlPanelInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = devControlPanelService.updateByPrimaryKeySelective(devControlPanelInfo);
        return ResponseJSONObject.retMsg(iRet,"工控屏更新");
    }

    /**
     * @Description: 删除工控屏
     * @author hhp
     * @date 2021/9/8 15:40
     * @param id:
     * @return {@link JSONObject}
     */
    @RequestMapping("delDevControlPanelData")
    @ResponseBody
    public JSONObject delDevControlPanelData(int id) {
        int iRet = devControlPanelService.deleteByPrimaryKey(id);
        return ResponseJSONObject.retMsg(iRet,"工控屏删除");
    }
}
