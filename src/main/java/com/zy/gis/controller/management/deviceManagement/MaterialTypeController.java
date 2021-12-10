package com.zy.gis.controller.management.deviceManagement;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.layui.LayuiTableResult;
import com.zy.gis.common.response.ResponseJSONObject;
import com.zy.gis.pojo.devAndFacility.MaterialTypeInfo;
import com.zy.gis.service.MaterialTypeService;
import com.zy.gis.service.MaterialTypeService;
import com.zy.gis.util.MyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/4 16:31
 */
@Controller
public class MaterialTypeController {

    Logger logger = LoggerFactory.getLogger(MaterialTypeController.class);
    @Autowired
    MaterialTypeService materialTypeService;

    /**
     * @Description: 获取设施材质类型信息
     * @author hhp
     * @date 2021/9/4 16:34
     * @param materialTypeInfo:
     * @return {@link LayuiTableResult}
     */
    @RequestMapping(value = "getAllMaterialType",method = RequestMethod.POST)
    @ResponseBody
    public LayuiTableResult getAllMaterialType(@RequestBody MaterialTypeInfo materialTypeInfo){
        logger.info("MaterialTypeInfo:"+materialTypeInfo);
//        if (materialTypeInfo.getPage() != null && materialTypeInfo.getLimit() != null){
//            materialTypeInfo.setOffSet((materialTypeInfo.getPage() - 1) * materialTypeInfo.getLimit());
//        }
        int count = materialTypeService.getAllMaterialTypeCount(materialTypeInfo);
        List<MaterialTypeInfo> list = materialTypeService.getAllMaterialType(materialTypeInfo);
        return new LayuiTableResult(count,list);
    }

    /**
     * @Description: 跳转至设施材质类型新增编辑页面
     * @author hhp
     * @date 2021/9/4 16:35
     * @return {@link String}
     */
    @RequestMapping("toAddMaterialTypePage")
    public String toAddMaterialTypePage() {
        return "management/deviceManagement/materialTypeManagement/addMaterialType";
    }

    /**
     * @Description: 新增设施材质类型
     * @author hhp
     * @date 2021/9/4 16:36
     * @param materialTypeInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("insertMaterialTypeData")
    @ResponseBody
    public JSONObject insertMaterialTypeData(MaterialTypeInfo materialTypeInfo) {
        materialTypeInfo.setCreateTime(MyUtil.getNowDateTime());
        materialTypeInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = materialTypeService.insert(materialTypeInfo);
        return ResponseJSONObject.retMsg(iRet,"设施材质类型新增");
    }

    /**
     * @Description: 更新设施材质类型数据
     * @author hhp
     * @date 2021/9/4 16:37
     * @param materialTypeInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("updateMaterialTypeData")
    @ResponseBody
    public JSONObject updateMaterialTypeData(MaterialTypeInfo materialTypeInfo) {
        materialTypeInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = materialTypeService.updateByPrimaryKeySelective(materialTypeInfo);
        return ResponseJSONObject.retMsg(iRet,"设施材质类型更新");
    }

    /**
     * @Description: 删除设施材质类型
     * @author hhp
     * @date 2021/9/4 16:38
     * @param id:
     * @return {@link JSONObject}
     */
    @RequestMapping("delMaterialTypeData")
    @ResponseBody
    public JSONObject delMaterialTypeData(int id) {
        int iRet = materialTypeService.deleteByPrimaryKey(id);
        return ResponseJSONObject.retMsg(iRet,"管网点位类型删除");
    }
}
