package com.zy.gis.service;

import com.zy.gis.pojo.devAndFacility.DevInfo;

import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/9 10:01
 */
public interface DevInfoService {

    int insertDev(DevInfo devInfo);

    List<DevInfo> getAllDevInfo(DevInfo devInfo);

    int getAllDevInfoCount(DevInfo devInfo);

    int delDev(DevInfo devInfo);

    int updateDev(DevInfo devInfo);
}
