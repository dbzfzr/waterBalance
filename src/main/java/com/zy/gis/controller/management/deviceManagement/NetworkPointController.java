package com.zy.gis.controller.management.deviceManagement;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.layui.LayuiTableResult;
import com.zy.gis.common.response.ResponseJSONObject;
import com.zy.gis.mapper.OrganizeInfoMapper;
import com.zy.gis.orm.vo.GisPointHaveFlexemInfo;
import com.zy.gis.orm.vo.NetworkPointWithAlarmId;
import com.zy.gis.pojo.OrganizeInfo;
import com.zy.gis.pojo.UserInfo;
import com.zy.gis.pojo.devAndFacility.*;
import com.zy.gis.service.*;
import com.zy.gis.service.NetworkPointService;
import com.zy.gis.util.MyUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/6 16:04
 */
@Controller
public class NetworkPointController {
    Logger logger = LoggerFactory.getLogger(NetworkPointController.class);
    @Autowired
    NetworkPointService networkPointService;
    @Autowired
    OrganizeService organizeService;
    @Autowired
    NetworkPointTypeService networkPointTypeService;
    @Autowired
    SystemTypeService systemTypeService;
    @Autowired
    MaterialTypeService materialTypeService;
    @Autowired
    SpecsTypeService specsTypeService;
    @Autowired
    DevControlPanelService devControlPanelService;

    @Autowired
    private UserService userService;

    /**
     * @param networkPointInfo:
     * @return {@link LayuiTableResult}
     * @Description: 获取管网点位信息
     * @author hhp
     * @date 2021/9/6 16:04
     */
    @RequestMapping("getAllNetworkPoint")
    @ResponseBody
    public LayuiTableResult getAllNetworkPoint(@RequestBody NetworkPointInfo networkPointInfo) {
        logger.info("networkPointInfo:" + networkPointInfo);
//        if (networkPointInfo.getPage() != null && networkPointInfo.getLimit() != null){
//            networkPointInfo.setOffSet((networkPointInfo.getPage() - 1) * networkPointInfo.getLimit());
//        }
        int count = networkPointService.getAllNetworkPointCount(networkPointInfo);
        List<NetworkPointInfo> list = networkPointService.getAllNetworkPoint(networkPointInfo);
        return new LayuiTableResult(count, list);
    }

    /**
     * @return 管网点位的信息, 包括设备报警状态
     * @author Wangchong
     * @date 2021/11/1 10:43
     * @description TODO 查询有繁易屏设备的管网点位的信息
     */
    @RequestMapping("getAllGisPointHaveFlexemInfo")
    @ResponseBody
    public List<GisPointHaveFlexemInfo> getAllGisPointHaveFlexemInfo() {
        return networkPointService.selectGisPointHaveFlexemList();
    }

    /**
     * @param devControlPanelInfo
     * @return 信息
     * @author Wangchong
     * @date 2021/11/5 9:34
     * @description TODO 查询一条有繁易屏设备的点位的信息
     */
    @RequestMapping(value = "getOneNetworkPointHaveFlexemInfo", method = RequestMethod.POST)
    @ResponseBody
    public GisPointHaveFlexemInfo getOneNetworkPointHaveFlexemInfo(@RequestBody DevControlPanelInfo devControlPanelInfo) {
        return networkPointService.selectNetworkPointHaveFlexem(devControlPanelInfo);
    }

