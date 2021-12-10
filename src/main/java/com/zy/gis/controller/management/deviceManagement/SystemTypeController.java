package com.zy.gis.controller.management.deviceManagement;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.layui.LayuiTableResult;
import com.zy.gis.common.response.ResponseJSONObject;
import com.zy.gis.pojo.devAndFacility.DevTypeInfo;
import com.zy.gis.pojo.devAndFacility.SystemTypeInfo;
import com.zy.gis.service.DevTypeService;
import com.zy.gis.service.SystemTypeService;
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
 * @date 2021/9/4 18:07
 */
@Controller
public class SystemTypeController {

    Logger logger = LoggerFactory.getLogger(SystemTypeController.class);
    @Autowired
    SystemTypeService systemTypeService;

    @Autowired
    DevTypeService devTypeService;

    /**
     * @Description: 获取主控系统类型信息
     * @author hhp
     * @date 2021/9/4 18:12
     * @param systemTypeInfo:
     * @return {@link LayuiTableResult}
     */
    @RequestMapping(value = "getAllSystemType",method = RequestMethod.POST)
    @ResponseBody
    public LayuiTableResult getAllSystemType(@RequestBody SystemTypeInfo systemTypeInfo){
        logger.info("SystemTypeInfo:"+systemTypeInfo);
//        if (systemTypeInfo.getPage() != null && systemTypeInfo.getLimit() != null){
//            systemTypeInfo.setOffSet((systemTypeInfo.getPage() - 1) * systemTypeInfo.getLimit());
//        }
        int count = systemTypeService.getAllSystemTypeCount(systemTypeInfo);
        List<SystemTypeInfo> list = systemTypeService.getAllSystemType(systemTypeInfo);
        return new LayuiTableResult(count,list);
    }

    /**
     * @Description: ${organizeInfo.organizeName}
     * @author hhp
     * @date 2021/9/6 10:39
     * @param model:
     * @return {@link String}
     */
    @RequestMapping("toAddSystemTypePage")
    public String toAddSystemTypePage(Model model){
        List<DevTypeInfo> devTypeInfoList = devTypeService.getAllDevType(new DevTypeInfo());
        List<DevTypeInfo> list = new ArrayList<>();//按ID正序排序
        for(int i = devTypeInfoList.size(); i>0 ;i--){
            list.add(devTypeInfoList.get(i-1));
        }
        model.addAttribute("devTypeInfoList", list);
        return "management/deviceManagement/systemTypeManagement/addSystemType";
    }
    /**
     * @Description: 新增主控系统类型
     * @author hhp
     * @date 2021/9/4 18:12
     * @param systemTypeInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("insertSystemTypeData")
    @ResponseBody
    public JSONObject insertSystemTypeData(SystemTypeInfo systemTypeInfo) {
        systemTypeInfo.setCreateTime(MyUtil.getNowDateTime());
        systemTypeInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = systemTypeService.insert(systemTypeInfo);
        return ResponseJSONObject.retMsg(iRet,"主控系统类型新增");
    }

    /**
     * @Description: 更新主控系统类型数据
     * @author hhp
     * @date 2021/9/4 18:12
     * @param systemTypeInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("updateSystemTypeData")
    @ResponseBody
    public JSONObject updateSystemTypeData(SystemTypeInfo systemTypeInfo) {
        systemTypeInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = systemTypeService.updateByPrimaryKeySelective(systemTypeInfo);
        return ResponseJSONObject.retMsg(iRet,"主控系统类型更新");
    }

    /**
     * @Description: 删除主控系统类型
     * @author hhp
     * @date 2021/9/4 18:12
     * @param id:
     * @return {@link JSONObject}
     */
    @RequestMapping("delSystemTypeData")
    @ResponseBody
    public JSONObject delSystemTypeData(int id) {
        int iRet = systemTypeService.deleteByPrimaryKey(id);
        return ResponseJSONObject.retMsg(iRet,"主控系统类型删除");
    }
}
