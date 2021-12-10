package com.zy.gis.controller.management.deviceManagement;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.layui.LayuiTableResult;
import com.zy.gis.common.response.ResponseJSONObject;
import com.zy.gis.pojo.devAndFacility.SpecsTypeInfo;
import com.zy.gis.service.SpecsTypeService;
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
 * TODO 设施规格类型
 *
 * @author hhp
 * @date 2021/9/6 9:25
 */
@Controller
public class SpecsTypeController {

    Logger logger = LoggerFactory.getLogger(SpecsTypeController.class);
    @Autowired
    SpecsTypeService specsTypeService;


    /**
     * @Description: 获取设施规格类型信息
     * @author hhp
     * @date 2021/9/6 9:25
     * @param specsTypeInfo:
     * @return {@link LayuiTableResult}
     */
    @RequestMapping(value = "getAllSpecsType",method = RequestMethod.POST)
    @ResponseBody
    public LayuiTableResult getAllSpecsType(@RequestBody SpecsTypeInfo specsTypeInfo){
        logger.info("SpecsTypeInfo:"+specsTypeInfo);
//        if (specsTypeInfo.getPage() != null && specsTypeInfo.getLimit() != null){
//            specsTypeInfo.setOffSet((specsTypeInfo.getPage() - 1) * specsTypeInfo.getLimit());
//        }
        int count = specsTypeService.getAllSpecsTypeCount(specsTypeInfo);
        List<SpecsTypeInfo> list = specsTypeService.getAllSpecsType(specsTypeInfo);
        return new LayuiTableResult(count,list);
    }

    /**
     * @Description: 跳转至设施规格类型新增编辑页面
     * @author hhp
     * @date 2021/9/6 9:25

     * @return {@link String}
     */
    @RequestMapping("toAddSpecsTypePage")
    public String toAddSpecsTypePage() {
        return "management/deviceManagement/specsTypeManagement/addSpecsType";
    }

    /**
     * @Description: 新增设施规格类型
     * @author hhp
     * @date 2021/9/6 9:25
     * @param specsTypeInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("insertSpecsTypeData")
    @ResponseBody
    public JSONObject insertSpecsTypeData(SpecsTypeInfo specsTypeInfo) {
        specsTypeInfo.setCreateTime(MyUtil.getNowDateTime());
        specsTypeInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = specsTypeService.insert(specsTypeInfo);
        return ResponseJSONObject.retMsg(iRet,"设施规格类型新增");
    }

    /**
     * @Description: 更新设施规格类型数据
     * @author hhp
     * @date 2021/9/6 9:25
     * @param specsTypeInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("updateSpecsTypeData")
    @ResponseBody
    public JSONObject updateSpecsTypeData(SpecsTypeInfo specsTypeInfo) {
        specsTypeInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = specsTypeService.updateByPrimaryKeySelective(specsTypeInfo);
        return ResponseJSONObject.retMsg(iRet,"设施规格类型更新");
    }

    /**
     * @Description: 删除设施规格类型
     * @author hhp
     * @date 2021/9/6 9:25
     * @param id:
     * @return {@link JSONObject}
     */
    @RequestMapping("delSpecsTypeData")
    @ResponseBody
    public JSONObject delSpecsTypeData(int id) {
        int iRet = specsTypeService.deleteByPrimaryKey(id);
        return ResponseJSONObject.retMsg(iRet,"设施规格类型删除");
    }
}
