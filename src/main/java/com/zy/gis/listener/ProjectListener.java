package com.zy.gis.listener;

import com.zy.gis.flexem.mqtt.flex.FlexDeviceMqttHandler;
import com.zy.gis.pojo.flexem.FlexState;
import com.zy.gis.service.DevControlPanelService;
import com.zy.gis.service.FlexStateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
@author Wangchong
@date 2021/9/18 10:07
@description TODO 项目启动监听
*/
@WebListener
public class ProjectListener implements ServletContextListener {

    private static Logger logger = LoggerFactory.getLogger(ProjectListener.class);

    private FlexDeviceMqttHandler flexDeviceMqttHandler = FlexDeviceMqttHandler.getInstance();

    @Autowired
    private DevControlPanelService devControlPanelService;

    @Autowired
    private FlexStateService flexStateService;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, servletContextEvent.getServletContext());

        inspectFlexDevState();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("项目关闭......");

        flexDeviceMqttHandler.closeEmqConnection();
    }

    /**
    @author Wangchong
    @date 2021/10/30 14:33
    @description TODO 项目启动成功后，检查繁易屏设备状态记录是否存在
    */
    public void inspectFlexDevState(){
        List<String> boxNoList = devControlPanelService.selectAllBoxNo();
        Integer flexStateCount;
        FlexState flexState = new FlexState();

        for (String boxNo: boxNoList){
            flexStateCount = flexStateService.selectFlexStateCountByBoxNo(boxNo);
            if (flexStateCount == 0){
                flexState.setBoxNo(boxNo);
                flexStateService.insertSelective(flexState);
            }
        }
    }
}
