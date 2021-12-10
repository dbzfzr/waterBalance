package com.zy.gis.service.impl;

import com.zy.gis.common.utils.SpringUtil;
import com.zy.gis.mapper.FlexStateMapper;
import com.zy.gis.mapper.devAndFacility.DevControlPanelInfoMapper;
import com.zy.gis.pojo.devAndFacility.DevControlPanelInfo;
import com.zy.gis.pojo.devAndFacility.NetworkPipelineInfo;
import com.zy.gis.pojo.devAndFacility.NetworkPointInfo;
import com.zy.gis.pojo.flexem.FlexState;
import com.zy.gis.service.DevControlPanelService;
import com.zy.gis.service.FlexStateService;
import com.zy.gis.service.NetworkPipelineService;
import com.zy.gis.service.NetworkPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/8 15:43
 */
@Service
public class DevControlPanelServiceImpl implements DevControlPanelService {

    @Autowired
    DevControlPanelInfoMapper devControlPanelInfoMapper;
    @Autowired
    NetworkPointService networkPointService;
    @Autowired
    NetworkPipelineService networkPipelineService;

    @Autowired
    private FlexStateMapper flexStateMapper;

    @Override
    public int insertSelective(DevControlPanelInfo record) {
        // 开启MQTT监听
        SpringUtil.handleOneDeviceOnAddSuccess(record);

        FlexState flexState = new FlexState();
        flexState.setBoxNo(record.getBoxNo());
        flexStateMapper.insertSelective(flexState);

        return devControlPanelInfoMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(DevControlPanelInfo record) {
        return devControlPanelInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return devControlPanelInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public DevControlPanelInfo selectByPrimaryKey(Integer id) {
        return devControlPanelInfoMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<DevControlPanelInfo> getAllDevControlPanelInfo(DevControlPanelInfo record) {

        List<DevControlPanelInfo> list = devControlPanelInfoMapper.getAllDevControlPanelInfo(record);
        for(DevControlPanelInfo info : list){
            if(info.getFacilityType().equals("点位")){
                NetworkPointInfo networkPointInfo = new NetworkPointInfo();
                networkPointInfo.setPointNo(info.getFacilityNo());
                List<NetworkPointInfo> pointInfoList = networkPointService.getAllNetworkPoint(networkPointInfo);
                info.setSystemType(pointInfoList.get(0).getSystemType());
            }else{
                NetworkPipelineInfo networkPipelineInfo = new NetworkPipelineInfo();
                networkPipelineInfo.setPipelineNo(info.getFacilityNo());
                List<NetworkPipelineInfo> pipelineInfoList = networkPipelineService.getAllNetworkPipeline(networkPipelineInfo);
                info.setSystemType(pipelineInfoList.get(0).getSystemType());
            }
        }
        return list;
    }

    @Override
    public List<DevControlPanelInfo> getAllDevControlPanelInfo(String organizeId) {
//        List<DevControlPanelInfo> list = devControlPanelInfoMapper.getAllDevControlPanelInfo(record);
//        for(DevControlPanelInfo info : list){
//            if(info.getFacilityType().equals("��λ")){
//                NetworkPointInfo networkPointInfo = new NetworkPointInfo();
//                networkPointInfo.setPointNo(info.getFacilityNo());
//                networkPointInfo.setAddressId(organizeId);
//                List<NetworkPointInfo> pointInfoList = networkPointService.getAllNetworkPoint(networkPointInfo);
//                info.setSystemType(pointInfoList.get(0).getSystemType());
//            }else{
//                NetworkPipelineInfo networkPipelineInfo = new NetworkPipelineInfo();
//                networkPipelineInfo.setPipelineNo(info.getFacilityNo());
//                networkPipelineInfo.setAddressId(organizeId);
//                List<NetworkPipelineInfo> pipelineInfoList = networkPipelineService.getAllNetworkPipeline(networkPipelineInfo);
//                info.setSystemType(pipelineInfoList.get(0).getSystemType());
//            }
//        }
        NetworkPointInfo networkPointInfo = new NetworkPointInfo();
        networkPointInfo.setAddressId(organizeId);
        List<NetworkPointInfo> pointInfoList = networkPointService.getAllNetworkPoint(networkPointInfo);

        NetworkPipelineInfo networkPipelineInfo = new NetworkPipelineInfo();
        networkPipelineInfo.setAddressId(organizeId);
        List<NetworkPipelineInfo> pipelineInfoList = networkPipelineService.getAllNetworkPipeline(networkPipelineInfo);

        //��ʩ������鼯��
        String[] facilityNo = new String[pointInfoList.size()+pipelineInfoList.size()];
        for(int i=0; i<pointInfoList.size(); i++){
            facilityNo[i] = pointInfoList.get(i).getPointNo();
        }
        for(int i=0; i<pipelineInfoList.size();i++){
            facilityNo[pointInfoList.size()+i] = pipelineInfoList.get(i).getPipelineNo();
        }

        List<DevControlPanelInfo> devControlPanelInfoList = new ArrayList<>();
        for(int i=0; i<facilityNo.length; i++){
            DevControlPanelInfo record = new DevControlPanelInfo();
            record.setFacilityNo(facilityNo[i]);
            List<DevControlPanelInfo> list = getAllDevControlPanelInfo(record);
            devControlPanelInfoList.addAll(list);
        }

        return devControlPanelInfoList;
    }

    @Override
    public int getAllDevControlPanelCount(DevControlPanelInfo record) {
        return devControlPanelInfoMapper.getAllDevControlPanelCount(record);
    }

    @Override
    public int updateDevControlPanelByBoxNo(DevControlPanelInfo record) {
        return devControlPanelInfoMapper.updateDevControlPanelByBoxNo(record);
    }

    /**
     @author Wangchong
     @date 2021/10/30 11:23
     @description TODO 查询所有繁易屏设备编号
     @return 设备编号
     */
    @Override
    public List<String> selectAllBoxNo() {
        return devControlPanelInfoMapper.selectAllBoxNo();
    }
}
