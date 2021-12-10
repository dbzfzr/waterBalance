package com.zy.gis.common.utils;

import com.zy.gis.device.data.DTUDeviceDataHandler;
import com.zy.gis.flexem.mqtt.flex.FlexDeviceMqttHandler;
import com.zy.gis.pojo.devAndFacility.DevControlPanelInfo;
import com.zy.gis.service.DevControlPanelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.List;

/**
@author Wangchong
@date 2021/10/21 11:10
@description  普通类调用Spring bean对象工具类,以及Spring Bean创建完成后，连接 EMQ MQTT服务器，监听数据
*/
@Component
public class SpringUtil  implements ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(SpringUtil.class);

    private static FlexDeviceMqttHandler flexDeviceMqttHandler = FlexDeviceMqttHandler.getInstance();

    private static DTUDeviceDataHandler dtuDeviceDataHandler = DTUDeviceDataHandler.getInstance();

    /**
     * spring 的应用上下文
     */
    private static ApplicationContext springApplicationContext = null;

    /**
    @author Wangchong
    @date 2021/10/29 17:42
    @description TODO 开启繁易屏设备的MQTT数据监听
    */
    public void startMqttListen(){

        flexDeviceMqttHandler.connectToEmqServer("webBalance-client1");

        if (!flexDeviceMqttHandler.emqIsConnected()){
            logger.error("与EMQ服务器连接失败，请检查");
            return;
        }

        DevControlPanelService devControlPanelService = SpringUtil.getBean(DevControlPanelService.class);
        List<String> devControlPanelBoxNoList = devControlPanelService.selectAllBoxNo();
        for (String devSN : devControlPanelBoxNoList){
            // 订阅消息--->接收设备数据
            flexDeviceMqttHandler.subTopic(devSN + "/reply/getDevData");
        }
    }

    /**
    @author Wangchong
    @date 2021/11/22 9:58
    @description TODO 添加一台设备后，开启新设备的MQTT数据监听
    @param devControlPanelInfo
    @return
    */
    public static void handleOneDeviceOnAddSuccess(DevControlPanelInfo devControlPanelInfo){
        flexDeviceMqttHandler.subTopic(devControlPanelInfo.getBoxNo() + "/reply/getDevData");
    }

    /**
    @author Wangchong
    @date 2021/10/21 11:13
    @description TODO
    @param applicationContext
    */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        if (SpringUtil.springApplicationContext == null){
            SpringUtil.springApplicationContext = applicationContext;
        }

        if (logger.isInfoEnabled()){
            logger.info("获取spring的ApplicationContext成功,开启繁易设备数据MQTT监听......");
        }
        // Spring的bean初始化完成后再执行 mqtt监听
        //startMqttListen();

        // 开启一个线程进行netty tcp server的启动
        //new Thread(() -> dtuDeviceDataHandler.startNettyTcpListen()).start();
    }

    public static ApplicationContext getSpringApplicationContext(){
        return springApplicationContext;
    }

    /**
    @author Wangchong
    @date 2021/10/21 11:19
    @description 通过name 获取bean
    @param beanName bean 的名称
    @return bean
    */
    public static Object getBean(String beanName){
        return getSpringApplicationContext().getBean(beanName);
    }

   /**
   @author Wangchong
   @date 2021/10/21 11:23
   @description 通过class获取Bean.
   @param clazz Class对象
   @return bean
   */
    public static <T> T getBean(Class<T> clazz){
        return getSpringApplicationContext().getBean(clazz);
    }
    
    /**
    @author Wangchong
    @date 2021/10/21 11:26
    @description 通过name,以及Clazz返回指定的Bean
    @param beanName bean 的名称
     @param clazz Class对象
     @return T
    */
    public static <T> T getBean(String beanName, Class<T> clazz){
        return getSpringApplicationContext().getBean(beanName, clazz);
    }
}
