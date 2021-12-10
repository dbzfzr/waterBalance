package com.zy.gis.pojo;

import java.io.Serializable;

/**
@author Wangchong
@date 2021/11/30 18:39
@description TODO 报警派单规则信息封装实体类
*/
public class AlarmDispatchRule implements Serializable {
    /**
     * 记录id
     */
    private Integer id;

    /**
     * 区域代码
     */
    private Integer organizationCode;

    /**
     * 报警类型
     */
    private String alarmType;

    /**
     * 派发的人员id
     */
    private Integer dispatchToUserId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 手机号码
     */
    private String phone;

    private String address;

    private String roleName;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

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
     * 区域代码
     * @return organization_code 区域代码
     */
    public Integer getOrganizationCode() {
        return organizationCode;
    }

    /**
     * 区域代码
     * @param organizationCode 区域代码
     */
    public void setOrganizationCode(Integer organizationCode) {
        this.organizationCode = organizationCode;
    }

    /**
     * 报警类型
     * @return alarm_type 报警类型
     */
    public String getAlarmType() {
        return alarmType;
    }

    /**
     * 报警类型
     * @param alarmType 报警类型
     */
    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType == null ? null : alarmType.trim();
    }

    /**
     * 派发的人员id
     * @return dispatch_to_user_id 派发的人员id
     */
    public Integer getDispatchToUserId() {
        return dispatchToUserId;
    }

    /**
     * 派发的人员id
     * @param dispatchToUserId 派发的人员id
     */
    public void setDispatchToUserId(Integer dispatchToUserId) {
        this.dispatchToUserId = dispatchToUserId;
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
     * 更新时间
     * @return update_time 更新时间
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "AlarmDispatchRule{" +
                "id=" + id +
                ", organizationCode=" + organizationCode +
                ", alarmType='" + alarmType + '\'' +
                ", dispatchToUserId=" + dispatchToUserId +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", roleName='" + roleName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}