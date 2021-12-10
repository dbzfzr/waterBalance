package com.zy.gis.orm.qo;

import com.zy.gis.pojo.BaseQueryEntity;

/**
@author Wangchong
@date 2021/12/3 15:52
@description TODO 设备维修记录查询参数封装类
*/
public class DeviceRepairRecordQueryParameter extends BaseQueryEntity {
    /**
     * 记录id
     */
    private Integer id;

    /**
     * 人员id
     */
    private Integer userId;

    /**
     * 区划代码
     */
    private String organizationCode;

    /**
     * 区划名称
     */
    private String organizationName;

    /**
     * 点位的设备编号
     */
    private String boxNo;

    private String alarmRecordId;

    /**
     * 点位编号
     */
    private String pointNo;

    /**
     * 起始时间
     */
    private String queryStartTime;

    /**
     * 结束时间
     */
    private String queryEndTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }

    public String getPointNo() {
        return pointNo;
    }

    public void setPointNo(String pointNo) {
        this.pointNo = pointNo;
    }

    public String getQueryStartTime() {
        return queryStartTime;
    }

    public void setQueryStartTime(String queryStartTime) {
        this.queryStartTime = queryStartTime;
    }

    public String getQueryEndTime() {
        return queryEndTime;
    }

    public void setQueryEndTime(String queryEndTime) {
        this.queryEndTime = queryEndTime;
    }

    public String getAlarmRecordId() {
        return alarmRecordId;
    }

    public void setAlarmRecordId(String alarmRecordId) {
        this.alarmRecordId = alarmRecordId;
    }

    @Override
    public String toString() {
        return "DeviceRepairRecordQueryParameter{" +
                "id=" + id +
                ", userId=" + userId +
                ", organizationCode='" + organizationCode + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", boxNo='" + boxNo + '\'' +
                ", pointNo='" + pointNo + '\'' +
                ", queryStartTime='" + queryStartTime + '\'' +
                ", queryEndTime='" + queryEndTime + '\'' +
                '}';
    }
}
