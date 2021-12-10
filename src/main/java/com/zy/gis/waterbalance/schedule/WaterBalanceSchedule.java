package com.zy.gis.waterbalance.schedule;

import static com.zy.gis.waterbalance.ImitateData.*;

import com.zy.gis.common.utils.DateUtil;
import com.zy.gis.pojo.waterbalance.RainBalance;
import com.zy.gis.pojo.waterbalance.SewageBalance;
import com.zy.gis.service.RainBalanceService;
import com.zy.gis.service.SewageBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
@author Wangchong
@date 2021/11/25 16:56
@description TODO 计算水平衡定时任务
*/
@Component
@EnableScheduling
public class WaterBalanceSchedule {

    @Autowired
    private SewageBalanceService sewageBalanceService;

    @Autowired
    private RainBalanceService rainBalanceService;

    @Scheduled(cron = "*/10 * * * * *")  //定时器1分钟触发一次
    public void calculateSewageBalance(){

        // 暂时都是模拟数据，先计算

        float currentSewageOutputIncrease = SEWAGE_OUT_PUT_HOUR  * 0.0016f;
        float currentSupplyWaterIncrease = SUPPLY_WATER_HOUR  * 0.0016f;

        SewageBalance sewageBalance = new SewageBalance();

        // A区域
        float aAreaBalance = (BASE_SEWAGE_OUT_PUT + currentSewageOutputIncrease* (float) Math.random() * A_AREA_VILLAGE_UNIT_COUNT ) / (BASE_SUPPLY_WATER + currentSupplyWaterIncrease * (float) Math.random()* A_AREA_VILLAGE_UNIT_COUNT) * 100;

        if (aAreaBalance < 73.0f){
            aAreaBalance = 73.0f;
        }

        sewageBalance.setaAreaBalance(String.valueOf((int)aAreaBalance));

        float bAreaBalance = (BASE_SEWAGE_OUT_PUT + currentSewageOutputIncrease * (float) Math.random()* B_AREA_VILLAGE_UNIT_COUNT ) / (BASE_SUPPLY_WATER + currentSupplyWaterIncrease * (float) Math.random()* B_AREA_VILLAGE_UNIT_COUNT) * 100;
        if (bAreaBalance < 73.0f){
            bAreaBalance = 73.0f;
        }
        sewageBalance.setbAreaBalance(String.valueOf((int)bAreaBalance));

        float cAreaBalance = (BASE_SEWAGE_OUT_PUT + currentSewageOutputIncrease * (float) Math.random()* C_AREA_VILLAGE_UNIT_COUNT ) / (BASE_SUPPLY_WATER + currentSupplyWaterIncrease * (float) Math.random()* C_AREA_VILLAGE_UNIT_COUNT) * 100;
        if (cAreaBalance < 73.0f){
            cAreaBalance = 73.0f;
        }
        sewageBalance.setcAreaBalance(String.valueOf((int)cAreaBalance));

        float dAreaBalance = (BASE_SEWAGE_OUT_PUT + currentSewageOutputIncrease * (float) Math.random()* D_AREA_VILLAGE_UNIT_COUNT ) / (BASE_SUPPLY_WATER + currentSupplyWaterIncrease * (float) Math.random()* D_AREA_VILLAGE_UNIT_COUNT) * 100;
        if (dAreaBalance < 73.0f){
            dAreaBalance = 73.0f;
        }
        sewageBalance.setdAreaBalance(String.valueOf((int)dAreaBalance));

        float eAreaBalance = (BASE_SEWAGE_OUT_PUT + currentSewageOutputIncrease * (float) Math.random()* E_AREA_VILLAGE_UNIT_COUNT ) / (BASE_SUPPLY_WATER + currentSupplyWaterIncrease * (float) Math.random()* E_AREA_VILLAGE_UNIT_COUNT) * 100;
        if (eAreaBalance < 73.0f){
            eAreaBalance = 73.0f;
        }
        sewageBalance.seteAreaBalance(String.valueOf((int)eAreaBalance));

        float fAreaBalance = (BASE_SEWAGE_OUT_PUT + currentSewageOutputIncrease * (float) Math.random()* F_AREA_VILLAGE_UNIT_COUNT ) / (BASE_SUPPLY_WATER + currentSupplyWaterIncrease * (float) Math.random()* F_AREA_VILLAGE_UNIT_COUNT) * 100;
        if (fAreaBalance < 73.0f){
            fAreaBalance = 73.0f;
        }
        sewageBalance.setfAreaBalance(String.valueOf((int)fAreaBalance));

        float gAreaBalance = (BASE_SEWAGE_OUT_PUT + currentSewageOutputIncrease * (float) Math.random() * G_AREA_VILLAGE_UNIT_COUNT ) / (BASE_SUPPLY_WATER + currentSupplyWaterIncrease * (float) Math.random() * G_AREA_VILLAGE_UNIT_COUNT) * 100;
        if (gAreaBalance < 73.0f){
            gAreaBalance = 73.0f;
        }
        sewageBalance.setgAreaBalance(String.valueOf((int)gAreaBalance));

        BASE_SEWAGE_OUT_PUT = BASE_SEWAGE_OUT_PUT + SEWAGE_OUT_PUT_HOUR * (float) Math.random() * 0.0016f * 62;

        BASE_SUPPLY_WATER = BASE_SUPPLY_WATER + SUPPLY_WATER_HOUR * (float) Math.random() * 0.0016f * 62;

        float totalSewageBalance = (aAreaBalance + bAreaBalance + cAreaBalance + dAreaBalance + eAreaBalance + fAreaBalance + gAreaBalance) / 7;

        String totalSewageBalanceStr = String.valueOf((int)totalSewageBalance);

        sewageBalance.setTotalSewageBalance(totalSewageBalanceStr);
//        if (aAreaBalance < 75.0f){
//            BASE_SEWAGE_OUT_PUT = BASE_SEWAGE_OUT_PUT + 6;
//            aAreaBalance = BASE_SEWAGE_OUT_PUT  / BASE_SUPPLY_WATER * 100;
//        }
        String nowTimeStr = DateUtil.getNowTime();
        sewageBalance.setCreateTime(nowTimeStr);

        sewageBalanceService.insertSelective(sewageBalance);

        RainBalance rainBalance = new RainBalance();
        rainBalance.setCreateTime(nowTimeStr);
        rainBalance.setY1AreaBalance("75");
        rainBalance.setY2AreaBalance("75");
        rainBalance.setY3AreaBalance("75");
        rainBalance.setTotalRainBalance("75");

        rainBalanceService.insertSelective(rainBalance);
    }
}
