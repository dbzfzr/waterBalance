package com.zy.gis.pojo;

import java.io.Serializable;

public class AlarmRule implements Serializable {
    /**
     * 记录id
     */
    private Integer id;

    /**
     * 工控系统类型
     */
    private String controlSystemType;

    /**
     * 设备类型
     */
    private String deviceType;

    /**
     * 报警类型
     */
    private String alarmType;

    /**
     * 报警参数
     */
    private String alarmParameter;

    /**
     * 报警上限
     */
    private String alarmSuperiorLimit;

    /**
     * 报警下限
     */
    private String alarmLowerLimit;

    /**
     * 状态
     */
    private String enable;

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
     * 设备类型
     * @return device_type 设备类型
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * 设备类型
     * @param deviceType 设备类型
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
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
     * 报警参数
     * @return alarm_parameter 报警参数
     */
    public String getAlarmParameter() {
        return alarmParameter;
    }

    /**
     * 报警参数
     * @param alarmParameter 报警参数
     */
    public void setAlarmParameter(String alarmParameter) {
        this.alarmParameter = alarmParameter == null ? null : alarmParameter.trim();
    }

    /**
     * 报警上限
     * @return alarm_superior_limit 报警上限
     */
    public String getAlarmSuperiorLimit() {
        return alarmSuperiorLimit;
    }

    /**
     * 报警上限
     * @param alarmSuperiorLimit 报警上限
     */
    public void setAlarmSuperiorLimit(String alarmSuperiorLimit) {
        this.alarmSuperiorLimit = alarmSuperiorLimit == null ? null : alarmSuperiorLimit.trim();
    }

    /**
     * 报警下限
     * @return alarm_lower_limit 报警下限
     */
    public String getAlarmLowerLimit() {
        return alarmLowerLimit;
    }

    /**
     * 报警下限
     * @param alarmLowerLimit 报警下限
     */
    public void setAlarmLowerLimit(String alarmLowerLimit) {
        this.alarmLowerLimit = alarmLowerLimit == null ? null : alarmLowerLimit.trim();
    }

    /**
     * 状态
     * @return enable 状态
     */
    public String getEnable() {
        return enable;
    }

    /**
     * 状态
     * @param enable 状态
     */
    public void setEnable(String enable) {
        this.enable = enable == null ? null : enable.trim();
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

    public String getControlSystemType() {
        return controlSystemType;
    }

    public void setControlSystemType(String controlSystemType) {
        this.controlSystemType = controlSystemType;
    }

    @Override
    public String toString() {
        return "AlarmRule{" +
                "id=" + id +
                ", controlSystemType='" + controlSystemType + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", alarmType='" + alarmType + '\'' +
                ", alarmParameter='" + alarmParameter + '\'' +
                ", alarmSuperiorLimit='" + alarmSuperiorLimit + '\'' +
                ", alarmLowerLimit='" + alarmLowerLimit + '\'' +
                ", enable='" + enable + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}