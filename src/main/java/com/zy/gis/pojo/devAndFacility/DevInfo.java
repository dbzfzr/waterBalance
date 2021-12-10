package com.zy.gis.pojo.devAndFacility;

import com.zy.gis.pojo.BaseQueryEntity;
import lombok.Data;

/**
 * TODO设备信息共用参数
 *
 * @author hhp
 * @date 2021/9/9 9:39
 */
@Data
public class DevInfo extends BaseQueryEntity implements Comparable<DevInfo> {

    private Integer id;

    private String devType;

    private String devSN;

    private String devModel;

    private String devFactory;

    private String devState;

    private String facilityNo;

    private String boxNo;
    private  String boxAlias;

    private String createTime;

    private String updateTime;

    private String longitude;

    private String latitude;

    private String address;

    private String facilityType;

    private String networkType;

    public int compareTo(DevInfo devInfo) {
        return this.getCreateTime().compareTo(devInfo.getCreateTime());
    }
}
