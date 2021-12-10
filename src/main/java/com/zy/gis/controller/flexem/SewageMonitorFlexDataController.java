package com.zy.gis.controller.flexem;

import com.zy.gis.common.layui.LayuiTableResult;
import com.zy.gis.orm.qo.RainMonitorDataQueryParameter;
import com.zy.gis.pojo.flexem.FlexState;
import com.zy.gis.pojo.flexem.SewageMonitorFlexData;
import com.zy.gis.service.FlexStateService;
import com.zy.gis.service.SewageMonitorFlexDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
@author Wangchong
@date 2021/11/1 11:38
@description TODO 泵站繁易屏数据处理控制器
*/
@Controller
public class SewageMonitorFlexDataController {

    @Autowired
    private SewageMonitorFlexDataService sewageMonitorFlexDataService;

    @Autowired
    private FlexStateService flexStateService;

    /**
    @author Wangchong
    @date 2021/11/8 16:14
    @description TODO 访问污水监测点数据页面
    @param boxNo 繁易屏设备编号
    @return 污水监测点数据页面
    */
    @RequestMapping("sewageMonitorFlexDataPage")
    public String sewageMonitorFlexDataPage(Model model, @RequestParam("boxNo")String boxNo){


        FlexState flexState = new FlexState();
        flexState.setBoxNo(boxNo);
        flexState = flexStateService.selectFlexStateList(flexState).get(0);

        if (flexState != null){
            model.addAttribute("flexState", flexState);
        }

        SewageMonitorFlexData sewageMonitorFlexData = sewageMonitorFlexDataService.selectLatestData(boxNo);
        if (sewageMonitorFlexData != null) {
            model.addAttribute("sewageMonitorFlexData", sewageMonitorFlexData);
        }

        return "gis/flexem/sewageMonitorFlexDataPage";
    }

    /**
    @author Wangchong
    @date 2021/11/8 13:54
    @description TODO 查询污水监测点最新的数据
    @param boxNo 繁易屏设备编号
    @return
    */
    @RequestMapping("getLatestSewageMonitorFlexData")
    @ResponseBody
    public SewageMonitorFlexData getLatestSewageMonitorFlexData(@RequestParam("boxNo")String boxNo){

        if (StringUtils.isEmpty(boxNo)){
            return new SewageMonitorFlexData();
        }

        SewageMonitorFlexData sewageMonitorFlexData = sewageMonitorFlexDataService.selectLatestData(boxNo);
        return sewageMonitorFlexData;
    }

    /**
     @author Wangchong
     @date 2021/11/2 16:43
     @description TODO
     @param queryParameter 查询参数
     @return 记录
     */
    @RequestMapping("getSewageMonitorFlexDataList")
    @ResponseBody
    public LayuiTableResult getSewageMonitorFlexDataList(@RequestBody RainMonitorDataQueryParameter queryParameter){
        List< SewageMonitorFlexData> sewageMonitorFlexDataList = sewageMonitorFlexDataService.selectSewageMonitorFlexDataList(queryParameter);
        Integer listCount;

        if (queryParameter.getLimit() == null){
            listCount =  sewageMonitorFlexDataList.size();
        }else{
            listCount =   sewageMonitorFlexDataService.selectSewageMonitorFlexDataCount(queryParameter);
        }

       return new LayuiTableResult(listCount, sewageMonitorFlexDataList);
    }
    
    /**
    @author Wangchong
    @date 2021/11/10 16:33
    @description TODO 查询污水监测点历史数据
    @param queryParameter
    @return 
    */
    @RequestMapping("getSewageMonitorFlexHistoryDataList")
    @ResponseBody
    public LayuiTableResult getSewageMonitorFlexHistoryDataList(@RequestBody RainMonitorDataQueryParameter queryParameter){
        List< SewageMonitorFlexData> sewageMonitorFlexDataList = sewageMonitorFlexDataService.selectSewageMonitorFlexHistoryDataList(queryParameter);
        Integer listCount;

        if (queryParameter.getLimit() == null){
            listCount =  sewageMonitorFlexDataList.size();
        }else{
            listCount =   sewageMonitorFlexDataService.selectSewageMonitorFlexHistoryDataCount(queryParameter);
        }

        return new LayuiTableResult(listCount, sewageMonitorFlexDataList);
    }
}
