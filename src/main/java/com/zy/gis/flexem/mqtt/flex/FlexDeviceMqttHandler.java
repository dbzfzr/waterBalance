package com.zy.gis.flexem.mqtt.flex;

import com.zy.gis.flexem.mqtt.client.MqttReceiveCallback;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Wangchong
 * @date 2021/10/20 17:45
 * @description 繁易屏设备数据 MQTT 协议接收处理类
 */
public class FlexDeviceMqttHandler {

    private static Logger logger = LoggerFactory.getLogger(FlexDeviceMqttHandler.class);

    /**
     * 实现了MQTT 协议的类 MqttClient
     */
    public static MqttClient mqttClient = null;

    private static MemoryPersistence memoryPersistence = null;

    private static MqttConnectOptions mqttConnectOptions = null;

    /**
     * EMQ MQTT代理服务器ip地址
     */
    public static final String EMQ_MQTT_SERVER_IP = "112.124.16.160";

    /**
     * EMQ MQTT代理服务器端口
     */
    public static int EMQ_MQTT_SERVER_PORT = 14000;

    /**
     * EMQ MQTT代理服务器tcp连接host
     */
    public static final String EMQ_MQTT_SERVER_HOST = "tcp://" + EMQ_MQTT_SERVER_IP + ":" + EMQ_MQTT_SERVER_PORT;

    public static FlexDeviceMqttHandler flexDeviceMqttHadler;

    private FlexDeviceMqttHandler(){

    }

    /**
     * 单例
     *
     * @return
     */
    public static FlexDeviceMqttHandler getInstance() {

        synchronized (FlexDeviceMqttHandler.class){
            if (flexDeviceMqttHadler == null) {
                flexDeviceMqttHadler = new FlexDeviceMqttHandler();
            }
        }
        return flexDeviceMqttHadler;
    }

    /**
     * @param clientId 标识MQTT 客户端的id
     * @author Wangchong
     * @date 2021/10/20 17:55
     * @description 与EMQ MQTT代理服务器进行连接
     */
    public void connectToEmqServer(String clientId) {

        if (StringUtils.isEmpty(clientId)) {
            logger.error("connectToEmqServer, clientId为空");
            return;
        }

        //初始化连接设置对象
        mqttConnectOptions = new MqttConnectOptions();

        //true可以安全地使用内存持久性作为客户端断开连接时清除的所有状态
        mqttConnectOptions.setCleanSession(true);

        //设置连接超时
        mqttConnectOptions.setConnectionTimeout(30);

        //设置持久化方式
        memoryPersistence = new MemoryPersistence();

        try {
            mqttClient = new MqttClient(EMQ_MQTT_SERVER_HOST, clientId, memoryPersistence);
        } catch (MqttException e) {
            logger.error("监听繁易设备数据EMQ MQTT服务器连接初始化失败:{}", e.getCause() + e.getMessage());
            mqttClient = null;
            try {
                memoryPersistence.close();
            } catch (MqttPersistenceException mqttPersistenceException) {
                memoryPersistence = null;
                logger.error("关闭memoryPersistence失败:{}", mqttPersistenceException.getMessage());
            }
            return;
        }

        // 设置连接和回调
        if (!mqttClient.isConnected()) {

            if (logger.isInfoEnabled()) {
                logger.info("开始连接EMQ服务器");
            }

            //创建回调函数对象
            MqttReceiveCallback mqttReceiveCallback = new MqttReceiveCallback();

            //客户端添加回调函数
            mqttClient.setCallback(mqttReceiveCallback);

            //开始连接
            try {
                mqttClient.connect(mqttConnectOptions);
            } catch (MqttException e) {
                logger.error("EMQ服务器连接失败:{}", e.getMessage());
                return;
            }

            if (mqttClient.isConnected()) {
                if (logger.isInfoEnabled()) {
                    logger.info("EMQ服务器连接成功");
                }
            }
        }
    }

    public boolean emqIsConnected(){
        return mqttClient.isConnected();
    }

    /**
     * @param
     * @return
     * @author Wangchong
     * @date 2021/10/21 9:58
     * @description TODO 关闭EMQ服务器的连接
     */
    public void closeEmqConnection() {
        try {
            memoryPersistence.close();
        } catch (MqttPersistenceException mqttPersistenceException) {
            memoryPersistence = null;
            logger.error("关闭memoryPersistence失败:{}", mqttPersistenceException.getMessage());
        }

        if (null == mqttClient || !mqttClient.isConnected()) {
            return;
        }

        try {
            mqttClient.disconnect();
            mqttClient.close();
            if (logger.isInfoEnabled()) {
                logger.info("EMQ连接关闭成功!");
            }
        } catch (MqttException e) {
            logger.error("EMQ连接关闭失败:{}", e.getMessage());
        }
    }


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
            System.out.println("发布消息主题:" +  pubTopic);

            System.out.println("id:" + mqttClient.getClientId());

            MqttMessage mqttMessage = new MqttMessage();
            mqttMessage.setQos(qos);
            mqttMessage.setPayload(message.getBytes());

            MqttTopic topic = mqttClient.getTopic(pubTopic);

            if (null != topic) {
                try {
                    MqttDeliveryToken publish = topic.publish(mqttMessage);
                    if (!publish.isComplete()) {
                        System.out.println("消息发布成功:" + message);
                    }
                } catch (MqttException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        } else {
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
                } else {
                    System.out.println("mqttConnectOptions is null");
                }
            } else {
                System.out.println("client is null or connect");
            }
        } else {
            // init("123");
        }

    }

    //	订阅主题
    public void subTopic(String topic) {
        if (null != mqttClient && mqttClient.isConnected()) {
            try {
                mqttClient.subscribe(topic, 1);
            } catch (MqttException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            System.out.println("client is error");
        }
    }

    //	清空主题
    public void cleanTopic(String topic) {
        if (null != mqttClient && mqttClient.isConnected()) {
            try {
                mqttClient.unsubscribe(topic);
            } catch (MqttException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            System.out.println("client is error");
        }
    }

}
