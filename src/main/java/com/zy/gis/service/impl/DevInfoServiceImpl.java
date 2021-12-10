package com.zy.gis.service.impl;

import com.zy.gis.mapper.devAndFacility.*;
import com.zy.gis.pojo.devAndFacility.DevFlowMeterInfo;
import com.zy.gis.pojo.devAndFacility.DevInfo;
import com.zy.gis.service.DevInfoService;
import com.zy.gis.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/9 10:02
 */
@Service
public class DevInfoServiceImpl implements DevInfoService {

    @Autowired
    DevControlPanelInfoMapper devControlPanelInfoMapper;
    @Autowired
    DevFlowMeterInfoMapper devFlowMeterInfoMapper;
    @Autowired
    DevLevelMeterInfoMapper devLevelMeterInfoMapper;
    @Autowired
    DevRainMeterInfoMapper devRainMeterInfoMapper;
    @Autowired
    DevValveInfoMapper devValveInfoMapper;
    @Autowired
    DevWaterPumpInfoMapper devWaterPumpInfoMapper;
    @Autowired
    DevWaterQualityMeterInfoMapper devWaterQualityMeterInfoMapper;

    @Override
    public int insertDev(DevInfo devInfo) {
        String devType = devInfo.getDevType();
        if(devType == null){
            return -2;//设备类型为空
        }
        devInfo.setDevState("false");
        devInfo.setCreateTime(MyUtil.getNowDateTime());
        devInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = 0;
        switch (devType){
            case "流量计":
                iRet = devFlowMeterInfoMapper.insertDev(devInfo);
                break;
            case "液位计":
                iRet = devLevelMeterInfoMapper.insertDev(devInfo);
                break;
            case "雨量计":
                iRet = devRainMeterInfoMapper.insertDev(devInfo);
                break;
            case "水质仪":
                iRet = devWaterQualityMeterInfoMapper.insertDev(devInfo);
                break;
            case "阀门":
                iRet = devValveInfoMapper.insertDev(devInfo);
                break;
            case "抽水泵":
                iRet = devWaterPumpInfoMapper.insertDev(devInfo);
                break;
            default:
                iRet = -3;//数据库中没有该数据库的表
                break;
        }
        return iRet;
    }

    @Override
    public List<DevInfo> getAllDevInfo(DevInfo devInfo) {
        System.out.println("devInfo:"+devInfo);

        List<DevInfo> devFlowMeterInfoList = devFlowMeterInfoMapper.getAllDev(devInfo);
        for(DevInfo devFlowMaterInfo : devFlowMeterInfoList){
            devFlowMaterInfo.setDevType("流量计");
        }
        List<DevInfo> devLevelMeterInfoList = devLevelMeterInfoMapper.getAllDev(devInfo);
        for(DevInfo devLevelMeter : devLevelMeterInfoList){
            devLevelMeter.setDevType("液位计");
        }
        List<DevInfo> devRainMeterInfoList = devRainMeterInfoMapper.getAllDev(devInfo);
        for(DevInfo devRainMeter : devRainMeterInfoList){
            devRainMeter.setDevType("雨量计");
        }
        List<DevInfo> devWaterQualityMeterInfoList = devWaterQualityMeterInfoMapper.getAllDev(devInfo);
        for(DevInfo devWaterQualityMeter : devWaterQualityMeterInfoList){
            devWaterQualityMeter.setDevType("水质仪");
        }
        List<DevInfo> devValveInfoList = devValveInfoMapper.getAllDev(devInfo);
        for(DevInfo devValve : devValveInfoList){
            devValve.setDevType("阀门");
        }
        List<DevInfo> devWaterPumpInfoList = devWaterPumpInfoMapper.getAllDev(devInfo);
        for(DevInfo devWaterPump : devWaterPumpInfoList){
            devWaterPump.setDevType("抽水泵");
        }

        List<DevInfo> devInfoList = new ArrayList<DevInfo>();
        devInfoList.addAll(devFlowMeterInfoList);
        devInfoList.addAll(devLevelMeterInfoList);
        devInfoList.addAll(devRainMeterInfoList);
        devInfoList.addAll(devWaterQualityMeterInfoList);
        devInfoList.addAll(devValveInfoList);
        devInfoList.addAll(devWaterPumpInfoList);


        Collections.sort(devInfoList);//按创建时间倒序排序

        List<DevInfo> list = new ArrayList<>();//分页
        if(devInfo.getOffSet() != null && devInfo.getLimit() != null){
            int offset = devInfo.getOffSet();
            int limit = devInfo.getLimit();

            int max = (offset +limit) < devInfoList.size() ? (offset + limit) : devInfoList.size();
            for(int i=offset; i<max; i++){
                list.add(devInfoList.get(i));
            }
        }else{
            list = devInfoList;
        }


        return list;
    }

    @Override
    public int getAllDevInfoCount(DevInfo devInfo) {

        int devFlowMeterInfoListCount = devFlowMeterInfoMapper.getAllDevCount(devInfo);
        int devLevelMeterInfoListCount = devLevelMeterInfoMapper.getAllDevCount(devInfo);
        int devRainMeterInfoListCount = devRainMeterInfoMapper.getAllDevCount(devInfo);
        int devWaterQualityMeterInfoListCount = devWaterQualityMeterInfoMapper.getAllDevCount(devInfo);
        int devValveInfoListCount = devValveInfoMapper.getAllDevCount(devInfo);
        int devWaterPumpInfoListCount = devWaterPumpInfoMapper.getAllDevCount(devInfo);
        int count = devFlowMeterInfoListCount + devLevelMeterInfoListCount + devRainMeterInfoListCount + devWaterQualityMeterInfoListCount + devValveInfoListCount + devWaterPumpInfoListCount;
        return count;
    }

    @Override
    public int delDev(DevInfo devInfo) {
        String devType = devInfo.getDevType();
        if(devType == null){
            return -2;
        }
        int iRet = 0;
        switch (devType){
            case "流量计":
                iRet = devFlowMeterInfoMapper.deleteByPrimaryKey(devInfo.getId());
                break;
            case "液位计":
                iRet = devLevelMeterInfoMapper.deleteByPrimaryKey(devInfo.getId());
                break;
            case "雨量计":
                iRet = devRainMeterInfoMapper.deleteByPrimaryKey(devInfo.getId());
                break;
            case "水质仪":
                iRet = devWaterQualityMeterInfoMapper.deleteByPrimaryKey(devInfo.getId());
                break;
            case "阀门":
                iRet = devValveInfoMapper.deleteByPrimaryKey(devInfo.getId());
                break;
            case "抽水泵":
                iRet = devWaterPumpInfoMapper.deleteByPrimaryKey(devInfo.getId());
                break;
            default:
                break;
        }
        return iRet;
    }

    @Override
    public int updateDev(DevInfo devInfo) {
        String devType = devInfo.getDevType();
        if(devType == null){
            return -2;
        }
        int iRet = 0;
        switch (devType){
            case "流量计":
                iRet = devFlowMeterInfoMapper.updateDev(devInfo);
                break;
            case "液位计":
                iRet = devLevelMeterInfoMapper.updateDev(devInfo);
                break;
            case "雨量计":
                iRet = devRainMeterInfoMapper.updateDev(devInfo);
                break;
            case "水质仪":
                iRet = devWaterQualityMeterInfoMapper.updateDev(devInfo);
                break;
            case "阀门":
                iRet = devValveInfoMapper.updateDev(devInfo);
                break;
            case "抽水泵":
                iRet = devWaterPumpInfoMapper.updateDev(devInfo);
                break;
            default:
                break;
        }
        return iRet;
    }
}
