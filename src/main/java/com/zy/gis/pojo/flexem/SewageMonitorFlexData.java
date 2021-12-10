package com.zy.gis.pojo.flexem;

import java.io.Serializable;

/**
@author Wangchong
@date 2021/11/9 17:19
@description TODO 污水监测点数据
*/
public class SewageMonitorFlexData implements Serializable {
    /**
     * 记录id
     */
    private Integer id;

    /**
     * 繁易屏设备编号
     */
    private String boxNo;

    /**
     * 水温
     */
    private String waterTemperature;

    /**
     * 氨氮 mg/L
     */
    private String ammoniaNitrogen;

    /**
     * 化学需氧量 mg/L
     */
    private String cod;

    /**
     * 电导率 S/m
     */
    private String conductivity;

    /**
     * 酸碱度
     */
    private String ph;

    /**
     * 固体悬浮物 mg/L
     */
    private String suspendedSolid;

    /**
     * 浊度 NTU
     */
    private String turbidity;

    /**
     * 液位 单位 m
     */
    private String liquidLevel;

    /**
     * 当前瞬时流量 m3/h
     */
    private String currentFlow;

    /**
    @author Wangchong
    @date 2021/11/25 9:54
    @description TODO 累计流量
     */
    private String cumulativeFlow;

    /**
     * 消息时间
     */
    private String flexemTimeStamp;

    /**
     * 消息id
     */
    private String flexemMessageId;

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
     * 繁易屏设备编号
     * @return box_no 繁易屏设备编号
     */
    public String getBoxNo() {
        return boxNo;
    }

    /**
     * 繁易屏设备编号
     * @param boxNo 繁易屏设备编号
     */
    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo == null ? null : boxNo.trim();
    }

    /**
     * 水温
     * @return water_temperature 水温
     */
    public String getWaterTemperature() {
        return waterTemperature;
    }

    /**
     * 水温
     * @param waterTemperature 水温
     */
    public void setWaterTemperature(String waterTemperature) {
        this.waterTemperature = waterTemperature == null ? null : waterTemperature.trim();
    }

    /**
     * 氨氮 mg/L
     * @return ammonia_nitrogen 氨氮 mg/L
     */
    public String getAmmoniaNitrogen() {
        return ammoniaNitrogen;
    }

    /**
     * 氨氮 mg/L
     * @param ammoniaNitrogen 氨氮 mg/L
     */
    public void setAmmoniaNitrogen(String ammoniaNitrogen) {
        this.ammoniaNitrogen = ammoniaNitrogen == null ? null : ammoniaNitrogen.trim();
    }

    /**
     * 化学需氧量 mg/L
     * @return cod 化学需氧量 mg/L
     */
    public String getCod() {
        return cod;
    }

    /**
     * 化学需氧量 mg/L
     * @param cod 化学需氧量 mg/L
     */
    public void setCod(String cod) {
        this.cod = cod == null ? null : cod.trim();
    }

    /**
     * 电导率 S/m
     * @return conductivity 电导率 S/m
     */
    public String getConductivity() {
        return conductivity;
    }

    /**
     * 电导率 S/m
     * @param conductivity 电导率 S/m
     */
    public void setConductivity(String conductivity) {
        this.conductivity = conductivity == null ? null : conductivity.trim();
    }

    /**
     * 酸碱度
     * @return ph 酸碱度
     */
    public String getPh() {
        return ph;
    }

    /**
     * 酸碱度
     * @param ph 酸碱度
     */
    public void setPh(String ph) {
        this.ph = ph == null ? null : ph.trim();
    }

    /**
     * 固体悬浮物 mg/L
     * @return suspended_solid 固体悬浮物 mg/L
     */
    public String getSuspendedSolid() {
        return suspendedSolid;
    }

    /**
     * 固体悬浮物 mg/L
     * @param suspendedSolid 固体悬浮物 mg/L
     */
    public void setSuspendedSolid(String suspendedSolid) {
        this.suspendedSolid = suspendedSolid == null ? null : suspendedSolid.trim();
    }

    /**
     * 浊度 NTU
     * @return turbidity 浊度 NTU
     */
    public String getTurbidity() {
        return turbidity;
    }

    /**
     * 浊度 NTU
     * @param turbidity 浊度 NTU
     */
    public void setTurbidity(String turbidity) {
        this.turbidity = turbidity == null ? null : turbidity.trim();
    }

    /**
     * 液位 单位 m
     * @return liquid_level 液位 单位 m
     */
    public String getLiquidLevel() {
        return liquidLevel;
    }

    /**
     * 液位 单位 m
     * @param liquidLevel 液位 单位 m
     */
    public void setLiquidLevel(String liquidLevel) {
        this.liquidLevel = liquidLevel == null ? null : liquidLevel.trim();
    }

    /**
     * 当前瞬时流量 m3/h
     * @return current_flow 当前瞬时流量 m3/h
     */
    public String getCurrentFlow() {
        return currentFlow;
    }

    /**
     * 当前瞬时流量 m3/h
     * @param currentFlow 当前瞬时流量 m3/h
     */
    public void setCurrentFlow(String currentFlow) {
        this.currentFlow = currentFlow == null ? null : currentFlow.trim();
    }

    /**
     * 消息时间
     * @return flexem_time_stamp 消息时间
     */
    public String getFlexemTimeStamp() {
        return flexemTimeStamp;
    }

    /**
     * 消息时间
     * @param flexemTimeStamp 消息时间
     */
    public void setFlexemTimeStamp(String flexemTimeStamp) {
        this.flexemTimeStamp = flexemTimeStamp == null ? null : flexemTimeStamp.trim();
    }

    /**
     * 消息id
     * @return flexem_message_id 消息id
     */
    public String getFlexemMessageId() {
        return flexemMessageId;
    }

    /**
     * 消息id
     * @param flexemMessageId 消息id
     */
    public void setFlexemMessageId(String flexemMessageId) {
        this.flexemMessageId = flexemMessageId == null ? null : flexemMessageId.trim();
    }

    public String getCumulativeFlow() {
        return cumulativeFlow;
    }

    public void setCumulativeFlow(String cumulativeFlow) {
        this.cumulativeFlow = cumulativeFlow;
    }
}