    /**
     * @return {@link String}
     * @Description: 跳转至管网点位新增编辑页面
     * @author hhp
     * @date 2021/9/6 16:04
     */
    @RequestMapping("toAddNetworkPointPage")
    public String toAddSystemTypePage(Model model) {
        List<OrganizeInfo> organizeInfoList = organizeService.getAllOrganize(new OrganizeInfo());
        List<NetworkPointTypeInfo> networkPointTypeInfoList = networkPointTypeService.getAllNetworkPointType(new NetworkPointTypeInfo());
        List<SystemTypeInfo> systemTypeInfoList = systemTypeService.getAllSystemType(new SystemTypeInfo());
        List<MaterialTypeInfo> materialTypeInfoList = materialTypeService.getAllMaterialType(new MaterialTypeInfo());
        List<SpecsTypeInfo> specsTypeInfoList = specsTypeService.getAllSpecsType(new SpecsTypeInfo());
        model.addAttribute("organizeInfoList", organizeInfoList);
        model.addAttribute("networkPointTypeInfoList", networkPointTypeInfoList);
        model.addAttribute("systemTypeInfoList", systemTypeInfoList);
        model.addAttribute("materialTypeInfoList", materialTypeInfoList);
        model.addAttribute("specsTypeInfoList", specsTypeInfoList);
        return "management/deviceManagement/networkPointManagement/addNetworkPoint";
    }

    /**
     * @param networkPointInfo:
     * @return {@link JSONObject}
     * @Description: 新增管网点位
     * @author hhp
     * @date 2021/9/6 16:04
     */
    @RequestMapping("insertNetworkPointData")
    @ResponseBody
    public JSONObject insertNetworkPointData(NetworkPointInfo networkPointInfo) {

        List<NetworkPointInfo> networkPointInfoList = networkPointService.getAllNetworkPoint(networkPointInfo);
        if (networkPointInfoList.size() > 0) {
            return ResponseJSONObject.fail("点位编号已存在");
        }
        OrganizeInfo organizeInfo = organizeService.selectByPrimaryKey(Integer.parseInt(networkPointInfo.getAddressId()));
        if (organizeInfo == null) {
            return ResponseJSONObject.fail("无法找到点位所属地点的经纬度");
        }
        //21.12.09-dzb 改 手动填写经纬度 到时需打开注释
//        networkPointInfo.setLongitude(organizeInfo.getLongitude());
//        networkPointInfo.setLatitude(organizeInfo.getLatitude());
        networkPointInfo.setCreateTime(MyUtil.getNowDateTime());
        networkPointInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = networkPointService.insert(networkPointInfo);
        return ResponseJSONObject.retMsg(iRet, "管网点位新增");
    }

    /**
     * @param networkPointInfo:
     * @return {@link JSONObject}
     * @Description: 更新管网点位数据
     * @author hhp
     * @date 2021/9/6 16:04
     */
    @RequestMapping("updateNetworkPointData")
    @ResponseBody
    public JSONObject updateNetworkPointData(NetworkPointInfo networkPointInfo) {
        networkPointInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = networkPointService.updateByPrimaryKeySelective(networkPointInfo);
        return ResponseJSONObject.retMsg(iRet, "管网点位更新");
    }

    /**
     * @param networkPointInfo:
     * @return {@link JSONObject}
     * @Description: 删除管网点位
     * @author hhp
     * @date 2021/9/6 16:04
     */
    @RequestMapping("delNetworkPointData")
    @ResponseBody
    public JSONObject delNetworkPointData(NetworkPointInfo networkPointInfo) {
        DevControlPanelInfo devControlPanelInfo = new DevControlPanelInfo();
        devControlPanelInfo.setFacilityNo(networkPointInfo.getPointNo());
        List<DevControlPanelInfo> devControlPanelInfoList = devControlPanelService.getAllDevControlPanelInfo(devControlPanelInfo);
        if (devControlPanelInfoList.size() > 0) {
            return ResponseJSONObject.fail("请先删除该点位下的设备信息");
        }
        int iRet = networkPointService.deleteByPrimaryKey(networkPointInfo.getId());
        return ResponseJSONObject.retMsg(iRet, "管网点位删除");
    }

