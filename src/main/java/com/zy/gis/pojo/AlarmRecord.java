package com.zy.gis.pojo;

import java.io.Serializable;

/**
@author Wangchong
@date 2021/10/23 11:57
@description 报警信息实体类
*/
public class AlarmRecord implements Serializable {
    /**
     * 记录id
     */
    private Integer id;

    /**
     * 联动预警事件id，由于其他的预警事件导致此预警事件发生
     */
    private Integer linkAlarmId;

    /**
     * 报警类型
     */
    private String alarmType;

    /**
     * 报警级别
     */
    private String alarmLevel;

    /**
     * 报警站点
     */
    private String alarmStation;

    /**
     * 报警描述
     */
    private String alarmDescription;

    /**
     * 报警系统设备编号(繁易工控屏设备编号)
     */
    private String alarmDevCode;

    /**
     * 设备所属设施点位编号
     */
    private String devFacilityNo;

    /**
     * 报警数值
     */
    private String alarmValue;

    /**
     * 处置状态(未处理,处置中,已处理)
     */
    private String handleState;

    /**
     * 处理结果
     */
    private String handleResult;

    /**
     * 报警时间
     */
    private String alarmTime;

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
     * 报警级别
     * @return alarm_level 报警级别
     */
    public String getAlarmLevel() {
        return alarmLevel;
    }

    /**
     * 报警级别
     * @param alarmLevel 报警级别
     */
    public void setAlarmLevel(String alarmLevel) {
        this.alarmLevel = alarmLevel == null ? null : alarmLevel.trim();
    }

    /**
     * 报警系统设备编号(繁易工控屏设备编号)
     * @return alarm_dev_code 报警系统设备编号(繁易工控屏设备编号)
     */
    public String getAlarmDevCode() {
        return alarmDevCode;
    }

    /**
     * 报警系统设备编号(繁易工控屏设备编号)
     * @param alarmDevCode 报警系统设备编号(繁易工控屏设备编号)
     */
    public void setAlarmDevCode(String alarmDevCode) {
        this.alarmDevCode = alarmDevCode == null ? null : alarmDevCode.trim();
    }

    /**
     * 报警数值
     * @return alarm_value 报警数值
     */
    public String getAlarmValue() {
        return alarmValue;
    }

    /**
     * 报警数值
     * @param alarmValue 报警数值
     */
    public void setAlarmValue(String alarmValue) {
        this.alarmValue = alarmValue == null ? null : alarmValue.trim();
    }

    /**
     * 处置状态(未处理,处置中,已处理)
     * @return handle_state 处置状态(未处理,处置中,已处理)
     */
    public String getHandleState() {
        return handleState;
    }

    /**
     * 处置状态(未处理,处置中,已处理)
     * @param handleState 处置状态(未处理,处置中,已处理)
     */
    public void setHandleState(String handleState) {
        this.handleState = handleState == null ? null : handleState.trim();
    }

    /**
     * 报警时间
     * @return alarm_time 报警时间
     */
    public String getAlarmTime() {
        return alarmTime;
    }

    /**
     * 报警时间
     * @param alarmTime 报警时间
     */
    public void setAlarmTime(String alarmTime) {
        this.alarmTime = alarmTime == null ? null : alarmTime.trim();
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

    public String getDevFacilityNo() {
        return devFacilityNo;
    }

    public void setDevFacilityNo(String devFacilityNo) {
        this.devFacilityNo = devFacilityNo;
    }

    public String getAlarmStation() {
        return alarmStation;
    }

    public void setAlarmStation(String alarmStation) {
        this.alarmStation = alarmStation;
    }

    public String getAlarmDescription() {
        return alarmDescription;
    }

    public void setAlarmDescription(String alarmDescription) {
        this.alarmDescription = alarmDescription;
    }

    public Integer getLinkAlarmId() {
        return linkAlarmId;
    }

    public void setLinkAlarmId(Integer linkAlarmId) {
        this.linkAlarmId = linkAlarmId;
    }

    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult;
    }

    @Override
    public String toString() {
        return "AlarmRecord{" +
                "id=" + id +
                ", linkAlarmId=" + linkAlarmId +
                ", alarmType='" + alarmType + '\'' +
                ", alarmLevel='" + alarmLevel + '\'' +
                ", alarmStation='" + alarmStation + '\'' +
                ", alarmDescription='" + alarmDescription + '\'' +
                ", alarmDevCode='" + alarmDevCode + '\'' +
                ", devFacilityNo='" + devFacilityNo + '\'' +
                ", alarmValue='" + alarmValue + '\'' +
                ", handleState='" + handleState + '\'' +
                ", alarmTime='" + alarmTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}