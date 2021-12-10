package com.zy.gis.common.response;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class ResponseJSONObject implements Serializable {

    public static JSONObject success(String message){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 1);
        jsonObject.put("message", message);
        return jsonObject;
    }
    public static JSONObject fail(String message){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", -1);
        jsonObject.put("message", message);
        return jsonObject;
    }


    public static JSONObject retMsg(int code,String message){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("message", code > 0 ? message+"成功！" : message+"失败！");
        return jsonObject;
    }
}
