package com.zy.gis.service.impl;

import com.zy.gis.mapper.devAndFacility.DevTypeInfoMapper;
import com.zy.gis.mapper.devAndFacility.NetworkPointTypeInfoMapper;
import com.zy.gis.mapper.devAndFacility.SystemTypeInfoMapper;
import com.zy.gis.pojo.EasyUITreeInfo;
import com.zy.gis.pojo.devAndFacility.NetworkPointTypeInfo;
import com.zy.gis.pojo.devAndFacility.SystemTypeInfo;
import com.zy.gis.service.QueryService;
import com.zy.gis.service.SystemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/23 16:16
 */
@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    DevTypeInfoMapper devTypeInfoMapper;
    @Autowired
    NetworkPointTypeInfoMapper networkPointTypeInfoMapper;
    @Autowired
    SystemTypeInfoMapper systemTypeInfoMapper;
    @Autowired
    SystemTypeService systemTypeService;

    int i = 0 ;
    /**
     * @Description:获取管网系统组织树
     * @author hhp
     * @date 2021/9/23 17:04
     * @return {@link List< EasyUITreeInfo>}
     */
//    @Override
//    public List<EasyUITreeInfo> getNetworkDevTree() {
//        i = 0 ;
//        List<EasyUITreeInfo> easyUITreeInfoList = new ArrayList<>();
//        List<EasyUITreeInfo> childTreeList = new ArrayList<>();
//        childTreeList.add(getPipelineTree());
//        childTreeList.add(getPointTree());
//        EasyUITreeInfo rainTree = getNewTreeInfo("雨水管网", "my-tree-icon-1",false);
//        EasyUITreeInfo sewageTree = getNewTreeInfo("污水管网", "my-tree-icon-1",false);
//        rainTree.setChildren(childTreeList);
//        sewageTree.setChildren(childTreeList);
//        easyUITreeInfoList.add(rainTree);
//        easyUITreeInfoList.add(sewageTree);
//
//        return easyUITreeInfoList;
//    }

    @Override
    public List<EasyUITreeInfo> getNetworkDevTree() {
        i = 0 ;
        List<EasyUITreeInfo> easyUITreeInfoList = new ArrayList<>();
        List<EasyUITreeInfo> childTreeList = new ArrayList<>();
        childTreeList.add(getPipelineTree());
        childTreeList.add(getPointTree());
        EasyUITreeInfo rainTree = getNewTreeInfo("雨水管网", "my-tree-icon-1",true);
        EasyUITreeInfo sewageTree = getNewTreeInfo("污水管网", "my-tree-icon-1",true);
        rainTree.setChildren(childTreeList);
        sewageTree.setChildren(childTreeList);
        easyUITreeInfoList.add(rainTree);
        easyUITreeInfoList.add(sewageTree);


        EasyUITreeInfo oilSeparator = new EasyUITreeInfo();
        oilSeparator.setText("隔油池");
        oilSeparator.setId("oil");
        oilSeparator.setIconCls("my-tree-icon-1");
        easyUITreeInfoList.add(oilSeparator);


        EasyUITreeInfo alarmTypeEasyUITree = new EasyUITreeInfo();
        alarmTypeEasyUITree.setText("事件类型");
        alarmTypeEasyUITree.setId("alarmType");
        alarmTypeEasyUITree.setIconCls("my-tree-icon-1");
        List<EasyUITreeInfo> childrenAlarmTypeEasyUITreeInfoList = new ArrayList<>();

        EasyUITreeInfo easyUITreeInfo1 = new EasyUITreeInfo();
        easyUITreeInfo1.setText("设备故障");
        easyUITreeInfo1.setIconCls("my-tree-icon-2");

        childrenAlarmTypeEasyUITreeInfoList.add(easyUITreeInfo1);
        EasyUITreeInfo easyUITreeInfo2 = new EasyUITreeInfo();
        easyUITreeInfo2.setText("管网堵塞");
        easyUITreeInfo2.setIconCls("my-tree-icon-2");
        childrenAlarmTypeEasyUITreeInfoList.add(easyUITreeInfo2);

        EasyUITreeInfo easyUITreeInfo3 = new EasyUITreeInfo();
        easyUITreeInfo3.setText("管网破损");
        easyUITreeInfo3.setIconCls("my-tree-icon-2");
        childrenAlarmTypeEasyUITreeInfoList.add(easyUITreeInfo3);
        EasyUITreeInfo easyUITreeInfo4 = new EasyUITreeInfo();
        easyUITreeInfo4.setText("污水偷排");
        easyUITreeInfo4.setIconCls("my-tree-icon-2");
        childrenAlarmTypeEasyUITreeInfoList.add(easyUITreeInfo4);

        EasyUITreeInfo easyUITreeInfo5 = new EasyUITreeInfo();
        easyUITreeInfo5.setText("管道错接");
        easyUITreeInfo5.setIconCls("my-tree-icon-2");
        childrenAlarmTypeEasyUITreeInfoList.add(easyUITreeInfo5);
//        EasyUITreeInfo easyUITreeInfo6 = new EasyUITreeInfo();
//        easyUITreeInfo6.setText("面源污染");
//        easyUITreeInfo6.setIconCls("my-tree-icon-2");
//        childrenAlarmTypeEasyUITreeInfoList.add(easyUITreeInfo6);
        alarmTypeEasyUITree.setChildren(childrenAlarmTypeEasyUITreeInfoList);

        easyUITreeInfoList.add(alarmTypeEasyUITree);

        return easyUITreeInfoList;
    }


    /**
     * @Description:获取管网设备组织树
     * @author hhp
     * @date 2021/9/24 10:34

     * @return {@link List< EasyUITreeInfo>}
     */
    @Override
    public List<EasyUITreeInfo> getNetworkSystemTree() {
         i = 0 ;
        List<EasyUITreeInfo> easyUITreeInfoList = new ArrayList<>();
        EasyUITreeInfo rainTree = getNewTreeInfo("雨水管网", "my-tree-icon-1",false);
        EasyUITreeInfo sewageTree = getNewTreeInfo("污水管网", "my-tree-icon-1",false);
        rainTree.setChildren(getSystemTypeTree());
        sewageTree.setChildren(getSystemTypeTree());
        easyUITreeInfoList.add(rainTree);
        easyUITreeInfoList.add(sewageTree);
        return easyUITreeInfoList;
    }

    /**
     * @Description:获取设施树信息
     * @author hhp
     * @date 2021/9/23 16:52
     * @return {@link EasyUITreeInfo}
     */
    private EasyUITreeInfo getFacilityTypeTree(){
        EasyUITreeInfo pipelineTreeInfo = getNewTreeInfo("管线", "my-tree-icon-3",true);
        EasyUITreeInfo pointTreeInfo = getNewTreeInfo("点位", "my-tree-icon-3",true);
        List<EasyUITreeInfo> facilityTreeChildrenList = new ArrayList<>();
        facilityTreeChildrenList.add(pipelineTreeInfo);
        facilityTreeChildrenList.add(pointTreeInfo);
        EasyUITreeInfo facilityTreeInfo = getNewTreeInfo("设施", "my-tree-icon-2",true);
        facilityTreeInfo.setChildren(facilityTreeChildrenList);
        return facilityTreeInfo;
    }

    /**
     * @Description:获取管线节点
     * @author hhp
     * @date 2021/9/24 10:31
     * @return {@link EasyUITreeInfo}
     */
    private EasyUITreeInfo getPipelineTree(){
        EasyUITreeInfo pipelineTreeInfo = getNewTreeInfos("管线", "my-tree-icon-2",true);
        return pipelineTreeInfo;
    }

    /**
     * @Description:获取点位节点
     * @author hhp
     * @date 2021/9/24 10:32
     * @return {@link EasyUITreeInfo}
     */
    private EasyUITreeInfo getPointTree(){
        EasyUITreeInfo pointTreeInfo = getNewTreeInfo("点位", "my-tree-icon-2",false);
        pointTreeInfo.setChildren(getDevTypeTree());
        return pointTreeInfo;
    }

    /**
     * @Description:获取系统树信息
     * @author hhp
     * @date 2021/9/23 16:59
     * @return {@link EasyUITreeInfo}
     */
    private  List<EasyUITreeInfo> getDevTypeTree(){
        List<NetworkPointTypeInfo> networkPointTypeInfoList = networkPointTypeInfoMapper.getAllNetworkPointType(new NetworkPointTypeInfo());
        List<EasyUITreeInfo> NetworkPointTypeTreeChildrenList = new ArrayList<>();
        for(NetworkPointTypeInfo networkPointTypeInfo : networkPointTypeInfoList){
            EasyUITreeInfo childrenTreeInfo = getNewTreeInfos(networkPointTypeInfo.getPointTypeName(), "my-tree-icon-3",false);
            NetworkPointTypeTreeChildrenList.add(childrenTreeInfo);
        }
//        EasyUITreeInfo systemTreeInfo = getNewTreeInfo("系统", "my-tree-icon-2");
//        systemTreeInfo.setChildren(systemTypeTreeChildrenList);
        return  NetworkPointTypeTreeChildrenList;
    }

    private EasyUITreeInfo getNewTreeInfos(String text, String iconCls, boolean checkState){
        EasyUITreeInfo easyUITreeInfo = new EasyUITreeInfo();
        easyUITreeInfo.setChecked(checkState);
        easyUITreeInfo.setIconCls(iconCls);
        easyUITreeInfo.setText(text);
        easyUITreeInfo.setState("open");
        easyUITreeInfo.setId(String.valueOf(i));
        i++;
        return easyUITreeInfo;
    }

    /**
     * @Description:获取管网点位类型树信息
     * @author hhp
     * @date 2021/9/23 19:30
     * @return {@link EasyUITreeInfo}
     */
    private EasyUITreeInfo getNetworkPointTypeTree(){
        List<NetworkPointTypeInfo> systemTypeInfoList = networkPointTypeInfoMapper.getAllNetworkPointType(new NetworkPointTypeInfo());
        List<EasyUITreeInfo> systemTypeTreeChildrenList = new ArrayList<>();
        for(NetworkPointTypeInfo NetworkPointTypeInfo : systemTypeInfoList){
            EasyUITreeInfo childrenTreeInfo = getNewTreeInfo(NetworkPointTypeInfo.getPointTypeName(), "my-tree-icon-3",true);
            systemTypeTreeChildrenList.add(childrenTreeInfo);
        }
        EasyUITreeInfo systemTreeInfo = getNewTreeInfo("设施", "my-tree-icon-2",true);
        systemTreeInfo.setChildren(systemTypeTreeChildrenList);
        return  systemTreeInfo;
    }
    /**
     * @Description:设备数信息
     * @author hhp
     * @date 2021/9/23 17:03
     * @return {@link EasyUITreeInfo}
     */
