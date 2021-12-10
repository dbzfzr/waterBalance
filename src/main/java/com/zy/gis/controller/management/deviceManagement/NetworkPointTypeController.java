package com.zy.gis.controller.management.deviceManagement;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.layui.LayuiTableResult;
import com.zy.gis.common.response.ResponseJSONObject;
import com.zy.gis.pojo.devAndFacility.NetworkPointTypeInfo;
import com.zy.gis.service.NetworkPointTypeService;
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
 * @date 2021/9/4 15:39
 */
@Controller
public class NetworkPointTypeController {
    
    Logger logger = LoggerFactory.getLogger(NetworkPointTypeController.class);
    @Autowired
    NetworkPointTypeService networkPointTypeService;

    /**
     * @Description: 获取管网点位类型信息
     * @author hhp
     * @date 2021/9/4 15:41 
     * @param networkPointTypeInfo: 
     * @return {@link LayuiTableResult}
     */
    @RequestMapping(value = "getAllNetworkPointType",method = RequestMethod.POST)
    @ResponseBody
    public LayuiTableResult getAllNetworkPointType(@RequestBody NetworkPointTypeInfo networkPointTypeInfo){
        logger.info("networkPointTypeInfo:"+networkPointTypeInfo);
//        if (networkPointTypeInfo.getPage() != null && networkPointTypeInfo.getLimit() != null){
//            networkPointTypeInfo.setOffSet((networkPointTypeInfo.getPage() - 1) * networkPointTypeInfo.getLimit());
//        }
        int count = networkPointTypeService.getAllNetworkPointTypeCount(networkPointTypeInfo);
        List<NetworkPointTypeInfo> list = networkPointTypeService.getAllNetworkPointType(networkPointTypeInfo);
        return new LayuiTableResult(count,list);
    }


    /**
     * @Description: 跳转至管网点位类型新增编辑页面
     * @author hhp
     * @date 2021/9/4 15:43
     * @return {@link String}
     */
    @RequestMapping("toAddNetworkPointTypePage")
    public String toAddNetworkPointTypePage() {
        return "management/deviceManagement/networkPointTypeManagement/addNetworkPointType";
    }

    /**
     * @Description: 新增管网点位类型
     * @author hhp
     * @date 2021/9/4 15:45
     * @param networkPointTypeInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("insertNetworkPointTypeData")
    @ResponseBody
    public JSONObject insertNetworkPointTypeData(NetworkPointTypeInfo networkPointTypeInfo) {
        networkPointTypeInfo.setCreateTime(MyUtil.getNowDateTime());
        networkPointTypeInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = networkPointTypeService.insert(networkPointTypeInfo);
        return ResponseJSONObject.retMsg(iRet,"管网点位类型新增");
    }

    /**
     * @Description: 更新管网点位类型数据
     * @author hhp
     * @date 2021/9/4 15:46
     * @param networkPointTypeInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("updateNetworkPointTypeData")
    @ResponseBody
    public JSONObject updateNetworkPointTypeData(NetworkPointTypeInfo networkPointTypeInfo) {
        networkPointTypeInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = networkPointTypeService.updateByPrimaryKeySelective(networkPointTypeInfo);
        return ResponseJSONObject.retMsg(iRet,"管网点位类型更新");
    }

    /**
     * @Description: 删除管网点位类型
     * @author hhp
     * @date 2021/9/4 15:46
     * @param id:
     * @return {@link JSONObject}
     */
    @RequestMapping("delNetworkPointTypeData")
    @ResponseBody
    public JSONObject delNetworkPointTypeData(int id) {
        int iRet = networkPointTypeService.deleteByPrimaryKey(id);
        return ResponseJSONObject.retMsg(iRet,"管网点位类型删除");
    }
}