    /**
     * @return {@link List< NetworkPointInfo>}
     * @Description:获取所有管网点位坐标
     * @author hhp
     * @date 2021/9/7 17:23
     */
    @RequestMapping("getAllNetworkPointCoordinate")
    @ResponseBody
    public List<NetworkPointInfo> getAllNetworkPointCoordinate() {
        return networkPointService.getAllNetworkPoint(new NetworkPointInfo());
    }


    @RequestMapping("getAllNetworkPointCoordinatePosition")
    @ResponseBody
    public List<NetworkPointInfo> getAllNetworkPointCoordinatePosition() {

        return networkPointService.getAllNetworkPoint(new NetworkPointInfo());
    }


    /**
     * @param networkPointInfo:
     * @return {@link List< NetworkPointInfo>}
     * @Description:根据经纬坐标获取管网点位信息
     * @author hhp
     * @date 2021/9/7 17:26
     */
    @RequestMapping(value = "getNetworkPointInfoByPoint", method = RequestMethod.POST)
    @ResponseBody
    public List<NetworkPointInfo> getNetworkPointInfoByPoint(NetworkPointInfo networkPointInfo) {
        //经纬度只保留小数点后六位
        networkPointInfo.setLongitude(networkPointInfo.getLongitude().substring(0, networkPointInfo.getLongitude().indexOf(".") + 7));
        networkPointInfo.setLatitude(networkPointInfo.getLatitude().substring(0, networkPointInfo.getLatitude().indexOf(".") + 7));
        return networkPointService.getAllNetworkPoint(networkPointInfo);
    }


    @RequestMapping("getSystemTypeNum")
    @ResponseBody
    public int[] getSystemTypeNum() {
        int rainDevNum = networkPointService.getNetworkSystemTypeRainNum();
        int sewageNum = networkPointService.getNetworkSystemTypeSewageNum();
        int RainPollutionNum = networkPointService.getNetworkSystemTypeRainPollutionNum();
        int oilWaterNum = networkPointService.getNetworkSystemTypeOilwaterNum();
        int PumpingNum = networkPointService.getNetworkSystemTypePumpingNum();
        int[] systemNum = new int[]{PumpingNum, sewageNum, rainDevNum, oilWaterNum, RainPollutionNum};

        System.out.println("系统数量显示:");
        System.out.println(RainPollutionNum);
        System.out.println(oilWaterNum);
        System.out.println(rainDevNum);
        System.out.println(sewageNum);
        System.out.println(PumpingNum);
        System.out.println(systemNum);
        return systemNum;
    }

    /**
    @author Wangchong
    @date 2021/11/8 20:00
    @description TODO 根据点位编号获取相应区域下的运维操作人员
    @param pointNo
    @return 人员信息
    */
    @RequestMapping("getOperationUserByNetworkPointNo")
    @ResponseBody
    public List<UserInfo> getOperationUserByNetworkPointNo(@RequestParam("pointNo") String pointNo) {

        if (StringUtils.isEmpty(pointNo)) {
            return new ArrayList<>(1);
        }

        NetworkPointInfo networkPointInfo = new NetworkPointInfo();
        networkPointInfo.setPointNo(pointNo);

        networkPointInfo = networkPointService.getAllNetworkPoint(networkPointInfo).get(0);

        if (networkPointInfo == null){
            return new ArrayList<>(1);
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setOrganizationCode(networkPointInfo.getAddressId());

        List<UserInfo> userInfoList = userService.getUserInfoList(userInfo);
        return userInfoList;
    }

    /**
     @author Wangchong
     @date 2021/11/13 17:23
     @description TODO 查询管网点位信息，附带相应点位的报警记录id
     @param networkPointInfo
     @return {@link NetworkPointWithAlarmId}
     */
    @RequestMapping("selectNetworkPointWithAlarmIdList")
    @ResponseBody
    public List<NetworkPointWithAlarmId> selectNetworkPointWithAlarmIdList(@RequestBody NetworkPointInfo networkPointInfo){
        return networkPointService.selectNetworkPointWithAlarmIdList(networkPointInfo);
    }
}
