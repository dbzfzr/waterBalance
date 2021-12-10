package com.zy.gis.pojo.flexem;

import java.io.Serializable;

/**
@author Wangchong
@date 2021/10/30 10:37
@description TODO 繁易屏设备状态信息实体类
*/
public class FlexState implements Serializable {
    /**
     * 记录id
     */
    private Integer id;

    /**
     * 繁易屏编号
     */
    private String boxNo;

    /**
     * 报警状态 alarm报警 noAlarm 正常未报警
     */
    private String alarmState;

    /**
     * 0表示离线 1表示在线  2表示正在拨号  3表示正在登录服务器 4表示正在连接通信服务器
     */
    private Integer flexemConnectSta;

    /**
     * 盒子无线信号强度(0到8)
     */
    private Integer flexemWireless;

    /**
     * 盒子联网类型 1:以太网 2:2G 4:wifi 5:4G
     */
    private Integer flexemNetType;

    /**
     * 盒子在线状态 0离线 1在线
     */
    private Integer flexemOnlineSta;

    /**
     * 盒子密码
     */
    private String flexemPassword;

    /**
     * 盒子序列号
     */
    private String flexemSn;

    /**
     * 盒子mqtt版本
     */
    private Integer flexemMqttVer;

    /**
     * 该数据段表示是否暂停当前 FBOX 想 MQTT 服务器的数据推送
     */
    private Integer flexemPause;

    /**
     * 表示数据发送类型（支持，周期推送和变 化推送）
     */
    private String flexemPushMode;

    /**
     * 该数据段表示需要设置监控点数据的发布 周期
     */
    private Integer flexemPushInterval;

    /**
     * GPS 信息-纬度信息
     */
    private String flexemLatitude;

    /**
     * GPS 信息-经度信息
     */
    private String flexemLongitude;

    /**
     * 基站-基站编号
     */
    private String flexemSimCcid;

    /**
     * 基站-移动网络号码
     */
    private String flexemSimMnc;

    /**
     * 基站-移动国家代码
     */
    private String flexemSimMcc;

    /**
     * 基站编号
     */
    private String flexemSimCel;

    /**
     * 基站-位置区域码（也叫，小区号）
     */
    private String flexemSimLac;

    /**
     * SIM卡套餐流量
     */
    private String flexemSimTotalData;

    /**
     * SIM卡剩余流量
     */
    private String flexemSimRemainData;

    /**
     *水质仪状态 1正常 0故障
     */
    private String waterQualityMeterState;

    /**
     *液位计状态 1正常 0故障
     */
    private String liquidLevelMeterState;

    /**
     *流量计状态 1正常 0故障
     */
    private String flowMeterState;

    /**
     *抽水泵状态 1正常 0故障
     */
    private String waterPumpState;

    /**
     *雨量计状态 1正常 0故障
     */
    private String rainGaugeState;

    /**
     *阀门状态 1开启 0关闭 2故障
     */
    private String valveState;

    /**
     * 时间
     */
    private String flexemTimeStamp;

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
     * 繁易屏编号
     * @return box_no 繁易屏编号
     */
    public String getBoxNo() {
        return boxNo;
    }

