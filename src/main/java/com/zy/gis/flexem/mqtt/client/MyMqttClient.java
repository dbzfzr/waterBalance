package com.zy.gis.flexem.mqtt.client;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/10/13 11:28
 */

public class MyMqttClient  {

    public static MqttClient mqttClient = null;
    private static MemoryPersistence memoryPersistence = null;
    private static MqttConnectOptions mqttConnectOptions = null;
    public static String serverIP = "112.124.16.160";
    public static int serverPort = 14000;
    public static String Host = "tcp://" + serverIP + ":" + serverPort;

    public static MyMqttClient myMqttClient;

    public static MyMqttClient getInstance()
    {
       if (myMqttClient == null){
           myMqttClient = new MyMqttClient();
       }
       return myMqttClient;
    }
    public static  void init(String clientId) {
        //初始化连接设置对象
        mqttConnectOptions = new MqttConnectOptions();
        //初始化MqttClient
        if(null != mqttConnectOptions) {
//			true可以安全地使用内存持久性作为客户端断开连接时清除的所有状态
            mqttConnectOptions.setCleanSession(true);
//			设置连接超时
            mqttConnectOptions.setConnectionTimeout(30);
//			设置持久化方式
            memoryPersistence = new MemoryPersistence();

            if(null != memoryPersistence && null != clientId) {
                try {
                    mqttClient = new MqttClient(Host, clientId, memoryPersistence);
                } catch (MqttException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }else {

            }
        }else {
            System.out.println("mqttConnectOptions对象为空");
        }

        System.out.println("客户端状态---->" + mqttClient.isConnected());
        //设置连接和回调
        if (null != mqttClient) {
            if(!mqttClient.isConnected()) {

//			创建回调函数对象
                MqttReceiveCallback mqttReceiveCallback = new MqttReceiveCallback();
//			客户端添加回调函数
                mqttClient.setCallback(mqttReceiveCallback);
//			创建连接
                try {
                    System.out.println("创建连接");
                    mqttClient.connect(mqttConnectOptions);
                } catch (MqttException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }else {
            System.out.println("mqttClient为空");
        }
        System.out.println("客户端状态---->"+mqttClient.isConnected());
    }

    //	关闭连接
    public void closeConnect() {
        //关闭存储方式
        if(null != memoryPersistence) {
            try {
                memoryPersistence.close();
            } catch (MqttPersistenceException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else {
            System.out.println("memoryPersistence is null");
        }

//		关闭连接
        if(null != mqttClient) {
            if(mqttClient.isConnected()) {
                try {
                    mqttClient.disconnect();
                    mqttClient.close();
                } catch (MqttException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }else {
                System.out.println("client is not connect");
            }
        }else {
            System.out.println("client is null");
        }
    }

    //	发布消息
    /***
     * @Description:发布消息
     * @author hhp
     * @date 2021/10/13 18:01
     * @param pubTopic: 主题
     * @param message:消息
     * @param qos:消息质量
     * @return
     */
    public void publishMessage(String pubTopic, String message, int qos) {
        if (null != mqttClient && mqttClient.isConnected()) {
            System.out.println("发布消息   " + mqttClient.isConnected());
            System.out.println("id:" + mqttClient.getClientId());
            MqttMessage mqttMessage = new MqttMessage();
            mqttMessage.setQos(qos);
            mqttMessage.setPayload(message.getBytes());

            MqttTopic topic = mqttClient.getTopic(pubTopic);

            if (null != topic) {
                try {
                    MqttDeliveryToken publish = topic.publish(mqttMessage);
                    if (!publish.isComplete()) {
                        System.out.println("消息发布成功");
                    }
                } catch (MqttException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }else {
            restartConnect();
        }
    }
    //	重新连接
    public void restartConnect() {
        if (null != mqttClient) {
            if (!mqttClient.isConnected()) {
                if (null != mqttConnectOptions) {
                    try {
                        mqttClient.connect(mqttConnectOptions);
                    } catch (MqttException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }else {
                    System.out.println("mqttConnectOptions is null");
                }
            }else {
                System.out.println("client is null or connect");
            }
        }else {
            init("123");
        }

    }
    //	订阅主题
    public void subTopic(String topic) {
        if (null != mqttClient&& mqttClient.isConnected()) {
            try {
                mqttClient.subscribe(topic, 1);
            } catch (MqttException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else {
            System.out.println("client is error");
        }
    }


    //	清空主题
    public void cleanTopic(String topic) {
        if(null != mqttClient&& !mqttClient.isConnected()) {
            try {
                mqttClient.unsubscribe(topic);
            } catch (MqttException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else {
            System.out.println("client is error");
        }
    }

}
