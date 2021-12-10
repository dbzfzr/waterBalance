package com.zy.gis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.mapper.OrganizeInfoMapper;
import com.zy.gis.pojo.EasyUITreeInfo;
import com.zy.gis.pojo.OrganizeInfo;
import com.zy.gis.pojo.devAndFacility.DevControlPanelInfo;
import com.zy.gis.pojo.devAndFacility.SystemTypeInfo;
import com.zy.gis.pojo.flexem.FlexState;
import com.zy.gis.service.DevControlPanelService;
import com.zy.gis.service.FlexStateService;
import com.zy.gis.service.OrganizeService;
import com.zy.gis.service.SystemTypeService;
import com.zy.gis.util.MyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizeServiceImpl implements OrganizeService {

    Logger logger = LoggerFactory.getLogger(OrganizeServiceImpl.class);

    @Autowired
    OrganizeInfoMapper organizeInfoMapper;
    @Autowired
    DevControlPanelService devControlPanelService;
    @Autowired
    SystemTypeService systemTypeService;

    @Autowired
    private FlexStateService flexStateService;

    @Override
    public int insertSelective(OrganizeInfo record) {
        return organizeInfoMapper.insertSelective(record);
    }

    @Override
    public OrganizeInfo selectByPrimaryKey(Integer id) {
        return organizeInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * @Description: 获取以pId为根节点的组织树
     * @author hhp
     * @date 2021/9/1 14:58
     * @param pId: 父节点ID
     * @return {@link List< EasyUITreeInfo>}
     */
    @Override
    public List<EasyUITreeInfo> queryChildrenOrganize(String pId) {
        List<OrganizeInfo> rootList = organizeInfoMapper.queryChildrenOrganize("0");
        //组织树为空 创建根节点
        if(rootList.size() == 0){
            OrganizeInfo rootInfo = new OrganizeInfo();
//            rootInfo.setId(MyUtil.getUUID());
            rootInfo.setOrganizeName("根节点");
            rootInfo.setNodeLevel("my-tree-icon-1");
            rootInfo.setpId("0");
            rootInfo.setCreateTime(MyUtil.getNowDateTime());
            rootInfo.setUpdateTime(MyUtil.getNowDateTime());
            int iRet = insertSelective(rootInfo);
            logger.info(iRet > 0 ? "添加根节点成功！" : "添加根节点失败！");
        }

        List<OrganizeInfo> organizeInfoList = organizeInfoMapper.queryChildrenOrganize(pId);
        //获取所有子树
//        for(OrganizeInfo organizeInfo : organizeInfoList){
//            organizeInfo.setChildren(getChildrenTree(organizeInfo));
//        }
        List<EasyUITreeInfo> easyUITreeInfoList = setEasyTreeInfo(organizeInfoList,false,null);
        return easyUITreeInfoList;
    }

    /**
     * @Description:根据组织等级获取树结构数据
     * @author hhp
     * @date 2021/9/29 15:29
     * @param iconCls:
     * @return {@link List< EasyUITreeInfo>}
     */
    @Override
    public List<EasyUITreeInfo> queryChildrenOrganizeByLevel(String iconCls, List<SystemTypeInfo> systemTypeInfoList) {//iconCls：查询不同节点级别下的组织树。
        OrganizeInfo organizeInfo = new OrganizeInfo();
        organizeInfo.setNodeLevel(iconCls);
        List<OrganizeInfo> organizeInfoList = organizeInfoMapper.getAllOrganize(organizeInfo);

        List<EasyUITreeInfo> easyUITreeInfoList = new ArrayList<>();
        List<String> pIdList = new ArrayList<>();

        for(OrganizeInfo info : organizeInfoList){

            boolean isExsit = false;

            for (int i=0; i<pIdList.size(); i++){
                if(info.getpId().equals(pIdList.get(i))){
                    isExsit = true;
                }
            }
            if(isExsit){
                continue;
            }else{
                pIdList.add(info.getpId());
            }
            List<OrganizeInfo> childList = organizeInfoMapper.queryChildrenOrganize(info.getpId());
            boolean isNeedDev = false;
            if (systemTypeInfoList.size() > 0){
                isNeedDev = true;
            }else{
                isNeedDev = false;
            }
            List<EasyUITreeInfo> treeList = setEasyTreeInfo(childList,isNeedDev,systemTypeInfoList);
            easyUITreeInfoList.addAll(treeList);
        }
        return easyUITreeInfoList;
    }


    /**
     * @Description:根据组织等级获取区域选择中树结构数据
     * @param iconCls
     * @param systemTypeInfoList
     * @author mq
     * @return
     */
    @Override
    public List<EasyUITreeInfo> queryRegionSelectionChildrenOrganizeByLevel(String iconCls, List<SystemTypeInfo> systemTypeInfoList) {
        OrganizeInfo organizeInfo = new OrganizeInfo();
        organizeInfo.setNodeLevel(iconCls);
        List<OrganizeInfo> organizeInfoList = organizeInfoMapper.getAllOrganize(organizeInfo);

        List<EasyUITreeInfo> easyUITreeInfoList = new ArrayList<>();
        List<String> pIdList = new ArrayList<>();

        for(OrganizeInfo info : organizeInfoList){

            boolean isExsit = false;

            for (int i=0; i<pIdList.size(); i++){
                if(info.getpId().equals(pIdList.get(i))){
                    isExsit = true;
                }
            }
            if(isExsit){
                continue;
            }else{
                pIdList.add(info.getpId());
            }
            List<OrganizeInfo> childList = organizeInfoMapper.queryChildrenOrganize(info.getpId());
            boolean isNeedDev = false;
            if (systemTypeInfoList.size() > 0){
                isNeedDev = true;
            }else{
                isNeedDev = false;
            }
            List<EasyUITreeInfo> treeList = setEasyTreeInfoRegionSelection(childList,isNeedDev,systemTypeInfoList);
            easyUITreeInfoList.addAll(treeList);
        }
        return easyUITreeInfoList;
    }


    @Override
    public List<OrganizeInfo> getAllOrganize(OrganizeInfo organizeInfo) {
        return organizeInfoMapper.getAllOrganize(organizeInfo);
    }
    @Override
    public List<OrganizeInfo>  getNodeLevel(OrganizeInfo organizeInfo) {
        return organizeInfoMapper.getAllOrganize(organizeInfo);
    }



    @Override
    public int updateByPrimaryKeySelective(OrganizeInfo record) {
        return organizeInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return organizeInfoMapper.deleteByPrimaryKey(id);
    }

    //递归查找子节点
    private List<OrganizeInfo> getChildrenTree(OrganizeInfo organizeInfo){
        List<OrganizeInfo> list = organizeInfoMapper.queryChildrenOrganize(String.valueOf(organizeInfo.getId()));
        for(OrganizeInfo temp : list){
            temp.setChildren(getChildrenTree(temp));
        }
        organizeInfo.setSpread("true");
        return list;
    }

//    //递归查找子节点
//    private List<EasyUITreeInfo> getEasyChildrenTree(OrganizeInfo organizeInfo,Boolean isNeedDev,List<SystemTypeInfo> systemTypeInfoList){
//        String organizeId = String.valueOf(organizeInfo.getId());
//        List<OrganizeInfo> list = organizeInfoMapper.queryChildrenOrganize(organizeId);
//        if(isNeedDev){
//            //获取工控屏所在组织树下的节点等级
//            String upLevel = organizeInfo.getNodeLevel();
//            int upLevelNumber = Integer.valueOf(upLevel.substring(upLevel.length()-1));
//            upLevelNumber++;
//
//            //获取工控屏信息
//            List<DevControlPanelInfo> devControlPanelInfoList = devControlPanelService.getAllDevControlPanelInfo(organizeId);
//
//            if (devControlPanelInfoList.size() > 0){
////                //获取系统类型
////                List<SystemTypeInfo> systemTypeInfoList = systemTypeService.getAllSystemType(null);
//                //每种系统类型的工控屏数量数组
//                int[] systemNum = new int[systemTypeInfoList.size()];
//                //系统类型数组
//                String[] systemType = new String[systemTypeInfoList.size()];
//                for(int i=0; i<systemTypeInfoList.size() ;i++){
//                    systemType[i] = systemTypeInfoList.get(i).getSystemTypeName();
//                }
//                List<OrganizeInfo> devOrganizeList = new ArrayList<>();
//
//                JSONObject tempJSONObjext = new JSONObject();
//                //遍历工控屏数据，插入到上一级子集合中
//                for(int j=0; j<devControlPanelInfoList.size(); j++){
//                    DevControlPanelInfo info = devControlPanelInfoList.get(j);
//                    //获取工控屏在组织树节点的名称
//                    String text = organizeInfo.getOrganizeName();//仁苑小区
//                    //判断该工控屏的系统类型是不是需要的
//                    boolean isExist = false;
//                    if (systemType.length > 0){
//                        for(int i=0; i<systemType.length; i++){
//                            if(info.getSystemType().equals(systemType[i])){
//                                int num = systemNum[i];
//                                num++;
//                                systemNum[i] = num;
//                                text = text + systemType[i] + systemNum[i] + "号";
//                                isExist = true;
//                            }
//                        }
//                    }else{
//                        int num = j + 1;
//                        text = text + num + "号";
//                    }
//                    //若工控屏的系统类型使我们需要的，才将它加入到组织树中
//                    if (isExist){
//                        OrganizeInfo devOrganizeInfo = new OrganizeInfo();
//                        devOrganizeInfo.setpId(organizeId);
//                        devOrganizeInfo.setId(-1);//确保查不出下一级
//
//                        // 20211102 Wangchong 设施系统类型节点存储繁易屏设备编号额外字段
//                        if (info.getBoxNo() != null){
//                            tempJSONObjext.put("boxNo", info.getBoxNo());
//                            tempJSONObjext.put("systemType", info.getSystemType());
//                            devOrganizeInfo.setReserveField(tempJSONObjext.toJSONString());
//                        }
//
//                        devOrganizeInfo.setOrganizeName(text);
//                        devOrganizeInfo.setNodeLevel("my-tree-icon-" + upLevelNumber);
//                        devOrganizeList.add(devOrganizeInfo);
//                    }
//                }
//
//                //对设备进行排序
//                for(int i=0; i<systemType.length; i++){
//                    for(OrganizeInfo info : devOrganizeList){
//                        if(info.getOrganizeName().contains(systemType[i])){
//                            list.add(info);
//                        }
//                    }
//                }
//
//            }
//        }
//
//
//        List<EasyUITreeInfo> easyUITreeInfoList = setEasyTreeInfo(list, isNeedDev, systemTypeInfoList);
//        return easyUITreeInfoList;
//    }

    //递归查找子节点
    private List<EasyUITreeInfo> getEasyChildrenTree(OrganizeInfo organizeInfo,Boolean isNeedDev,List<SystemTypeInfo> systemTypeInfoList){
        String organizeId = String.valueOf(organizeInfo.getId());
        List<OrganizeInfo> list = organizeInfoMapper.queryChildrenOrganize(organizeId);
        if(isNeedDev){
            //获取工控屏所在组织树下的节点等级
            String upLevel = organizeInfo.getNodeLevel();
            int upLevelNumber = Integer.valueOf(upLevel.substring(upLevel.length()-1));

            upLevelNumber++;

            //获取工控屏信息
            List<DevControlPanelInfo> devControlPanelInfoList = devControlPanelService.getAllDevControlPanelInfo(organizeId);

            if (devControlPanelInfoList.size() > 0){

                // 20211104 Wangchong 对繁易屏设备进行排序
                devControlPanelInfoList = devControlPanelInfoList.stream().
                        sorted(Comparator.comparing(DevControlPanelInfo::getSystemType)).collect(Collectors.toList());

//                //获取系统类型
//                List<SystemTypeInfo> systemTypeInfoList = systemTypeService.getAllSystemType(null);
                //每种系统类型的工控屏数量数组
                int[] systemNum = new int[systemTypeInfoList.size()];
                //系统类型数组
                String[] systemType = new String[systemTypeInfoList.size()];

                for(int i=0; i<systemTypeInfoList.size() ;i++){
                    systemType[i] = systemTypeInfoList.get(i).getSystemTypeName();
                }
                List<OrganizeInfo> devOrganizeList = new ArrayList<>();

                JSONObject tempJSONObjext = new JSONObject();
                //遍历工控屏数据，插入到上一级子集合中
                for(int j=0; j<devControlPanelInfoList.size(); j++){
                    DevControlPanelInfo info = devControlPanelInfoList.get(j);
                    //获取工控屏在组织树节点的名称
                    //String text = organizeInfo.getOrganizeName();//仁苑小区
                    String text = "";
                    //判断该工控屏的系统类型是不是需要的
                    boolean isExist = false;
                    if (systemType.length > 0){
                        for(int i=0; i<systemType.length; i++){
                            if(info.getSystemType().equals(systemType[i])){
//                                int num = systemNum[i];
//                                num++;
//                                systemNum[i] = num;
//                                text = text + systemType[i] + systemNum[i] + "号";
                                text = info.getBoxAlias();
                                isExist = true;
                            }
                        }
                    }else{
                        int num = j + 1;
                        text = text + num + "号";
                    }
                    //若工控屏的系统类型使我们需要的，才将它加入到组织树中
                    if (isExist){
                        OrganizeInfo devOrganizeInfo = new OrganizeInfo();
                        devOrganizeInfo.setpId(organizeId);
                        devOrganizeInfo.setId(-1);//确保查不出下一级

                        // 20211102 Wangchong 设施系统类型节点存储繁易屏设备编号额外字段
                        if (info.getBoxNo() != null){
                            tempJSONObjext.put("boxNo", info.getBoxNo());
                            tempJSONObjext.put("systemType", info.getSystemType());

                            if (info.getBoxState().equals("true")) {
                                tempJSONObjext.put( "flexState", "flexemOnline");
                            } else {
                                tempJSONObjext.put( "flexState",  "flexemOffline");
                            }
                            devOrganizeInfo.setReserveField(tempJSONObjext.toJSONString());
                        }

                        devOrganizeInfo.setOrganizeName(text);
                        String nodeLevel = "my-tree-icon-" + upLevelNumber;
//                        if (info.getBoxState().equals("true")){
//                            nodeLevel = nodeLevel + " flexemOnline";
//                        }else{
//                            nodeLevel = nodeLevel + " flexemOffline";
//                        }
                        devOrganizeInfo.setNodeLevel(nodeLevel);
                        devOrganizeList.add(devOrganizeInfo);
                    }
                }

                list.addAll(devOrganizeList);
                //对设备进行排序
//                for(int i=0; i<systemType.length; i++){
//                    for(OrganizeInfo info : devOrganizeList){
//                        if(info.getOrganizeName().contains(systemType[i])){
//                            list.add(info);
//                        }
//                    }
//                }
            }
        }

        List<EasyUITreeInfo> easyUITreeInfoList = setEasyTreeInfo(list, isNeedDev, systemTypeInfoList);
        return easyUITreeInfoList;
    }

    /***
     * @Description:easyTree实体类赋值
     * @author hhp
     * @date 2021/9/16 9:36
     * @param organizeInfoList:
     * @param isNeedDev:是否需要设备信息  true-->需要，false-->不需要
     * @return {@link List<EasyUITreeInfo>}
     */
    private List<EasyUITreeInfo> setEasyTreeInfo(List<OrganizeInfo> organizeInfoList,Boolean isNeedDev,List<SystemTypeInfo> systemTypeInfoList){
        List<EasyUITreeInfo> easyUITreeInfoList = new ArrayList<>();
        for (OrganizeInfo temp : organizeInfoList){
            EasyUITreeInfo easyUITreeInfo = new EasyUITreeInfo();
            easyUITreeInfo.setId(String.valueOf(temp.getId()));
            easyUITreeInfo.setPId(temp.getpId());
            easyUITreeInfo.setState("open");
            easyUITreeInfo.setText(temp.getOrganizeName());
            easyUITreeInfo.setIconCls(temp.getNodeLevel());//树图标级别

            easyUITreeInfo.setChildren(getEasyChildrenTree(temp, isNeedDev, systemTypeInfoList));

            easyUITreeInfo.setChecked(true);

            // 202111201102 Wangchong  设置其他信息 包括繁易屏设备编号 系统类型
            if (temp.getReserveField() != null){

                JSONObject jsonObject = JSONObject.parseObject(temp.getReserveField());
                String flexStateStr = jsonObject.getString("flexState");

                if (null != flexStateStr){
                    if (flexStateStr.equals("flexemOffline")) {
                        easyUITreeInfo.setIconCls(flexStateStr);
                    }else{
                        FlexState flexState = new FlexState();
                        flexState.setBoxNo(jsonObject.getString("boxNo"));
                        flexState = flexStateService.selectFlexStateList(flexState).get(0);

                        Integer signalStrength = flexState.getFlexemWireless();
                        // 无信号强度的设备
                        if (signalStrength == null){
                            easyUITreeInfo.setIconCls("deviceOnLine");
                        }else {// 有信号强度的设备
                            if (signalStrength > 0 && signalStrength <= 2) {
                                easyUITreeInfo.setIconCls("fourG1");
                            }
                            if (signalStrength > 2 && signalStrength <= 4) {
                                easyUITreeInfo.setIconCls("fourG2");
                            }
                            if (signalStrength > 4 && signalStrength <= 6) {
                                easyUITreeInfo.setIconCls("fourG3");
                            }
                            if (signalStrength > 6 && signalStrength <= 8) {
                                easyUITreeInfo.setIconCls("fourG4");
                            }
                        }
                    }
                }

                easyUITreeInfo.setAttributes(temp.getReserveField());
            }
            easyUITreeInfoList.add(easyUITreeInfo);
        }
        return easyUITreeInfoList;
    }
//    private List<EasyUITreeInfo> setEasyTreeInfo(List<OrganizeInfo> organizeInfoList,Boolean isNeedDev,List<SystemTypeInfo> systemTypeInfoList){
//        List<EasyUITreeInfo> easyUITreeInfoList = new ArrayList<>();
//        for (OrganizeInfo temp : organizeInfoList){
//            EasyUITreeInfo easyUITreeInfo = new EasyUITreeInfo();
//            easyUITreeInfo.setId(String.valueOf(temp.getId()));
//            easyUITreeInfo.setPId(temp.getpId());
//            easyUITreeInfo.setState("open");
//            easyUITreeInfo.setText(temp.getOrganizeName());
//            easyUITreeInfo.setIconCls(temp.getNodeLevel());//树图标级别
//
//            easyUITreeInfo.setChildren(getEasyChildrenTree(temp,isNeedDev,systemTypeInfoList));
//
//            easyUITreeInfo.setChecked(true);
//
//            // Wangchong 设置其他信息 包括繁易屏设备编号 系统类型
//            if (temp.getReserveField() != null){
//
//                JSONObject jsonObject = JSONObject.parseObject(temp.getReserveField());
//                String flexState = jsonObject.getString("flexState");
//
//                if (null != flexState){
//                    easyUITreeInfo.setIconCls(flexState);
//                }
//
//                easyUITreeInfo.setAttributes(temp.getReserveField());
//            }
//            easyUITreeInfoList.add(easyUITreeInfo);
//        }
//        return easyUITreeInfoList;
//    }

    /***
     * @Description:easyTree实体类赋值
     * 驾驶舱区域选择中组织树的实体类复制
     * @author mq
     * @date 2021/11/18 16:31
     * @param organizeInfoList:
     * @param isNeedDev:是否需要设备信息  true-->需要，false-->不需要
     * @return {@link List<EasyUITreeInfo>}
     */


    private List<EasyUITreeInfo> setEasyTreeInfoRegionSelection(List<OrganizeInfo> organizeInfoList,Boolean isNeedDev,List<SystemTypeInfo> systemTypeInfoList){
    List<EasyUITreeInfo> easyUITreeInfoList = new ArrayList<>();
    String treeLevel = "my-tree-icon-6";
    for (OrganizeInfo temp : organizeInfoList){
        EasyUITreeInfo easyUITreeInfo = new EasyUITreeInfo();
        easyUITreeInfo.setId(String.valueOf(temp.getId()));
        easyUITreeInfo.setPId(temp.getpId());
        easyUITreeInfo.setState("open");
        easyUITreeInfo.setText(temp.getOrganizeName());
        easyUITreeInfo.setIconCls(temp.getNodeLevel());//树图标级别
        if(temp.getNodeLevel().equals(treeLevel)){
            return  easyUITreeInfoList;
        }else{
            easyUITreeInfo.setChildren(getEasyChildrenTreeRegionSelection(temp,isNeedDev,systemTypeInfoList));
            easyUITreeInfo.setChecked(true);
        }
        // Wangchong 设置其他信息 包括繁易屏设备编号 系统类型
        if (temp.getReserveField() != null){

            JSONObject jsonObject = JSONObject.parseObject(temp.getReserveField());
            String flexStateStr = jsonObject.getString("flexState");

            if (null != flexStateStr){
                if (flexStateStr.equals("flexemOffline")) {
                    easyUITreeInfo.setIconCls(flexStateStr);
                }else{
                    FlexState flexState = new FlexState();
                    flexState.setBoxNo(jsonObject.getString("boxNo"));
                    flexState = flexStateService.selectFlexStateList(flexState).get(0);
                    int signalStrength = flexState.getFlexemWireless();
                    if (signalStrength >0 && signalStrength <= 2){
                        easyUITreeInfo.setIconCls("fourG1");
                    }
                    if (signalStrength >2 && signalStrength <= 4){
                        easyUITreeInfo.setIconCls("fourG2");
                    }
                    if (signalStrength >4 && signalStrength <= 6){
                        easyUITreeInfo.setIconCls("fourG3");
                    }
                    if (signalStrength >6 && signalStrength <= 8){
                        easyUITreeInfo.setIconCls("fourG4");
                    }
                }
            }

            easyUITreeInfo.setAttributes(temp.getReserveField());
        }
        easyUITreeInfoList.add(easyUITreeInfo);
    }
    return easyUITreeInfoList;
}



    //递归查找子节点
    private List<EasyUITreeInfo> getEasyChildrenTreeRegionSelection(OrganizeInfo organizeInfo,Boolean isNeedDev,List<SystemTypeInfo> systemTypeInfoList){
        String organizeId = String.valueOf(organizeInfo.getId());
        List<OrganizeInfo> list = organizeInfoMapper.queryChildrenOrganize(organizeId);
        if(isNeedDev){
            //获取工控屏所在组织树下的节点等级
            String upLevel = organizeInfo.getNodeLevel();
            int upLevelNumber = Integer.valueOf(upLevel.substring(upLevel.length()-1));
            upLevelNumber++;
            List<DevControlPanelInfo> devControlPanelInfoList = devControlPanelService.getAllDevControlPanelInfo(organizeId);
            if (devControlPanelInfoList.size() > 0){
                devControlPanelInfoList = devControlPanelInfoList.stream().
                        sorted(Comparator.comparing(DevControlPanelInfo::getSystemType)).collect(Collectors.toList());
                int[] systemNum = new int[systemTypeInfoList.size()];
                String[] systemType = new String[systemTypeInfoList.size()];
                for(int i=0; i<systemTypeInfoList.size() ;i++){
                    systemType[i] = systemTypeInfoList.get(i).getSystemTypeName();
                }
                List<OrganizeInfo> devOrganizeList = new ArrayList<>();
                JSONObject tempJSONObjext = new JSONObject();
                for(int j=0; j<devControlPanelInfoList.size(); j++){
                    DevControlPanelInfo info = devControlPanelInfoList.get(j);
                    String text = "";
                    boolean isExist = false;
                    if (systemType.length > 0){
                        for(int i=0; i<systemType.length; i++){
                            if(info.getSystemType().equals(systemType[i])){

                                text = info.getBoxAlias();
                                isExist = true;
                            }
                        }
                    }else{
                        int num = j + 1;
                        text = text + num + "号";
                    }
                    if (isExist){
                        OrganizeInfo devOrganizeInfo = new OrganizeInfo();
                        devOrganizeInfo.setpId(organizeId);
                        devOrganizeInfo.setId(-1);//确保查不出下一级
                        if (info.getBoxNo() != null){
                            tempJSONObjext.put("boxNo", info.getBoxNo());
                            tempJSONObjext.put("systemType", info.getSystemType());
                            if (info.getBoxState().equals("true")) {
                                tempJSONObjext.put( "flexState", "flexemOnline");
                            } else {
                                tempJSONObjext.put( "flexState",  "flexemOffline");
                            }
                            devOrganizeInfo.setReserveField(tempJSONObjext.toJSONString());
                        }
                        devOrganizeInfo.setOrganizeName(text);
                        String nodeLevel = "my-tree-icon-" + upLevelNumber;
                        devOrganizeInfo.setNodeLevel(nodeLevel);
                        devOrganizeList.add(devOrganizeInfo);
                    }
                }
                list.addAll(devOrganizeList);
            }
        }
        List<EasyUITreeInfo> easyUITreeInfoList = setEasyTreeInfoRegionSelection(list, isNeedDev, systemTypeInfoList);
        return easyUITreeInfoList;
    }





































}
