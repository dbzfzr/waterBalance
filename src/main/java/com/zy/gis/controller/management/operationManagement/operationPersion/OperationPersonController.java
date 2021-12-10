package com.zy.gis.controller.management.operationManagement.operationPersion;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.layui.LayuiTableResult;
import com.zy.gis.common.response.ResponseJSONObject;
import com.zy.gis.common.utils.DateUtil;
import com.zy.gis.orm.qo.AlarmRecordQueryParameter;
import com.zy.gis.pojo.AlarmRecord;
import com.zy.gis.pojo.UserInfo;
import com.zy.gis.pojo.flexem.AlarmDispatch;
import com.zy.gis.service.AlarmDispatchService;
import com.zy.gis.service.AlarmRecordService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
@author Wangchong
@date 2021/11/12 9:34
@description TODO 运维人员的操作控制器
@param
@return
*/
@Controller
@RequestMapping("operationPerson/")
public class OperationPersonController {

    @Autowired
    private AlarmRecordService alarmRecordService;

    @Autowired
    private AlarmDispatchService alarmDispatchService;
    /**
    @author Wangchong
    @date 2021/11/12 9:50
    @description TODO 运维人员的报警记录页面
    */
    @RequestMapping("alarmRecordPage")
    public String oprerationPersonAlarmRecordPage(){
        return "management/operationManagement/operationPerson/alarmRecord.html";
    }

    /**
    @author Wangchong
    @date 2021/11/12 10:18
    @description TODO 运维操作人员查询派单给自己的事件
    @param
    @return
    */
    @RequestMapping(value = "getAlarmRecordList", method = RequestMethod.POST)
    @ResponseBody
    public LayuiTableResult getAlarmRecordList(@RequestBody AlarmRecordQueryParameter alarmRecordQueryParameter){

        Session session = SecurityUtils.getSubject().getSession();
        UserInfo userInfo = null;
        Object obj = session.getAttribute("users");

        List<AlarmRecord> alarmRecordList = new ArrayList<>();
        Integer count = 0;
        if (obj instanceof UserInfo) {
            userInfo = (UserInfo) obj;
            alarmRecordQueryParameter.setDispatchToUserId(String.valueOf(userInfo.getUserId()));
            alarmRecordList = alarmRecordService.getAlarmRecordList(alarmRecordQueryParameter);
            count = alarmRecordService.getAlarmRecordCount(alarmRecordQueryParameter);
        }

        return new LayuiTableResult(count, alarmRecordList);
    }
//    public LayuiTableResult getAlarmRecordList(@RequestBody AlarmDispatch alarmDispatch){
//
//        Session session = SecurityUtils.getSubject().getSession();
//        UserInfo userInfo = null;
//        Object obj = session.getAttribute("users");
//
//        List<AlarmRecord> alarmRecordList = new ArrayList<>();
//        if (obj instanceof UserInfo) {
//            userInfo = (UserInfo) obj;
//            alarmDispatch.setDispatchToUserId(userInfo.getUserId());
//
//            List<AlarmDispatch> alarmDispatchList = alarmDispatchService.selectAlarmDispatchList(alarmDispatch);
//            List<Integer> alarmRecordIdList = new ArrayList<>();
//            for (AlarmDispatch alarmDispatch1: alarmDispatchList){
//                alarmRecordIdList.add(alarmDispatch1.getAlarmRecordId());
//            }
//
//            alarmRecordList = alarmRecordService.selectAlarmRecordListByIdList(alarmRecordIdList);
//        }
//
//        return new LayuiTableResult(alarmRecordList.size(), alarmRecordList);
//    }

    /**
    @author Wangchong
    @date 2021/11/12 14:54
    @description TODO 运维操作人员确认收到
    @param {"userId":, "alarmRecordId":}
    @return
    */
    @RequestMapping("confirmDispatch")
    @ResponseBody
    public JSONObject confirmDispatch(@RequestBody JSONObject paramJSONObject){

        Integer userId = paramJSONObject.getInteger("userId");
        Integer alarmId = paramJSONObject.getInteger("alarmRecordId");

        if (userId == null || alarmId == null){
            return ResponseJSONObject.fail("参数错误");
        }

        String timeStr = DateUtil.getNowTime();

        AlarmDispatch alarmDispatch = new AlarmDispatch();
        alarmDispatch.setDispatchToUserId(userId);
        alarmDispatch.setAlarmRecordId(alarmId);
        alarmDispatch.setHandleState("处理中");
        alarmDispatch.setWaitHandleTime(timeStr);
        alarmDispatchService.updateSelective(alarmDispatch);

        AlarmRecord alarmRecord = new AlarmRecord();
        alarmRecord.setId(alarmId);
        alarmRecord.setHandleState("处理中");
        alarmRecord.setUpdateTime(timeStr);
        alarmRecordService.updateByPrimaryKeySelective(alarmRecord);

        paramJSONObject.clear();
        paramJSONObject.put("code", 1);
        paramJSONObject.put("msg", "操作成功");

        return paramJSONObject;
    }

    /**
    @author Wangchong
    @date 2021/11/12 15:44
    @description TODO 运维操作人员处理事件
    @param {"userId": , "alarmRecordId":""}
    @return
    */
    @RequestMapping("handleDispatchAlarm")
    @ResponseBody
    public JSONObject handleDispatchAlarm(@RequestBody JSONObject paramJSONObject){

        Integer userId = paramJSONObject.getInteger("userId");
        Integer alarmId = paramJSONObject.getInteger("alarmRecordId");
        String handleResult = paramJSONObject.getString("handleResult");

        if (userId == null || alarmId == null){
            return ResponseJSONObject.fail("参数错误");
        }

        String timeStr = DateUtil.getNowTime();

        // 更改报警派单记录状态
        AlarmDispatch alarmDispatch = new AlarmDispatch();
        alarmDispatch.setDispatchToUserId(userId);
        alarmDispatch.setAlarmRecordId(alarmId);
        alarmDispatch.setHandleState("已处理");
        alarmDispatch.setHandleResult(handleResult);
        alarmDispatchService.updateSelective(alarmDispatch);

        AlarmRecord alarmRecord = new AlarmRecord();
        alarmRecord.setId(alarmId);
        alarmRecord.setHandleState("已处理");
        alarmRecord.setUpdateTime(timeStr);
        alarmRecordService.updateByPrimaryKeySelective(alarmRecord);

        paramJSONObject.clear();
        paramJSONObject.put("code", 1);
        paramJSONObject.put("msg", "操作成功");

        return paramJSONObject;
    }
}
