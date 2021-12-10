package com.zy.gis.controller.management;

import com.zy.gis.pojo.EasyUITreeInfo;
import com.zy.gis.service.QueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/15 15:00
 */
@Controller
public class QueryController {

    Logger logger = LoggerFactory.getLogger(QueryController.class);
    @Autowired
    QueryService queryService;

    /**
     * @Description:进入综合查询页面
     * @author hhp
     * @date 2021/9/15 15:01
     * @return {@link String}
     */
    @RequestMapping("queryPage")
    public String queryPage(){
        return "query/queryPage";
    }


    /**
     * @Description:获取管网系统组织树
     * @author hhp
     * @date 2021/9/24 10:35
     * @return {@link List< EasyUITreeInfo>}
     */
    @RequestMapping("getNetworkDevTree")
    @ResponseBody
    public List<EasyUITreeInfo> getNetworkDevTree(){
        List<EasyUITreeInfo> easyUITreeInfoList = queryService.getNetworkDevTree();
        return easyUITreeInfoList;
    }

    /**
     * @Description:获取管网设备组织树
     * @author hhp
     * @date 2021/9/24 10:35
     * @return {@link List< EasyUITreeInfo>}
     */
    @RequestMapping("getNetworkSystemTree")
    @ResponseBody
    public List<EasyUITreeInfo> getNetworkSystemTree(){
        List<EasyUITreeInfo> easyUITreeInfoList = queryService.getNetworkSystemTree();
        return easyUITreeInfoList;
    }
}
