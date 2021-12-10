package com.zy.gis.flexem.mqtt.thread;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.flexem.mqtt.client.MyMqttClient;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/10/13 19:49
 */
public class MqttClientThread extends Thread {

    @Override
    public void run() {
        super.run();
        List<String> devSNList = new ArrayList<>();
        devSNList.add("338221064020");

        MyMqttClient myMqttClient = MyMqttClient.getInstance();

        //客户端初始化
        myMqttClient.init("web-balance");

        for(String devSN : devSNList){
            //订阅消息--->接受设备数据
            myMqttClient.subTopic(devSN + "/reply/getDevData");
        }

        //发布消息-->控制阀门
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state",0);//1或者true都表示“打开”;0或false表示“关闭”
        jsonObject.put("msg", "测试mqtt,自己发布自己订阅接收");
        myMqttClient.publishMessage("338221064020/reply/getDevData", jsonObject.toJSONString(),1);
        //myMqttClient.publishMessage("338221064020/getValveState", jsonObject.toJSONString(),1);
//
//        //发布消息-->配置数据上报功能
//        myMqttClient.publishMessage("338221064020/setUploadSettings",new JSONObject().toJSONString(),1);
//
//
//
//        //发布消息-->获取FBOX信息 发送请求
//        JSONObject boxJSON = new JSONObject();
//        boxJSON.put("flexem_get_info","location");//（“location” 获取位置信息，“status” 获取状态信息）
//        myMqttClient.publishMessage("338221064020/getBoxInfo",jsonObject.toJSONString(),1);
//        //订阅信息-->获取FBOX信息
//        myMqttClient.subTopic("338221064020/reply/getBoxInfo");
    }
}
