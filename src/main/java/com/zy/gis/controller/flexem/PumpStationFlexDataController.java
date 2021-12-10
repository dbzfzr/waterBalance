package com.zy.gis.controller.flexem;

import com.zy.gis.common.layui.LayuiTableResult;
import com.zy.gis.orm.qo.RainMonitorDataQueryParameter;
import com.zy.gis.pojo.flexem.FlexState;
import com.zy.gis.pojo.flexem.PumpStationFlexData;
import com.zy.gis.service.FlexStateService;
import com.zy.gis.service.PumpStationFlexDataService;
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
public class PumpStationFlexDataController {

    @Autowired
    private PumpStationFlexDataService pumpStationFlexDataService;

    @Autowired
    private FlexStateService flexStateService;

    /**
    @author Wangchong
    @date 2021/11/8 16:14
    @description TODO 访问泵站数据页面
    @param boxNo 繁易屏设备编号
    @return 泵站数据页面
    */
    @RequestMapping("pumpStationFlexDataPage")
    public String rainMontiorFlexDataPage(Model model, @RequestParam("boxNo")String boxNo){


        FlexState flexState = new FlexState();
        flexState.setBoxNo(boxNo);
        flexState = flexStateService.selectFlexStateList(flexState).get(0);

        if (flexState != null){
            model.addAttribute("flexState", flexState);
        }

        PumpStationFlexData pumpStationFlexData = pumpStationFlexDataService.selectLatestData(boxNo);
        if (pumpStationFlexData != null) {
            model.addAttribute("pumpStationFlexData", pumpStationFlexData);
        }

        return "gis/flexem/pumpStationFlexDataPage";
    }

    /**
    @author Wangchong
    @date 2021/11/8 13:54
    @description TODO 查询泵站最新的数据
    @param boxNo 繁易屏设备编号
    @return
    */
    @RequestMapping("getLatestPumpStationFlexData")
    @ResponseBody
    public PumpStationFlexData getLatestRainMonitorFlexData(@RequestParam("boxNo")String boxNo){

        if (StringUtils.isEmpty(boxNo)){
            return new PumpStationFlexData();
        }

        PumpStationFlexData pumpStationFlexData = pumpStationFlexDataService.selectLatestData(boxNo);
        return pumpStationFlexData;
    }

    /**
     @author Wangchong
     @date 2021/11/2 16:43
     @description TODO
     @param queryParameter 查询参数
     @return 记录
     */
    @RequestMapping("getPumpStationFlexDataList")
    @ResponseBody
    public LayuiTableResult getPumpStationFlexDataList(@RequestBody RainMonitorDataQueryParameter queryParameter){
        List<PumpStationFlexData> pumpStationFlexDataList = pumpStationFlexDataService.selectPumpStationFlexDataList(queryParameter);
        Integer listCount;

        if (queryParameter.getLimit() == null){
            listCount =  pumpStationFlexDataList.size();
        }else{
            listCount =  pumpStationFlexDataService.selectPumpStationFlexDataCount(queryParameter);
        }

       return new LayuiTableResult(listCount, pumpStationFlexDataList);
    }

    /**
     @author Wangchong
     @date 2021/11/10 15:44
     @description TODO 查询多条泵站历史数据
     @param queryParameter
     @return
     */
    @RequestMapping("getPumpStationFlexHistoryDataList")
    @ResponseBody
    public LayuiTableResult getPumpStationFlexHistoryDataList(@RequestBody RainMonitorDataQueryParameter queryParameter){
        List<PumpStationFlexData> pumpStationFlexDataList = pumpStationFlexDataService.selectPumpStationFlexHistoryDataList(queryParameter);
        Integer listCount;

        if (queryParameter.getLimit() == null){
            listCount =  pumpStationFlexDataList.size();
        }else{
            listCount =  pumpStationFlexDataService.selectPumpStationFlexHistoryDataCount(queryParameter);
        }

        return new LayuiTableResult(listCount, pumpStationFlexDataList);
    }
}
