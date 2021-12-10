package com.zy.gis.controller.flexem;

import com.zy.gis.service.NetworkPointService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
@author Wangchong
@date 2021/11/1 11:57
@description TODO 繁易屏的连接的设备的
*/
@Controller
public class FlexemDataController {

    @Autowired
    private NetworkPointService networkPointService;
    /**
    @author Wangchong
    @date 2021/11/1 12:02
    @description TODO 查询最新的设备数据
    @param boxNo 繁易屏设备编号
    @return
    */
    @RequestMapping("getFlexemLatestData")
    @ResponseBody
    public Object getFlexemLatestData(@RequestParam("boxNo")String boxNo){
        if (StringUtils.isEmpty(boxNo)){
            return "参数为空";
        }

        String systemType = networkPointService.selectSystemTypeInfoByBoxNo(boxNo);
        return null;
    }
}
