package com.zy.gis.pojo;

import java.io.Serializable;

public class DeviceRepairRecord implements Serializable {
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
     * 暂时没用到,用于多运维人员的情况
     */
    private String userArrayStr;

    /**
     * 点位的设备编号
     */
    private String boxNo;

    /**
     * 以设备别名标识维护记录的点位
     */
    private String boxAlias;

    /**
     * 点位编号
     */
    private String pointNo;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 报警记录id
     */
    private String alarmRecordId;

    /**
     * 记录id
     * @return id 记录id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 记录id
     * @param id 记录id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 人员id
     * @return user_id 人员id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 人员id
     * @param userId 人员id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 区划代码
     * @return organization_code 区划代码
     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * 区划代码
     * @param organizationCode 区划代码
     */
    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode == null ? null : organizationCode.trim();
    }

    /**
     * 区划名称
     * @return organization_name 区划名称
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * 区划名称
     * @param organizationName 区划名称
     */
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName == null ? null : organizationName.trim();
    }

    /**
     * 暂时没用到,用于多运维人员的情况
     * @return user_array_str 暂时没用到,用于多运维人员的情况
     */
    public String getUserArrayStr() {
        return userArrayStr;
    }

    /**
     * 暂时没用到,用于多运维人员的情况
     * @param userArrayStr 暂时没用到,用于多运维人员的情况
     */
    public void setUserArrayStr(String userArrayStr) {
        this.userArrayStr = userArrayStr == null ? null : userArrayStr.trim();
    }

    /**
     * 点位的设备编号
     * @return box_no 点位的设备编号
     */
    public String getBoxNo() {
        return boxNo;
    }

    /**
     * 点位的设备编号
     * @param boxNo 点位的设备编号
     */
    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo == null ? null : boxNo.trim();
    }

    /**
     * 点位编号
     * @return point_no 点位编号
     */
    public String getPointNo() {
        return pointNo;
    }

    /**
     * 点位编号
     * @param pointNo 点位编号
     */
    public void setPointNo(String pointNo) {
        this.pointNo = pointNo == null ? null : pointNo.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * 报警记录id
     * @return alarm_record_id 报警记录id
     */
    public String getAlarmRecordId() {
        return alarmRecordId;
    }

    /**
     * 报警记录id
     * @param alarmRecordId 报警记录id
     */
    public void setAlarmRecordId(String alarmRecordId) {
        this.alarmRecordId = alarmRecordId == null ? null : alarmRecordId.trim();
    }

    public String getBoxAlias() {
        return boxAlias;
    }

    public void setBoxAlias(String boxAlias) {
        this.boxAlias = boxAlias;
    }
}