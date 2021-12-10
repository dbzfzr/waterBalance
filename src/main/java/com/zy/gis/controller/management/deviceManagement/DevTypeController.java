package com.zy.gis.controller.management.deviceManagement;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.layui.LayuiTableResult;
import com.zy.gis.common.response.ResponseJSONObject;
import com.zy.gis.pojo.devAndFacility.DevTypeInfo;
import com.zy.gis.service.DevTypeService;
import com.zy.gis.util.MyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/2 14:30
 */
@Controller
public class DevTypeController {

    Logger logger = LoggerFactory.getLogger(DevTypeController.class);

    @Autowired
    DevTypeService devTypeService;


    /**
     * @Description: 获取所有设施类型
     * @author hhp
     * @date 2021/9/2 18:04
     * @param devTypeInfo:
     * @return {@link LayuiTableResult}
     */
    @RequestMapping(value = "getAllDevType",method = RequestMethod.POST)
    @ResponseBody
    public LayuiTableResult getAllDevType(@RequestBody DevTypeInfo devTypeInfo){
        logger.info("DevTypeInfo:"+devTypeInfo);
//        if (DevTypeInfo.getPage() != null && DevTypeInfo.getLimit() != null){
//            DevTypeInfo.setOffSet((DevTypeInfo.getPage() - 1) * DevTypeInfo.getLimit());
//        }
        int count = devTypeService.getAllDevTypeCount(devTypeInfo);
        List<DevTypeInfo> list = devTypeService.getAllDevType(devTypeInfo);
        return new LayuiTableResult(count,list);
    }

    /**
     * @Description: 跳转至设备类型新增编辑页面
     * @author hhp
     * @date 2021/9/2 18:05
     * @param id: 设备类型ID
     * @return {@link ModelAndView}
     */
    @RequestMapping("toAddDevTypePage")
    public ModelAndView toAddDevTypePage(String id) {
        System.out.println("id:" + id);
        ModelAndView modelAndView = new ModelAndView("management/deviceManagement/devTypeManagement/addDevType");
        return modelAndView;
    }

    /**
     * @Description: 新增设备类型
     * @author hhp
     * @date 2021/9/2 18:06
     * @param devTypeInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("insertDevTypeData")
    @ResponseBody
    public JSONObject insertDevTypeData(DevTypeInfo devTypeInfo) {
        devTypeInfo.setCreateTime(MyUtil.getNowDateTime());
        devTypeInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = devTypeService.insert(devTypeInfo);
        return ResponseJSONObject.retMsg(iRet,"设备类型新增");
    }

    /**
     * @Description: 更新设备类型数据
     * @author hhp
     * @date 2021/9/2 18:06
     * @param devTypeInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("updateDevTypeData")
    @ResponseBody
    public JSONObject updateDevTypeData(DevTypeInfo devTypeInfo) {
        devTypeInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = devTypeService.updateByPrimaryKeySelective(devTypeInfo);
        return ResponseJSONObject.retMsg(iRet,"设备类型更新");
    }

    /**
     * @Description: 删除设备类型
     * @author hhp
     * @date 2021/9/2 18:07
     * @param id:
     * @return {@link JSONObject}
     */
    @RequestMapping("delDevTypeData")
    @ResponseBody
    public JSONObject delDevTypeData(int id) {
        int iRet = devTypeService.deleteByPrimaryKey(id);
        return ResponseJSONObject.retMsg(iRet,"设备类型删除");
    }
}
