package com.zy.gis.pojo.flexem;

import java.io.Serializable;

/**
@author Wangchong
@date 2021/11/8 10:08
@description TODO 泵站传上来的数据
*/
public class PumpStationFlexData implements Serializable {
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
     * 泵池液位 单位 m
     */
    private String pumpSumpLevel;

    /**
     * 出水池液位
     */
    private String outletTankLiquidLevel;

    /**
     * 出水瞬时流量 m3/h
     */
    private String effluentFlow;

    /**
     * 累计流量 m3
     */
    private String cumulativeFlow;

    /**
     * 阀门延迟开启时间 min
     */
    private String valveDelayOpenTime;

    /**
     * 阀门数量 个
     */
    private Integer valveNumbers;

    /**
     * 阀门状态 "0"关闭 "1"开启
     */
    private String valveState;

    /**
     * 水泵数量
     */
    private Integer pumpNumbers;

    /**
     * 水泵状态 "0"关闭 "1"开启
     */
    private String pumpState;

    /**
     * "manual"手动 "auto"自动
     */
    private String pattern;

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
     * 泵池液位 单位 m
     * @return pump_sump_level 泵池液位 单位 m
     */
    public String getPumpSumpLevel() {
        return pumpSumpLevel;
    }

    /**
     * 泵池液位 单位 m
     * @param pumpSumpLevel 泵池液位 单位 m
     */
    public void setPumpSumpLevel(String pumpSumpLevel) {
        this.pumpSumpLevel = pumpSumpLevel == null ? null : pumpSumpLevel.trim();
    }

    /**
     * 出水池液位
     * @return outlet_tank_liquid_level 出水池液位
     */
    public String getOutletTankLiquidLevel() {
        return outletTankLiquidLevel;
    }

    /**
     * 出水池液位
     * @param outletTankLiquidLevel 出水池液位
     */
    public void setOutletTankLiquidLevel(String outletTankLiquidLevel) {
        this.outletTankLiquidLevel = outletTankLiquidLevel == null ? null : outletTankLiquidLevel.trim();
    }

    /**
     * 出水瞬时流量 m3/h
     * @return effluent_flow 出水瞬时流量 m3/h
     */
    public String getEffluentFlow() {
        return effluentFlow;
    }

    /**
     * 出水瞬时流量 m3/h
     * @param effluentFlow 出水瞬时流量 m3/h
     */
    public void setEffluentFlow(String effluentFlow) {
        this.effluentFlow = effluentFlow == null ? null : effluentFlow.trim();
    }

    /**
     * 累计流量 m3
     * @return cumulative_flow 累计流量 m3
     */
    public String getCumulativeFlow() {
        return cumulativeFlow;
    }

    /**
     * 累计流量 m3
     * @param cumulativeFlow 累计流量 m3
     */
    public void setCumulativeFlow(String cumulativeFlow) {
        this.cumulativeFlow = cumulativeFlow == null ? null : cumulativeFlow.trim();
    }

    /**
     * 阀门延迟开启时间 min
     * @return valve_delay_open_time 阀门延迟开启时间 min
     */
    public String getValveDelayOpenTime() {
        return valveDelayOpenTime;
    }

    /**
     * 阀门延迟开启时间 min
     * @param valveDelayOpenTime 阀门延迟开启时间 min
     */
    public void setValveDelayOpenTime(String valveDelayOpenTime) {
        this.valveDelayOpenTime = valveDelayOpenTime == null ? null : valveDelayOpenTime.trim();
    }

    /**
     * 阀门数量 个
     * @return valve_numbers 阀门数量 个
     */
    public Integer getValveNumbers() {
        return valveNumbers;
    }

    /**
     * 阀门数量 个
     * @param valveNumbers 阀门数量 个
     */
    public void setValveNumbers(Integer valveNumbers) {
        this.valveNumbers = valveNumbers;
    }

    /**
     * 阀门状态 "0"关闭 "1"开启
     * @return valve_state 阀门状态 "0"关闭 "1"开启
     */
    public String getValveState() {
        return valveState;
    }

    /**
     * 阀门状态 "0"关闭 "1"开启
     * @param valveState 阀门状态 "0"关闭 "1"开启
     */
    public void setValveState(String valveState) {
        this.valveState = valveState == null ? null : valveState.trim();
    }

    /**
     * 水泵数量
     * @return pump_numbers 水泵数量
     */
    public Integer getPumpNumbers() {
        return pumpNumbers;
    }

    /**
     * 水泵数量
     * @param pumpNumbers 水泵数量
     */
    public void setPumpNumbers(Integer pumpNumbers) {
        this.pumpNumbers = pumpNumbers;
    }

    /**
     * 水泵状态 "0"关闭 "1"开启
     * @return pump_state 水泵状态 "0"关闭 "1"开启
     */
    public String getPumpState() {
        return pumpState;
    }

    /**
     * 水泵状态 "0"关闭 "1"开启
     * @param pumpState 水泵状态 "0"关闭 "1"开启
     */
    public void setPumpState(String pumpState) {
        this.pumpState = pumpState == null ? null : pumpState.trim();
    }

    /**
     * "manual"手动 "auto"自动
     * @return pattern "manual"手动 "auto"自动
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * "manual"手动 "auto"自动
     * @param pattern "manual"手动 "auto"自动
     */
    public void setPattern(String pattern) {
        this.pattern = pattern == null ? null : pattern.trim();
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
}