//    private  List<EasyUITreeInfo>  getDevTypeTree(){
//        List<DevTypeInfo> devTypeInfoList = devTypeInfoMapper.getAllDevType(new DevTypeInfo());
//        List<EasyUITreeInfo> devTypeTreeChildrenList = new ArrayList<>();
//        for(DevTypeInfo devTypeInfo : devTypeInfoList){
//            EasyUITreeInfo childrenTreeInfo = getNewTreeInfo(devTypeInfo.getDevTypeName(), "my-tree-icon-2",false);
//            devTypeTreeChildrenList.add(childrenTreeInfo);
//        }
////        EasyUITreeInfo devTreeInfo = getNewTreeInfo("设备", "my-tree-icon-2");
////        devTreeInfo.setChildren(devTypeTreeChildrenList);
//        return  devTypeTreeChildrenList;
//    }


     private  List<EasyUITreeInfo>  getSystemTypeTree(){
        List<SystemTypeInfo> systemTypeInfoList = systemTypeService.getAllSystemType(new SystemTypeInfo());
        List<EasyUITreeInfo> systemTypeTreeChildrenList = new ArrayList<>();
        for(SystemTypeInfo systemTypeInfo : systemTypeInfoList){
            EasyUITreeInfo childrenTreeInfo = getNewTreeInfo(systemTypeInfo.getSystemTypeName(), "my-tree-icon-2",false);
            systemTypeTreeChildrenList.add(childrenTreeInfo);
        }

        return  systemTypeTreeChildrenList;
    }


    /**
     * @Description:创建节点
     * @author hhp
     * @date 2021/9/23 16:53
     * @param text: 节点名称
     * @param iconCls: 节点等级
     * @param checkState: 复选框状态 true-选中；false-未选中
     * @return {@link EasyUITreeInfo}
     */
    private EasyUITreeInfo getNewTreeInfo(String text,String iconCls,boolean checkState){
        EasyUITreeInfo easyUITreeInfo = new EasyUITreeInfo();
        easyUITreeInfo.setChecked(checkState);
        easyUITreeInfo.setIconCls(iconCls);
        easyUITreeInfo.setText(text);
        easyUITreeInfo.setState("open");
        easyUITreeInfo.setChildren(getChildren(text));
        easyUITreeInfo.setId(String.valueOf(i));
        i++;
        return easyUITreeInfo;
    }

