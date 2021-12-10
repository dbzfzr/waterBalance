package com.zy.gis.orm.vo;

import java.io.Serializable;

/**
@author Wangchong
@date 2021/11/1 10:16
@description TODO 有设备的点位的信息
*/

public class GisPointHaveFlexemInfo implements Serializable {

    private Integer id;

    /**
     * 繁易屏设备编号
     */
    private String boxNo;

    /**
     * 设备别名
     */
    private String boxAlias;

    /**
     *  报警状态 alarm报警 noAlarm 正常未报警
     */
    private String alarmState;

    private String pointName;

    private String pointNo;

    private String addressName;

    private String addressId;

    private String networkType;

    private String networkLevel;

    private String pointType;

    private String systemType;

    private String material;

    private String specs;

    private String longitude;


    private String latitude;


    private String topDepth;


    private String bottomDepth;


    private String completionDate;


    private String createTime;

    private String updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPointNo() {
        return pointNo;
    }

    public void setPointNo(String pointNo) {
        this.pointNo = pointNo;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public String getNetworkLevel() {
        return networkLevel;
    }

    public void setNetworkLevel(String networkLevel) {
        this.networkLevel = networkLevel;
    }

    public String getPointType() {
        return pointType;
    }

    public void setPointType(String pointType) {
        this.pointType = pointType;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getTopDepth() {
        return topDepth;
    }

    public void setTopDepth(String topDepth) {
        this.topDepth = topDepth;
    }

    public String getBottomDepth() {
        return bottomDepth;
    }

    public void setBottomDepth(String bottomDepth) {
        this.bottomDepth = bottomDepth;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }

    public String getAlarmState() {
        return alarmState;
    }

    public void setAlarmState(String alarmState) {
        this.alarmState = alarmState;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getBoxAlias() {
        return boxAlias;
    }

    public void setBoxAlias(String boxAlias) {
        this.boxAlias = boxAlias;
    }

    @Override
    public String toString() {
        return "GisPointHaveFlexemInfo{" +
                "id=" + id +
                ", boxNo='" + boxNo + '\'' +
                ", alarmState='" + alarmState + '\'' +
                ", pointNo='" + pointNo + '\'' +
                ", addressName='" + addressName + '\'' +
                ", addressId='" + addressId + '\'' +
                ", networkType='" + networkType + '\'' +
                ", networkLevel='" + networkLevel + '\'' +
                ", pointType='" + pointType + '\'' +
                ", systemType='" + systemType + '\'' +
                ", material='" + material + '\'' +
                ", specs='" + specs + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", topDepth='" + topDepth + '\'' +
                ", bottomDepth='" + bottomDepth + '\'' +
                ", completionDate='" + completionDate + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
