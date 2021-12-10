package com.zy.gis.controller.test;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.pojo.AlarmRecord;
import com.zy.gis.service.AlarmRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @param
 * @author Wangchong
 * @date
 * @description TODO
 * @return
 */
@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    private AlarmRecordService alarmRecordService;

    @RequestMapping("/insertAlarmRecord")
    @ResponseBody
    public JSONObject insertAlarmRecord(@RequestBody AlarmRecord alarmRecord){
        alarmRecordService.insertSelective(alarmRecord);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 1);
        return jsonObject;
    }
}