    /**
     * 繁易屏编号
     * @param boxNo 繁易屏编号
     */
    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo == null ? null : boxNo.trim();
    }

    /**
     * 报警状态 alarm报警 noAlarm 正常未报警
     * @return alarm_state 报警状态 alarm报警 noAlarm 正常未报警
     */
    public String getAlarmState() {
        return alarmState;
    }

    /**
     * 报警状态 alarm报警 noAlarm 正常未报警
     * @param alarmState 报警状态 alarm报警 noAlarm 正常未报警
     */
    public void setAlarmState(String alarmState) {
        this.alarmState = alarmState == null ? null : alarmState.trim();
    }

    /**
     * 网络连接状态 0已连接 1未连接
     * @return flexem_connect_sta 网络连接状态 0已连接 1未连接
     */
    public Integer getFlexemConnectSta() {
        return flexemConnectSta;
    }

    /**
     * 网络连接状态 0已连接 1未连接
     * @param flexemConnectSta 网络连接状态 0已连接 1未连接
     */
    public void setFlexemConnectSta(Integer flexemConnectSta) {
        this.flexemConnectSta = flexemConnectSta;
    }

    /**
     * 盒子无线信号强度
     * @return flexem_wireless 盒子无线信号强度
     */
    public Integer getFlexemWireless() {
        return flexemWireless;
    }

    /**
     * 盒子无线信号强度
     * @param flexemWireless 盒子无线信号强度
     */
    public void setFlexemWireless(Integer flexemWireless) {
        this.flexemWireless = flexemWireless;
    }

    /**
     * 盒子联网类型
     * @return flexem_net_type 盒子联网类型
     */
    public Integer getFlexemNetType() {
        return flexemNetType;
    }

    /**
     * 盒子联网类型
     * @param flexemNetType 盒子联网类型
     */
    public void setFlexemNetType(Integer flexemNetType) {
        this.flexemNetType = flexemNetType;
    }

    /**
     * 盒子在线状态 0离线 1在线
     * @return flexem_online_sta 盒子在线状态 0离线 1在线
     */
    public Integer getFlexemOnlineSta() {
        return flexemOnlineSta;
    }

    /**
     * 盒子在线状态 0离线 1在线
     * @param flexemOnlineSta 盒子在线状态 0离线 1在线
     */
    public void setFlexemOnlineSta(Integer flexemOnlineSta) {
        this.flexemOnlineSta = flexemOnlineSta;
    }

    /**
     * 盒子密码
     * @return flexem_password 盒子密码
     */
    public String getFlexemPassword() {
        return flexemPassword;
    }

    /**
     * 盒子密码
     * @param flexemPassword 盒子密码
     */
    public void setFlexemPassword(String flexemPassword) {
        this.flexemPassword = flexemPassword == null ? null : flexemPassword.trim();
    }

    /**
     * 盒子序列号
     * @return flexem_sn 盒子序列号
     */
    public String getFlexemSn() {
        return flexemSn;
    }

    /**
     * 盒子序列号
     * @param flexemSn 盒子序列号
     */
    public void setFlexemSn(String flexemSn) {
        this.flexemSn = flexemSn == null ? null : flexemSn.trim();
    }

    /**
     * 盒子mqtt版本
     * @return flexem_mqtt_ver 盒子mqtt版本
     */
    public Integer getFlexemMqttVer() {
        return flexemMqttVer;
    }

    /**
     * 盒子mqtt版本
     * @param flexemMqttVer 盒子mqtt版本
     */
    public void setFlexemMqttVer(Integer flexemMqttVer) {
        this.flexemMqttVer = flexemMqttVer;
    }

    /**
     * 该数据段表示是否暂停当前 FBOX 想 MQTT 服务器的数据推送
     * @return flexem_pause 该数据段表示是否暂停当前 FBOX 想 MQTT 服务器的数据推送
     */
    public Integer getFlexemPause() {
        return flexemPause;
    }

    /**
     * 该数据段表示是否暂停当前 FBOX 想 MQTT 服务器的数据推送
     * @param flexemPause 该数据段表示是否暂停当前 FBOX 想 MQTT 服务器的数据推送
     */
    public void setFlexemPause(Integer flexemPause) {
        this.flexemPause = flexemPause;
    }

    /**
     * 表示数据发送类型（支持，周期推送和变 化推送）
     * @return flexem_push_mode 表示数据发送类型（支持，周期推送和变 化推送）
     */
    public String getFlexemPushMode() {
        return flexemPushMode;
    }

    /**
     * 表示数据发送类型（支持，周期推送和变 化推送）
     * @param flexemPushMode 表示数据发送类型（支持，周期推送和变 化推送）
     */
    public void setFlexemPushMode(String flexemPushMode) {
        this.flexemPushMode = flexemPushMode == null ? null : flexemPushMode.trim();
    }

    /**
     * 该数据段表示需要设置监控点数据的发布 周期
     * @return flexem_push_interval 该数据段表示需要设置监控点数据的发布 周期
     */
    public Integer getFlexemPushInterval() {
        return flexemPushInterval;
    }

    /**
     * 该数据段表示需要设置监控点数据的发布 周期
     * @param flexemPushInterval 该数据段表示需要设置监控点数据的发布 周期
     */
    public void setFlexemPushInterval(Integer flexemPushInterval) {
        this.flexemPushInterval = flexemPushInterval;
    }

    /**
     * GPS 信息-纬度信息
     * @return flexem_latitude GPS 信息-纬度信息
     */
    public String getFlexemLatitude() {
        return flexemLatitude;
    }

    /**
     * GPS 信息-纬度信息
     * @param flexemLatitude GPS 信息-纬度信息
     */
    public void setFlexemLatitude(String flexemLatitude) {
        this.flexemLatitude = flexemLatitude == null ? null : flexemLatitude.trim();
    }

    /**
     * GPS 信息-经度信息
     * @return flexem_longitude GPS 信息-经度信息
     */
    public String getFlexemLongitude() {
        return flexemLongitude;
    }

    /**
     * GPS 信息-经度信息
     * @param flexemLongitude GPS 信息-经度信息
     */
    public void setFlexemLongitude(String flexemLongitude) {
        this.flexemLongitude = flexemLongitude == null ? null : flexemLongitude.trim();
    }

    /**
     * 基站-基站编号
     * @return flexem_sim_ccid 基站-基站编号
     */
    public String getFlexemSimCcid() {
        return flexemSimCcid;
    }

    /**
     * 基站-基站编号
     * @param flexemSimCcid 基站-基站编号
     */
    public void setFlexemSimCcid(String flexemSimCcid) {
        this.flexemSimCcid = flexemSimCcid == null ? null : flexemSimCcid.trim();
    }

    /**
     * 基站-移动网络号码
     * @return flexem_sim_mnc 基站-移动网络号码
     */
    public String getFlexemSimMnc() {
        return flexemSimMnc;
    }

    /**
     * 基站-移动网络号码
     * @param flexemSimMnc 基站-移动网络号码
     */
    public void setFlexemSimMnc(String flexemSimMnc) {
        this.flexemSimMnc = flexemSimMnc == null ? null : flexemSimMnc.trim();
    }

    /**
     * 基站-移动国家代码
     * @return flexem_sim_mcc 基站-移动国家代码
     */
    public String getFlexemSimMcc() {
        return flexemSimMcc;
    }

    /**
     * 基站-移动国家代码
     * @param flexemSimMcc 基站-移动国家代码
     */
    public void setFlexemSimMcc(String flexemSimMcc) {
        this.flexemSimMcc = flexemSimMcc == null ? null : flexemSimMcc.trim();
    }

    /**
     * 基站编号
     * @return flexem_sim_cel 基站编号
     */
    public String getFlexemSimCel() {
        return flexemSimCel;
    }

    /**
     * 基站编号
     * @param flexemSimCel 基站编号
     */
    public void setFlexemSimCel(String flexemSimCel) {
        this.flexemSimCel = flexemSimCel == null ? null : flexemSimCel.trim();
    }

    /**
     * 基站-位置区域码（也叫，小区号）
     * @return flexem_sim_lac 基站-位置区域码（也叫，小区号）
     */
    public String getFlexemSimLac() {
        return flexemSimLac;
    }

    /**
     * 基站-位置区域码（也叫，小区号）
     * @param flexemSimLac 基站-位置区域码（也叫，小区号）
     */
    public void setFlexemSimLac(String flexemSimLac) {
        this.flexemSimLac = flexemSimLac == null ? null : flexemSimLac.trim();
    }

    /**
     * SIM卡套餐流量
     * @return flexem_sim_total_data SIM卡套餐流量
     */
    public String getFlexemSimTotalData() {
        return flexemSimTotalData;
    }

    /**
     * SIM卡套餐流量
     * @param flexemSimTotalData SIM卡套餐流量
     */
    public void setFlexemSimTotalData(String flexemSimTotalData) {
        this.flexemSimTotalData = flexemSimTotalData == null ? null : flexemSimTotalData.trim();
    }

    /**
     * SIM卡剩余流量
     * @return flexem_sim_remain_data SIM卡剩余流量
     */
    public String getFlexemSimRemainData() {
        return flexemSimRemainData;
    }

    /**
     * SIM卡剩余流量
     * @param flexemSimRemainData SIM卡剩余流量
     */
    public void setFlexemSimRemainData(String flexemSimRemainData) {
        this.flexemSimRemainData = flexemSimRemainData == null ? null : flexemSimRemainData.trim();
    }

    /**
     * 时间
     * @return flexem_time_stamp 时间
     */
    public String getFlexemTimeStamp() {
        return flexemTimeStamp;
    }

    /**
     * 时间
     * @param flexemTimeStamp 时间
     */
    public void setFlexemTimeStamp(String flexemTimeStamp) {
        this.flexemTimeStamp = flexemTimeStamp == null ? null : flexemTimeStamp.trim();
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

    public String getWaterQualityMeterState() {
        return waterQualityMeterState;
    }

    public void setWaterQualityMeterState(String waterQualityMeterState) {
        this.waterQualityMeterState = waterQualityMeterState;
    }

    public String getLiquidLevelMeterState() {
        return liquidLevelMeterState;
    }

    public void setLiquidLevelMeterState(String liquidLevelMeterState) {
        this.liquidLevelMeterState = liquidLevelMeterState;
    }

    public String getFlowMeterState() {
        return flowMeterState;
    }

    public void setFlowMeterState(String flowMeterState) {
        this.flowMeterState = flowMeterState;
    }

    public String getWaterPumpState() {
        return waterPumpState;
    }

    public void setWaterPumpState(String waterPumpState) {
        this.waterPumpState = waterPumpState;
    }

    public String getRainGaugeState() {
        return rainGaugeState;
    }

    public void setRainGaugeState(String rainGaugeState) {
        this.rainGaugeState = rainGaugeState;
    }

    public String getValveState() {
        return valveState;
    }

    public void setValveState(String valveState) {
        this.valveState = valveState;
    }
}