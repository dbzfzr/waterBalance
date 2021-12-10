package com.zy.gis.orm.vo;

import com.zy.gis.pojo.devAndFacility.NetworkPointInfo;

/**
@author Wangchong
@date 2021/11/13 17:11
@description TODO 存储有相应点位报警id的点位信息实体类
*/
public class NetworkPointWithAlarmId  extends NetworkPointInfo {
    private Integer alarmRecordId;

    /**
     * 繁易屏设备编号
     */
    private String boxNo;

    /**
     * 繁易屏设备别名
     */
    private String boxAlias;

    public Integer getAlarmRecordId() {
        return alarmRecordId;
    }

    public void setAlarmRecordId(Integer alarmRecordId) {
        this.alarmRecordId = alarmRecordId;
    }

    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }

    public String getBoxAlias() {
        return boxAlias;
    }

    public void setBoxAlias(String boxAlias) {
        this.boxAlias = boxAlias;
    }
}
