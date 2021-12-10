package com.zy.gis.controller.alarm;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.layui.LayuiTableResult;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Wangchong
 * @date 2021/10/22 19:47
 */
@Controller
public class AlarmRecordController {

    @Autowired
    private AlarmRecordService alarmRecordService;

    @Autowired
    private AlarmDispatchService alarmDispatchService;

    @RequestMapping("alarmRecordPage")
    public String alarmRecordPage(Model model) {
        Session session = SecurityUtils.getSubject().getSession();
        UserInfo userInfo = null;
        Object obj = session.getAttribute("users");

        if (obj instanceof UserInfo) {
            userInfo = (UserInfo) obj;

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userId", userInfo.getUserId());
            jsonObject.put("roleName", userInfo.getRoleName());
            jsonObject.put("roleId", userInfo.getRoleId());
            model.addAttribute("user", jsonObject);
        }
        return "management/equipmentManagement/alarmRecord/alarmRecord";
    }

    /**
     * @param alarmRecordQueryParameter 请求参数
     * @return 信息
     * @author Wangchong
     * @date 2021/10/22 19:52
     * @description 查询报警记录列表
     */
    @RequestMapping(value = "getAlarmRecordList", method = RequestMethod.POST)
    @ResponseBody
    public LayuiTableResult getAlarmRecordList(@RequestBody AlarmRecordQueryParameter alarmRecordQueryParameter) {

        List<AlarmRecord> alarmRecordList = alarmRecordService.getAlarmRecordList(alarmRecordQueryParameter);
        Integer resultCount = null;
        if (alarmRecordQueryParameter.getLimit() != null) {
            resultCount = alarmRecordService.getAlarmRecordCount(alarmRecordQueryParameter);
        } else {
            resultCount = alarmRecordList.size();
        }
        return new LayuiTableResult(resultCount, alarmRecordList);
    }

    /**
     * @return 信息
     * @author Wangchong
     * @date 2021/10/23 14:36
     * @description TODO 统计报警记录处理状态的数量
     */
    @RequestMapping("statisticAlarmHandleStateCount")
    @ResponseBody
    public List<JSONObject> statisticAlarmHandleStateCount() {

        List<JSONObject> resultJsonList = alarmRecordService.statisticAlarmHandleStateCount();

        int totalCount = 0;
        for (JSONObject jsonObject : resultJsonList) {
            totalCount += jsonObject.getInteger("recordCount");
        }

        JSONObject totalJson = new JSONObject();
        totalJson.put("handleState", "total");
        totalJson.put("recordCount", totalCount);
        resultJsonList.add(totalJson);

        return resultJsonList;
    }

    @RequestMapping("getAlarmDispatchList")
    @ResponseBody
    public List<AlarmDispatch> getAlarmDispatchList(@RequestBody AlarmDispatch alarmDispatch) {
        return alarmDispatchService.selectAlarmDispatchList(alarmDispatch);
    }

    /**
     * @param alarmId
     * @return
     * @author Wangchong
     * @date 2021/11/15 16:37
     * @description TODO 报警记录详情页面
     */
    @RequestMapping("alarmInfoPage")
    public String alarmInfoPage(Model model, @RequestParam("alarmId") Integer alarmId) {
        AlarmRecordQueryParameter alarmRecordQueryParameter = new AlarmRecordQueryParameter();
        alarmRecordQueryParameter.setId(alarmId);
        AlarmRecord alarmRecord = alarmRecordService.getAlarmRecordList(alarmRecordQueryParameter).get(0);

        model.addAttribute("alarmRecord", alarmRecord);

        return "info/alarmInfo";
    }
}