//    private  List<EasyUITreeInfo>  getChildren(){
//        List<DevTypeInfo> devTypeInfoList =  devTypeInfoMapper.getAllDevType(new DevTypeInfo());
//        List<EasyUITreeInfo> devTypeInfoChildrenList = new ArrayList<>();
//        for(DevTypeInfo devTypeInfo : devTypeInfoList){
//            EasyUITreeInfo childrenTreeInfo = getNewPointTreeInfo(devTypeInfo.getDevTypeName(),"my-tree-icon-3",false);
//            devTypeInfoChildrenList.add(childrenTreeInfo);
//
//        }
//
//        return devTypeInfoChildrenList;
//    }

    private  List<EasyUITreeInfo>  getChildren(String systemTypename){

        List<SystemTypeInfo>  devTypeInfoList = systemTypeInfoMapper.getDevTypeNameGroup(systemTypename);
        List<EasyUITreeInfo> devTypeInfoChildrenList = new ArrayList<>();
        for(SystemTypeInfo devTypeInfo : devTypeInfoList){
            String devTypeNameGroup = devTypeInfo.getDevTypeNameGroup();
//            System.out.println("名称："+devTypeNameGroup);
            String[] devName = devTypeNameGroup.split(",");
            for (int i = 0; i < devName.length; i++) {
//                System.out.println("截取的字符串："+split[i]);
                EasyUITreeInfo childrenTreeInfo = getNewPointTreeInfo(devName[i],"my-tree-icon-3",false);
                devTypeInfoChildrenList.add(childrenTreeInfo);
            }
        }

        return devTypeInfoChildrenList;
    }


    private EasyUITreeInfo getNewPointTreeInfo(String text,String iconCls,boolean checkState){
        EasyUITreeInfo easyUITreeInfo = new EasyUITreeInfo();
        easyUITreeInfo.setIconCls(iconCls);
        easyUITreeInfo.setText(text);
        easyUITreeInfo.setChecked(checkState);
        easyUITreeInfo.setState("open");
        return easyUITreeInfo;
    }




}
