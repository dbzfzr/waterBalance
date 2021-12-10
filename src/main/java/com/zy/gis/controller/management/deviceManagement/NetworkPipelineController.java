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

import java.util.List;

/**
 * TODO管网管线
 *
 * @author hhp
 * @date 2021/9/7 14:23
 */
@Controller
public class NetworkPipelineController {

    Logger logger = LoggerFactory.getLogger(NetworkPipelineController.class);
    @Autowired
    NetworkPipelineService networkPipelineService;
    @Autowired
    NetworkPointService networkPointService;
    @Autowired
    OrganizeService organizeService;
    @Autowired
    SystemTypeService systemTypeService;
    @Autowired
    MaterialTypeService materialTypeService;
    @Autowired
    SpecsTypeService specsTypeService;
    @Autowired
    DevControlPanelService devControlPanelService;
    /**
     * @Description: 获取管网管线信息
     * @author hhp
     * @date 2021/9/7 14:23
     * @param networkPipelineInfo: 
     * @return {@link LayuiTableResult}
     */
    @RequestMapping(value = "getAllNetworkPipeline",method = RequestMethod.POST)
    @ResponseBody
    public LayuiTableResult getAllNetworkPipeline(@RequestBody NetworkPipelineInfo networkPipelineInfo){
        logger.info("networkPipelineInfo:"+networkPipelineInfo);
//        if (networkPipelineInfo.getPage() != null && networkPipelineInfo.getLimit() != null){
//            networkPipelineInfo.setOffSet((networkPipelineInfo.getPage() - 1) * networkPipelineInfo.getLimit());
//        }
        int count = networkPipelineService.getAllNetworkPipelineCount(networkPipelineInfo);
        List<NetworkPipelineInfo> list = networkPipelineService.getAllNetworkPipeline(networkPipelineInfo);
        return new LayuiTableResult(count,list);
    }


    /**
     * @Description: 跳转至管网管线新增编辑页面
     * @author hhp
     * @date 2021/9/7 14:23
     * @return {@link String}
     */
    @RequestMapping("toAddNetworkPipelinePage")
    public String toAddNetworkPipelinePage(Model model){
        List<NetworkPointInfo> networkPointInfoList = networkPointService.getAllNetworkPoint(new NetworkPointInfo());
        List<OrganizeInfo> organizeInfoList = organizeService.getAllOrganize(new OrganizeInfo());
        List<SystemTypeInfo> systemTypeInfoList = systemTypeService.getAllSystemType(new SystemTypeInfo());
        List<MaterialTypeInfo> materialTypeInfoList = materialTypeService.getAllMaterialType(new MaterialTypeInfo());
        List<SpecsTypeInfo> specsTypeInfoList = specsTypeService.getAllSpecsType(new SpecsTypeInfo());
        model.addAttribute("networkPointInfoList", networkPointInfoList);
        model.addAttribute("organizeInfoList", organizeInfoList);
        model.addAttribute("systemTypeInfoList", systemTypeInfoList);
        model.addAttribute("materialTypeInfoList", materialTypeInfoList);
        model.addAttribute("specsTypeInfoList", specsTypeInfoList);
        return "management/deviceManagement/networkPipelineManagement/addNetworkPipeline";
    }
    /**
     * @Description: 新增管网管线
     * @author hhp
     * @date 2021/9/7 14:23
     * @param networkPipelineInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("insertNetworkPipelineData")
    @ResponseBody
    public JSONObject insertNetworkPipelineData(NetworkPipelineInfo networkPipelineInfo) {

        List<NetworkPipelineInfo> networkPipelineInfoList = networkPipelineService.getAllNetworkPipeline(networkPipelineInfo);
        if(networkPipelineInfoList.size() > 0){
            return ResponseJSONObject.fail("管线编号已存在");
        }

        networkPipelineInfo.setCreateTime(MyUtil.getNowDateTime());
        networkPipelineInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = networkPipelineService.insert(networkPipelineInfo);
        return ResponseJSONObject.retMsg(iRet,"管网管线新增");
    }

    /**
     * @Description: 更新管网管线数据
     * @author hhp
     * @date 2021/9/7 14:23
     * @param networkPipelineInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("updateNetworkPipelineData")
    @ResponseBody
    public JSONObject updateNetworkPipelineData(NetworkPipelineInfo networkPipelineInfo) {
        networkPipelineInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = networkPipelineService.updateByPrimaryKeySelective(networkPipelineInfo);
        return ResponseJSONObject.retMsg(iRet,"管网管线更新");
    }

    /**
     * @Description: 删除管网管线
     * @author hhp
     * @date 2021/9/7 14:23
     * @param networkPipelineInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("delNetworkPipelineData")
    @ResponseBody
    public JSONObject delNetworkPipelineData(NetworkPipelineInfo networkPipelineInfo) {
        DevControlPanelInfo devControlPanelInfo = new DevControlPanelInfo();
        devControlPanelInfo.setFacilityNo(networkPipelineInfo.getPipelineNo());
        List<DevControlPanelInfo> devControlPanelInfoList = devControlPanelService.getAllDevControlPanelInfo(devControlPanelInfo);
        if(devControlPanelInfoList.size() > 0){
            return ResponseJSONObject.fail("请先删除该管线下的设备信息");
        }
        int iRet = networkPipelineService.deleteByPrimaryKey(networkPipelineInfo.getId());
        return ResponseJSONObject.retMsg(iRet,"管网管线删除");
    }


    /**
     * @Description:获取所有管网管线信息
     * @author hhp
     * @date 2021/9/7 20:43
     * @return {@link List< NetworkPipelineInfo>}
     */
    @RequestMapping("getAllNetworkPipelineInfo")
    @ResponseBody
    public List<NetworkPipelineInfo> getAllNetworkPipelineInfo() {
        return networkPipelineService.getAllNetworkPipeline(new NetworkPipelineInfo());
    }
}
