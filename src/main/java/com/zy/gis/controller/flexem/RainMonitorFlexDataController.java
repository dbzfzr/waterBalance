package com.zy.gis.controller.flexem;

import com.zy.gis.common.layui.LayuiTableResult;
import com.zy.gis.orm.qo.RainMonitorDataQueryParameter;
import com.zy.gis.pojo.flexem.FlexState;
import com.zy.gis.pojo.flexem.RainMonitorFlexData;
import com.zy.gis.service.FlexStateService;
import com.zy.gis.service.RainMonitorFlexDataService;
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
@description TODO 雨水监测点繁易屏数据处理控制器
*/
@Controller
public class RainMonitorFlexDataController {

    @Autowired
    private RainMonitorFlexDataService rainMonitorFlexDataService;

    @Autowired
    private FlexStateService flexStateService;

    /**
    @author Wangchong
    @date 2021/11/5 16:14
    @description TODO 访问雨水监测点数据页面
    @param boxNo 繁易屏设备编号
    @return 雨水监测点数据页面
    */
    @RequestMapping("rainMontiorFlexDataPage")
    public String rainMontiorFlexDataPage(Model model, @RequestParam("boxNo")String boxNo){


        FlexState flexState = new FlexState();
        flexState.setBoxNo(boxNo);
        flexState = flexStateService.selectFlexStateList(flexState).get(0);

        if (flexState != null){
            model.addAttribute("flexState", flexState);
        }

        RainMonitorFlexData rainMonitorFlexData = rainMonitorFlexDataService.selectLatestData(boxNo);
        if (rainMonitorFlexData != null) {
            model.addAttribute("rainMonitorFlexData", rainMonitorFlexData);
        }
        return "gis/flexem/rainMonitorFlexDataPage";
    }

    /**
    @author Wangchong
    @date 2021/11/1 13:54
    @description TODO 查询雨水监测点最新的数据
    @param boxNo 繁易屏设备编号
    @return
    */
    @RequestMapping("getLatestRainMonitorFlexData")
    @ResponseBody
    public RainMonitorFlexData getLatestRainMonitorFlexData(@RequestParam("boxNo")String boxNo){

        if (StringUtils.isEmpty(boxNo)){
            return new RainMonitorFlexData();
        }

        RainMonitorFlexData rainMonitorFlexData = rainMonitorFlexDataService.selectLatestData(boxNo);
        return rainMonitorFlexData;
    }

    /**
     @author Wangchong
     @date 2021/11/2 16:43
     @description TODO 查询多条雨水监测点数据
     @param rainMonitorDataQueryParameter 查询参数u
     @return 记录
     */
    @RequestMapping("getRainMonitorFlexDataList")
    @ResponseBody
    public LayuiTableResult getRainMonitorFlexDataList(@RequestBody RainMonitorDataQueryParameter rainMonitorDataQueryParameter){
        List<RainMonitorFlexData> rainMonitorFlexDataList = rainMonitorFlexDataService.selectRainMonitorDataList(rainMonitorDataQueryParameter);
        Integer listCount;

        if (rainMonitorDataQueryParameter.getLimit() == null){
            listCount = rainMonitorFlexDataList.size();
        }else{
            listCount = rainMonitorFlexDataService.selectRainMonitorDataCount(rainMonitorDataQueryParameter);
        }

        return new LayuiTableResult(listCount, rainMonitorFlexDataList);
    }

    /**
    @author Wangchong
    @date 2021/11/10 15:36
    @description TODO 查询历史雨水监测点数据
    @param  rainMonitorDataQueryParameter
    @return
    */
    @RequestMapping("getRainMonitorFlexHistoryDataList")
    @ResponseBody
    public LayuiTableResult getRainMonitorFlexHistoryDataList(@RequestBody RainMonitorDataQueryParameter rainMonitorDataQueryParameter){
        List<RainMonitorFlexData> rainMonitorFlexDataList = rainMonitorFlexDataService.selectRainMonitorHistoryDataList(rainMonitorDataQueryParameter);
        Integer listCount;

        if (rainMonitorDataQueryParameter.getLimit() == null){
            listCount = rainMonitorFlexDataList.size();
        }else{
            listCount = rainMonitorFlexDataService.selectRainMonitorHistoryDataCount(rainMonitorDataQueryParameter);
        }
        return new LayuiTableResult(listCount, rainMonitorFlexDataList);
    }
}
