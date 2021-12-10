package com.zy.gis.controller.waterbalance;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.layui.LayuiTableResult;
import com.zy.gis.pojo.waterbalance.RainBalance;
import com.zy.gis.pojo.waterbalance.SewageBalance;
import com.zy.gis.service.RainBalanceService;
import com.zy.gis.service.SewageBalanceService;
import com.zy.gis.waterbalance.ImitateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
@author Wangchong
@date 2021/11/25 19:30
@description TODO 水平衡信息控制器
*/
@Controller
public class WaterBalanceController {

    @Autowired
    private SewageBalanceService sewageBalanceService;

    @Autowired
    private RainBalanceService rainBalanceService;
    /**
    @author Wangchong
    @date 2021/11/27 15:02
    @description TODO 查询最近的8条污水水平衡记录
    @param
    @return
    */
    @RequestMapping("selectNewSewageBalance")
    @ResponseBody
    public JSONObject selectNewSewageBalance(){
        List<SewageBalance> sewageBalanceList = sewageBalanceService.selectNewSewageBalance();
        List<JSONObject> jsonObjectList = new ArrayList<>();

        sewageBalanceList
                .stream()
                .sorted(Comparator.comparing(SewageBalance::getCreateTime))
                .forEach(sewageBalance -> {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("time", sewageBalance.getCreateTime());
                    jsonObject.put("sewageBalance", Integer.valueOf(sewageBalance.getTotalSewageBalance()));

                    jsonObject.put("rainBalance", 75);
                    jsonObjectList.add(jsonObject);
                });

        JSONObject returnJSONObject = new JSONObject();
        returnJSONObject.put("data", jsonObjectList);

        String sewageOutputStr = String.valueOf(ImitateData.BASE_SEWAGE_OUT_PUT);
        sewageOutputStr = sewageOutputStr.substring(0, sewageOutputStr.indexOf("."));
        returnJSONObject.put("sewageOutput", sewageOutputStr);

        String supplyWaterStr = String.valueOf(ImitateData.BASE_SUPPLY_WATER);
        supplyWaterStr = supplyWaterStr.substring(0, supplyWaterStr.indexOf('.'));
        returnJSONObject.put("supplyWater", supplyWaterStr);

        return returnJSONObject;
    }

    /**
    @author Wangchong
    @date 2021/11/27 14:55
    @description TODO 返回水平衡信息的页面
    @return
    */
    @RequestMapping("waterBalancePage")
    public String waterBalancePage(){
        return "waterBalance/waterBalancePage";
    }
    
    /**
    @author Wangchong
    @date 2021/11/27 14:58
    @description TODO 查询污水水平衡信息
    @param paramJSONObject
    @return {@link LayuiTableResult}
    */
    @RequestMapping("sewageBalanceList")
    @ResponseBody
    public LayuiTableResult sewageBalanceList(@RequestBody JSONObject paramJSONObject){

        Integer page = paramJSONObject.getInteger("page");
        Integer limit = paramJSONObject.getInteger("limit");
        if (page != null && limit != null){
            Integer offset = (page - 1) * limit;
            paramJSONObject.put("offset", offset);
        }

        List<SewageBalance> sewageBalanceList = sewageBalanceService.selectSewageBalanceList(paramJSONObject);
        Integer recordCount = sewageBalanceService.selectSewageBalanceListCount(paramJSONObject);

        return new LayuiTableResult(recordCount, sewageBalanceList);
    }

    /**
     @author Wangchong
     @date 2021/11/29 11:09
     @description TODO 查询雨水水平衡信息
     @param paramJSONObject
     @return {@link LayuiTableResult}
     */
    @RequestMapping("rainBalanceList")
    @ResponseBody
    public LayuiTableResult rainBalanceList(@RequestBody JSONObject paramJSONObject){

        Integer page = paramJSONObject.getInteger("page");
        Integer limit = paramJSONObject.getInteger("limit");
        if (page != null && limit != null){
            Integer offset = (page - 1) * limit;
            paramJSONObject.put("offset", offset);
        }

        List<RainBalance> rainBalanceList = rainBalanceService.selectRainBalanceList(paramJSONObject);
        Integer recordCount =rainBalanceService.selectRainBalanceListCount(paramJSONObject);

        return new LayuiTableResult(recordCount, rainBalanceList);
    }
}
