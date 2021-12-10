package com.zy.gis.controller.management;

import com.zy.gis.pojo.MenuInfo;
import com.zy.gis.pojo.UserInfo;
import com.zy.gis.pojo.devAndFacility.DevTypeInfo;
import com.zy.gis.pojo.devAndFacility.SystemTypeInfo;
import com.zy.gis.service.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ManagementController {

    @Autowired
    SystemTypeService systemTypeService;
    @Autowired
    DevTypeService devTypeService;
    @Autowired
    OrganizeService organizeService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleMenuService roleMenuService;

    /**
    @author Wangchong
    @date 2021/11/11 14:02 改
    @description TODO 返回管理中心页面 根据登录用户id渲染菜单
    @param model
    @return
    */
    @RequestMapping("managementPage")
    public String managementPage(Model model, String defaultPage){

        Session session = SecurityUtils.getSubject().getSession();
        UserInfo userInfo = null;
        Object obj = session.getAttribute("users");

        if (obj instanceof UserInfo){
            userInfo = (UserInfo)obj;
            List<MenuInfo> returnMenuInfoList = new ArrayList<>();
            List<Integer> menuIdList;
            // 管理员
            if (userInfo.getRoleId() == 1 || "管理员".equals(userInfo.getRoleName())){
                  menuIdList = menuService.selectAllMenuIds();
            }else{
                menuIdList = roleMenuService.getRoleMenuIds(userInfo.getRoleId());
            }

            MenuInfo menuInfo = new MenuInfo();
            menuInfo.setName("管理中心");

            List<MenuInfo> menuInfoList = menuService.selectMenuInfoList(menuInfo);

            menuInfo = menuInfoList.get(0);
            if (menuInfo == null){
                return "management/managementPage";
            }

            menuIdList.remove(menuInfo.getId());

            menuInfo.setName("");
            menuInfo.setParentId(menuInfo.getId());
            menuInfoList = menuService.selectMenuInfoList(menuInfo);

            for (MenuInfo menuInfo1: menuInfoList){
                for (Integer menuId: menuIdList){
                    if (menuInfo1.getId() == menuId){
                        returnMenuInfoList.add(menuInfo1);
                        continue;
                    }
                }
            }

            model.addAttribute("menuInfoList", returnMenuInfoList);
        }
        if (StringUtils.isNotEmpty(defaultPage)){
            model.addAttribute("defaultPage",defaultPage);
        }
        return "management/managementPage";
    }

    /**
     * 进入区划管理页面
     * @return
     */
    @RequestMapping("regionManagement")
    public String regionManagementPage(){
        return "management/regionManagement/regionManagement";
    }


    @RequestMapping("equipmentManagement")
    public String equalManagement(Model model){

        List<SystemTypeInfo> SystemTypeInfoList = systemTypeService.getAllSystemType(new SystemTypeInfo());
        List<SystemTypeInfo> list = new ArrayList<>();
        for(int i = SystemTypeInfoList.size(); i>0 ;i--){
            list.add(SystemTypeInfoList.get(i-1));
        }
        model.addAttribute("SystemTypeInfoList", list);

//        List<DevTypeInfo> DevTypeInfoList = devTypeService.getAllDevType(new DevTypeInfo());
//        List<DevTypeInfo> list1 = new ArrayList<>();
//        for(int i = DevTypeInfoList.size();i>0;i--){
//            list1.add(DevTypeInfoList.get(i-1));
//        }
//        model.addAttribute("DevTypeInfoList",list1);

        return "management/equipmentManagement/equipmentManagement";
    }

    /**
     * @Description:进入-->设施设备管理-地图展示
     * @author hhp
     * @date 2021/10/14 15:40
     * @return {@link String}
     */
    @RequestMapping("mapShowManagement")
    public String mapShowManagement(){return "management/equipmentManagement/mapShowManagement/mapShowManagement.html";}

    /**
     * @Description:进入-->设施设备管理-数据监控
     * @author hhp
     * @date 2021/10/14 15:41
     * @return {@link String}
     */
    @RequestMapping("devDataManagement")
    public String devDataManagement(Model model){
        List<DevTypeInfo> DevTypeInfoList = devTypeService.getAllDevType(new DevTypeInfo());
        List<DevTypeInfo> list = new ArrayList<>();
        for(int i = DevTypeInfoList.size();i>0;i--){
            list.add(DevTypeInfoList.get(i-1));
        }
        model.addAttribute("DevTypeInfoList",list);
        return "management/equipmentManagement/devDataManagement/devDataManagement.html";
    }

    /**
     * @Description: 进入 --> 设施设备管理-报警记录
     * @return
     */
    @RequestMapping("alarmRecordManagement")
    public String alarmRecordManagement(){

        return "management/equipmentManagement/alarmRecordManagement/alarmRecordManagement.html";
    }

    /**
     * @Description: 进入 --> 设施设备管理-历史数据
     * @return
     */
    @RequestMapping("historicalDataManagement")
    public String historicalDataManagement(){

        return "management/equipmentManagement/historicalDataManagement/historicalDataManagement.html";
    }



    /**
     * @Description: 进入设施设备管理页面
     * @author hhp
     * @date 2021/9/2 11:06
     * @return {@link String}
     */
    @RequestMapping("deviceAndFacilityManagement")
    public String deviceAndFacilityManagement(){
        return "management/deviceManagement/deviceAndFacilityManagement";
    }

//    /**
//     * @Description: 进入设施类型管理页面
//     * @author hhp
//     * @date 2021/9/2 14:59
//     * @return {@link String}
//     */
//    @RequestMapping("facilityTypeManagement")
//    public String facilityTypeManagement(){
//        return "management/deviceManagement/facilityType/facilityTypeManagement";
//    }

    /**
     * @Description:进入管网点位管理页面
     * @author hhp
     * @date 2021/9/6 16:14
     * @return {@link String}
     */
    @RequestMapping("networkPointManagement")
    public String networkPointManagement(){
        return "management/deviceManagement/networkPointManagement/networkPointManagement";
    }
    /**
     * @Description:进入管网管线管理页面
     * @author hhp
     * @date 2021/9/7 14:32
     * @return {@link String}
     */
    @RequestMapping("networkPipelineManagement")
    public String networkPipelineManagement(){
        return "management/deviceManagement/networkPipelineManagement/networkPipelineManagement";
    }
    /**
     * @Description:进入设备管理页面
     * @author hhp
     * @date 2021/9/8 17:09
     * @return {@link String}
     */
    @RequestMapping("devControlPanelManagement")
    public String devControlPanelManagement(){
        return "management/deviceManagement/devControlPanelManagement/devControlPanelManagement";
    }
    /**
     * @Description:进入设备详情页面
     * @author hhp
     * @date 2021/9/9 14:40
     * @return {@link String}
     */
    @RequestMapping("devControlPanelDetailManagement")
    public String devControlPanelDetailManagement(String boxNo,String facilityNo ,String systemType, Model model){
        System.out.println("boxNo="+boxNo);
        System.out.println("facilityNo="+facilityNo);
        model.addAttribute("boxNo",boxNo);
        model.addAttribute("facilityNo",facilityNo);
        model.addAttribute("systemType",systemType);
        return "management/deviceManagement/devControlPanelManagement/devControlPanelDetailManagement";
    }
    /**
     * @Description:进入管网点位类型管理页面
     * @author hhp
     * @date 2021/9/4 15:52
     * @return {@link String}
     */
    @RequestMapping("networkPointTypeManagement")
    public String networkPointTypeManagement(){
        return "management/deviceManagement/networkPointTypeManagement/networkPointTypeManagement";
    }

    /**
     * @Description:进入设施材质类型管理页面
     * @author hhp
     * @date 2021/9/4 17:31
     * @return {@link String}
     */
    @RequestMapping("materialTypeManagement")
    public String materialTypeManagement(){
        return "management/deviceManagement/materialTypeManagement/materialTypeManagement";
    }

    /**
     * @Description:进入设施规格类型管理页面
     * @author hhp
     * @date 2021/9/6 9:37
     * @return {@link String}
     */
    @RequestMapping("specsTypeManagement")
    public String specsTypeManagement(){
        return "management/deviceManagement/specsTypeManagement/specsTypeManagement";
    }

    /**
     * @Description:进入主控系统类型管理页面
     * @author hhp
     * @date 2021/9/4 18:18

     * @return {@link String}
     */
    @RequestMapping("systemTypeManagement")
    public String systemTypeManagement(){
        return "management/deviceManagement/systemTypeManagement/systemTypeManagement";
    }

    /**
     * @Description:进入设备类型管理页面
     * @author hhp
     * @date 2021/9/2 18:09
     * @return {@link String}
     */
    @RequestMapping("devTypeManagement")
    public String devTypeManagement(){
        return "management/deviceManagement/devTypeManagement/devTypeManagement";
    }


    /**
     * @Description:进入账号管理页面
     * @author hhp
     * @date 2021/9/10 11:31
     * @return {@link String}
     */
    @RequestMapping("userAndRoleManagement")
    public String userAndRoleManagement(){
        return "management/userManagement/userAndRoleManagement";
    }
    /**
     * 进入用户管理页面
     * @return
     */
    @RequestMapping("userManagement")
    public String userManagementPage(){
        return "management/userManagement/userManagement";
    }

    /**
     * @Description:进入角色管理页面
     * @author hhp
     * @date 2021/9/10 14:56
     * @return {@link String}
     */
    @RequestMapping("roleManagement")
    public String roleManagement(){
        return "management/userManagement/roleManagement";
    }
}
