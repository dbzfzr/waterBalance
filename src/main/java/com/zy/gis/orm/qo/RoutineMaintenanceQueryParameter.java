package com.zy.gis.orm.qo;

import com.zy.gis.pojo.BaseQueryEntity;

/**
@author Wangchong
@date 2021/12/2 14:57
@description TODO 日常维护记录查询参数封装类
*/
public class RoutineMaintenanceQueryParameter extends BaseQueryEntity {
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

    @Override
    public String toString() {
        return  super.toString() + "RoutineMaintenanceQueryParameter{" +
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
