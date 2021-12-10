package com.zy.gis.controller.management;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.response.ResponseJSONObject;
import com.zy.gis.pojo.EasyUITreeInfo;
import com.zy.gis.pojo.OrganizeInfo;

import com.zy.gis.pojo.devAndFacility.DevTypeInfo;
import com.zy.gis.pojo.devAndFacility.SystemTypeInfo;
import com.zy.gis.service.OrganizeService;
import com.zy.gis.service.SystemTypeService;
import com.zy.gis.util.MyUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class OrganizeController {

    Logger logger = LoggerFactory.getLogger(OrganizeController.class);

    @Autowired
    OrganizeService organizeService;
    @Autowired
    SystemTypeService systemTypeService;

    @RequestMapping("getOrganizeTree")
    @ResponseBody
    public List<EasyUITreeInfo> getOrganizeTree(String pId){
        logger.info("pId:"+pId);
        List<EasyUITreeInfo> easyUITreeInfoList = organizeService.queryChildrenOrganize(pId);
        return easyUITreeInfoList;
    }

    @RequestMapping("getOrganizeTreeByLevel")
    @ResponseBody
    public List<EasyUITreeInfo> getOrganizeTreeByLevel(String iconCls){//iconCls：查询不同节点级别下的组织树。
        logger.info("iconCls:"+iconCls);
//        List<EasyUITreeInfo> easyUITreeInfoList = organizeService.queryChildrenOrganizeByLevel(iconCls,new ArrayList<>());
        List<EasyUITreeInfo> easyUITreeInfoList = organizeService.  queryRegionSelectionChildrenOrganizeByLevel(iconCls,new ArrayList<>());

        return easyUITreeInfoList;
    }




    @RequestMapping("getSearchDevice")
    @ResponseBody
    public List<EasyUITreeInfo> getSearchDevice(@RequestParam String searchDevice){
        System.out.println("---------->搜索");
        System.out.println(searchDevice);
//        List<OrganizeInfo> organizeInfo = organizeService.getSearchDevice(searchDevice);
////        List<EasyUITreeInfo> easyUITreeInfoListInfo = organizeService.queryChildrenOrganize(organizeInfo.get(0).getId() + "");
//
//        List<EasyUITreeInfo> easyUITreeInfoListInfo = organizeService.queryChildrenOrganize(organizeInfo.get(0).getId() + "");
//
//        List<EasyUITreeInfo> childrenOrganize = getChildrenOrganize(easyUITreeInfoListInfo);
//        System.out.println("最后的集合："+childrenOrganize.toString());


        List<SystemTypeInfo> systemTypeInfoList = systemTypeService.getAllSystemType(null);//获取所有的系统类型
        List<EasyUITreeInfo> easyUITreeInfoList = organizeService.queryChildrenOrganizeByLevel("my-tree-icon-1",systemTypeInfoList);
        System.out.println(easyUITreeInfoList);

        List<EasyUITreeInfo> list = new ArrayList<>();
        for(EasyUITreeInfo info : easyUITreeInfoList){
            EasyUITreeInfo easyUITreeInfo = findChildren(info,searchDevice);
            if(easyUITreeInfo != null){
                list.add(easyUITreeInfo);
            }
        }
        return list;
    }

    public EasyUITreeInfo findChildren(EasyUITreeInfo easyUITreeInfo,String keyWord){
        EasyUITreeInfo returnInfo = null;
        if (easyUITreeInfo.getText().contains(keyWord)) {
            returnInfo = easyUITreeInfo;
        }else{
            if(easyUITreeInfo.getChildren()!= null && easyUITreeInfo.getChildren().size() > 0){
                List<EasyUITreeInfo> childList = new ArrayList<>();
                List<EasyUITreeInfo> oldChildList = easyUITreeInfo.getChildren();
                for(EasyUITreeInfo infO : oldChildList){
                    EasyUITreeInfo newInfo = findChildren(infO,keyWord);
                    if(newInfo != null){
                        childList.add(newInfo);
                    }
                }
                if(childList.size()>0){
                    easyUITreeInfo.setChildren(childList);
                    returnInfo = easyUITreeInfo;
                }
            }
        }
        return returnInfo;
    }



//    List<EasyUITreeInfo> easyUITreeInfoList=null;
//    public List<EasyUITreeInfo> getChildrenOrganize(List<EasyUITreeInfo> easyUITreeInfos){
//        for (int i = 0; i < easyUITreeInfos.size(); i++) {
//            easyUITreeInfoList = organizeService.queryChildrenOrganize(easyUITreeInfos.get(i).getId() + "");
//            if (easyUITreeInfoList.size()>0){
//                getChildrenOrganize(easyUITreeInfoList);
//
//            }else {
//                easyUITreeInfoList=easyUITreeInfos;
//            }
//            break;
//        }
//        return easyUITreeInfoList;
//    }


    @RequestMapping("getDevOrganizeTree")
    @ResponseBody
     public  List<EasyUITreeInfo> getOrganizeTreeByLevels(String[] systemTypes){
        List<SystemTypeInfo> systemTypeInfoList = new ArrayList<>();
        if(systemTypes != null ){
            for(String systemType : systemTypes){
                SystemTypeInfo systemTypeInfo = new SystemTypeInfo();
                systemTypeInfo.setSystemTypeName(systemType);
                systemTypeInfoList.add(systemTypeInfo);
            }
        }else{
            //获取系统类型
            systemTypeInfoList = systemTypeService.getAllSystemType(null);
        }

        // 获取含设备信息的组织树
        List<EasyUITreeInfo> easyUITreeInfoList = organizeService.queryChildrenOrganizeByLevel("my-tree-icon-1",systemTypeInfoList);
        return easyUITreeInfoList;
    }

    @RequestMapping("getOrganizeBySystemType")
    @ResponseBody
    public  List<EasyUITreeInfo> getOrganizeBySystemType(String[] systemType){
        System.out.println(systemType);
        return null;
    }

    @RequestMapping("insertOrganize")
    @ResponseBody
    public JSONObject insertOrganize(@RequestBody OrganizeInfo organizeInfo){
        logger.info("organizeInfo:"+organizeInfo);
        //经纬度只保留小数点后六位
        organizeInfo.setLongitude(organizeInfo.getLongitude().substring(0,organizeInfo.getLongitude().indexOf(".")+7));
        organizeInfo.setLatitude(organizeInfo.getLatitude().substring(0,organizeInfo.getLatitude().indexOf(".")+7));
        organizeInfo.setCreateTime(MyUtil.getNowDateTime());
        organizeInfo.setUpdateTime(MyUtil.getNowDateTime());
        JSONObject retJson = new JSONObject();
        int iRet = organizeService.insertSelective(organizeInfo);
        retJson.put("code",iRet);
        retJson.put("msg",iRet > 0 ? "新增成功" : "新增失败");
        return retJson;
    }


    /**
     * @Description:节点新增
     * @author hhp
     * @date 2021/9/16 15:53
     * @param easyUITreeInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("addTree")
    @ResponseBody
    public JSONObject addTree(EasyUITreeInfo easyUITreeInfo){
        logger.info("easyUITreeInfo:"+easyUITreeInfo);
        OrganizeInfo organizeInfo = new OrganizeInfo();
        organizeInfo.setNodeLevel(easyUITreeInfo.getIconCls());
        organizeInfo.setOrganizeName(easyUITreeInfo.getText());
        organizeInfo.setpId(easyUITreeInfo.getPId());
        organizeInfo.setCreateTime(MyUtil.getNowDateTime());
        organizeInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = organizeService.insertSelective(organizeInfo);
        return ResponseJSONObject.retMsg(iRet,"节点新增");
    }

    /**
     * @Description:节点编辑
     * @author hhp
     * @date 2021/9/16 18:09
     * @param easyUITreeInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("modifyTree")
    @ResponseBody
    public JSONObject modifyTree(EasyUITreeInfo easyUITreeInfo){
        logger.info("easyUITreeInfo:"+easyUITreeInfo);
        OrganizeInfo organizeInfo = new OrganizeInfo();
        organizeInfo.setId(Integer.valueOf(easyUITreeInfo.getId()));
        organizeInfo.setOrganizeName(easyUITreeInfo.getText());
        organizeInfo.setUpdateTime(MyUtil.getNowDateTime());
        int iRet = organizeService.updateByPrimaryKeySelective(organizeInfo);
        return ResponseJSONObject.retMsg(iRet,"节点更新");
    }


    /**
     * @Description:删除节点
     * @author hhp
     * @date 2021/9/16 19:57
     * @param easyUITreeInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping("delTree")
    @ResponseBody
    public JSONObject delTree(EasyUITreeInfo easyUITreeInfo){
        int iRet = organizeService.deleteByPrimaryKey(Integer.valueOf(easyUITreeInfo.getId()));
        return ResponseJSONObject.retMsg(iRet,"节点更新");
    }
}
