package com.zy.gis.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 项目配置信息
 * @author Wangchong
 * @date 202108251007
 */
public class ConfigUtil {

    /**
     * 项目名称
     */
    public static String projectName;
    public static  String yuwufenliuName;
    public static  String youshuifenliName;
    /**
     * 配置文件路径
     */
    private static final String CONFIG_XML_PATH = System.getProperty("user.dir").replace("\\", "/") + "/conf/config.xml";

    static{
       projectName = MyXMLUtil.getConfigXMLValue(CONFIG_XML_PATH, "projectName");
       if (StringUtils.isEmpty(projectName)){
           projectName = "滨江区水平衡管理系统";
       }
    }

    static{
        yuwufenliuName = MyXMLUtil.getConfigXMLValue(CONFIG_XML_PATH, "yuwufenliuName");
        if (StringUtils.isEmpty(yuwufenliuName)){
            yuwufenliuName = "滨江区水平衡管理系统";
        }
    }



    static{
        youshuifenliName = MyXMLUtil.getConfigXMLValue(CONFIG_XML_PATH, "youshuifenliName");
        if (StringUtils.isEmpty(youshuifenliName)){
            youshuifenliName = "滨江区水平衡管理系统";
        }
    }

    /**
     @author Wangchong
     @date 2021/10/18 10:03
     @description TODO 获取gis 模型数据的地址
     @param
     @return
     */
    public static String getGisModelHost(){

        String gisModelHost = MyXMLUtil.getConfigXMLValue(CONFIG_XML_PATH, "gisModelHost");

        if (StringUtils.isEmpty(gisModelHost)) {
            gisModelHost = "http://112.124.16.160:9000";
        }
        return gisModelHost;
    }

    public static String getConfigXmlPath(){
        return CONFIG_XML_PATH;
    }
}
