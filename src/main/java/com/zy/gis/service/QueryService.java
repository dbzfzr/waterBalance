package com.zy.gis.service;

import com.zy.gis.pojo.EasyUITreeInfo;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/23 16:16
 */
public interface QueryService {

    List<EasyUITreeInfo> getNetworkSystemTree();

    List<EasyUITreeInfo> getNetworkDevTree();


}
