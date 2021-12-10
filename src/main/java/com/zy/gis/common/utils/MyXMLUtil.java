package com.zy.gis.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.List;

public class MyXMLUtil {

    private static final Logger log = LoggerFactory.getLogger(MyXMLUtil.class);

    /**
     * 设置 config.xml 路径
     */
    //private static String configXMLPath = MyUtil.getRootPath()+"config.xml";

    /**
     * 获取xml 子节点的值  PS：限于根节点下的子节点
     * @xmlFilePath xml文件路径
     * @param strName
     * @return
     */
    public static String  getConfigXMLValue(String xmlFilePath, String strName){

        // 创建saxReader对象
        SAXReader reader = new SAXReader();
        // 通过read方法读取一个文件 转换成Document对象
        Document doc = null;
        try {
            //doc = reader.read(new File(strPath));
            doc = reader.read(new FileInputStream(xmlFilePath));
        } catch (Exception e) {
            log.error("获取xml值异常 "+e.toString());
        }
        // 获取根节点元素对象
        Element rootElement = doc.getRootElement();
        //获取 查找节点
        Element node = rootElement.element(strName);

        return  node.getText();
    }

    /**
     * 获取xml 子节点的值  可以获得多个 限于根节点下的子节点
     * @date 20210609
     * @author Wangchong
     * @xmlFilePath xml文件路径
     * @param nameStrList 节点name的list
     * @return 封装数据的JSONObject
     */
    public static JSONObject getConfigXMLValue(String xmlFilePath, List<String> nameStrList){

        // 创建saxReader对象
        SAXReader reader = new SAXReader();
        // 通过read方法读取一个文件 转换成Document对象
        Document doc = null;
        try {
            doc = reader.read(new FileInputStream(xmlFilePath));
        } catch (Exception e) {
            log.error("获取xml值异常 "+e.toString());
        }
        // 获取根节点元素对象
        Element rootElement = doc.getRootElement();

        JSONObject jsonObject = new JSONObject();
        for (String str : nameStrList) {
            Element node = rootElement.element(str);
            jsonObject.put(str, node.getTextTrim());
        }
        //获取 查找节点

        log.info("配置信息:{}", jsonObject.toJSONString());
        return  jsonObject;
    }

    /**
     * 根据节点名称修改该节点的值 PS：限于根节点下的子节点
     * @param strName
     * @param strValue
     * @throws DocumentException
     * @throws IOException
     */
//    public static void modifyConfigXml(String strName , String strValue) {
//
//        String strPath = configXMLPath;
//        // 创建saxReader对象
//        SAXReader reader = new SAXReader();
//        // 通过read方法读取一个文件 转换成Document对象
//        Document doc = null;
//        try {
//            doc = reader.read(new File(strPath));
//        } catch (DocumentException e) {
//            log.error("修改XML异常"+e.toString());
//        }
//
//        // 获取根节点元素对象
//        Element rootElement = doc.getRootElement();
//        //获取 节点
//        Element node = rootElement.element(strName);
//        //修改 节点值
//        node.setText(strValue);
//
//        //保存xml
//        OutputFormat format = OutputFormat.createPrettyPrint();
//        format.setEncoding("UTF-8");
//
//        XMLWriter xmlWriter = null;
//        try {
//            xmlWriter = new XMLWriter(new FileOutputStream(strPath),format);
//            xmlWriter.write(doc);
//            xmlWriter.close();
//        } catch (UnsupportedEncodingException e) {
//            log.error("修改XML异常"+e.toString());
//        } catch (FileNotFoundException e) {
//            log.error("修改XML异常"+e.toString());
//        } catch (IOException e) {
//            log.error("修改XML异常"+e.toString());
//        }
//    }


}
