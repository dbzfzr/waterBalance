package com.zy.gis.pojo.waterbalance;

import java.io.Serializable;
/**
@author Wangchong
@date 2021/11/29 10:53
@description TODO 雨水平衡信息封装类
*/
public class RainBalance implements Serializable {
    /**
     * 记录id
     */
    private Integer id;

    /**
     * 雨水总量平衡
     */
    private String totalRainBalance;

    /**
     * A区域供雨水平衡
     */
    private String aAreaBalance;

    /**
     * B区域供雨水平衡
     */
    private String bAreaBalance;

    /**
     * C区域供雨水平衡
     */
    private String cAreaBalance;

    /**
     * D区域供雨水平衡
     */
    private String dAreaBalance;

    /**
     * E区域供雨水平衡
     */
    private String eAreaBalance;

    /**
     * F区域供雨水平衡
     */
    private String fAreaBalance;

    /**
     * G区域供雨水平衡
     */
    private String gAreaBalance;

    /**
     * y1区域雨水平衡
     */
    private String y1AreaBalance;

    /**
     * y2区域雨水平衡
     */
    private String y2AreaBalance;

    /**
     * y3区域雨水平衡
     */
    private String y3AreaBalance;

    /**
     * 时间
     */
    private String createTime;

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
     * 雨水总量平衡
     * @return total_rain_balance 雨水总量平衡
     */
    public String getTotalRainBalance() {
        return totalRainBalance;
    }

    /**
     * 雨水总量平衡
     * @param totalRainBalance 雨水总量平衡
     */
    public void setTotalRainBalance(String totalRainBalance) {
        this.totalRainBalance = totalRainBalance == null ? null : totalRainBalance.trim();
    }

    /**
     * A区域供雨水平衡
     * @return a_area_balance A区域供雨水平衡
     */
    public String getaAreaBalance() {
        return aAreaBalance;
    }

    /**
     * A区域供雨水平衡
     * @param aAreaBalance A区域供雨水平衡
     */
    public void setaAreaBalance(String aAreaBalance) {
        this.aAreaBalance = aAreaBalance == null ? null : aAreaBalance.trim();
    }

    /**
     * B区域供雨水平衡
     * @return b_area_balance B区域供雨水平衡
     */
    public String getbAreaBalance() {
        return bAreaBalance;
    }

    /**
     * B区域供雨水平衡
     * @param bAreaBalance B区域供雨水平衡
     */
    public void setbAreaBalance(String bAreaBalance) {
        this.bAreaBalance = bAreaBalance == null ? null : bAreaBalance.trim();
    }

    /**
     * C区域供雨水平衡
     * @return c_area_balance C区域供雨水平衡
     */
    public String getcAreaBalance() {
        return cAreaBalance;
    }

    /**
     * C区域供雨水平衡
     * @param cAreaBalance C区域供雨水平衡
     */
    public void setcAreaBalance(String cAreaBalance) {
        this.cAreaBalance = cAreaBalance == null ? null : cAreaBalance.trim();
    }

    /**
     * D区域供雨水平衡
     * @return d_area_balance D区域供雨水平衡
     */
    public String getdAreaBalance() {
        return dAreaBalance;
    }

    /**
     * D区域供雨水平衡
     * @param dAreaBalance D区域供雨水平衡
     */
    public void setdAreaBalance(String dAreaBalance) {
        this.dAreaBalance = dAreaBalance == null ? null : dAreaBalance.trim();
    }

    /**
     * E区域供雨水平衡
     * @return e_area_balance E区域供雨水平衡
     */
    public String geteAreaBalance() {
        return eAreaBalance;
    }

    /**
     * E区域供雨水平衡
     * @param eAreaBalance E区域供雨水平衡
     */
    public void seteAreaBalance(String eAreaBalance) {
        this.eAreaBalance = eAreaBalance == null ? null : eAreaBalance.trim();
    }

    /**
     * F区域供雨水平衡
     * @return f_area_balance F区域供雨水平衡
     */
    public String getfAreaBalance() {
        return fAreaBalance;
    }

    /**
     * F区域供雨水平衡
     * @param fAreaBalance F区域供雨水平衡
     */
    public void setfAreaBalance(String fAreaBalance) {
        this.fAreaBalance = fAreaBalance == null ? null : fAreaBalance.trim();
    }

    /**
     * G区域供雨水平衡
     * @return g_area_balance G区域供雨水平衡
     */
    public String getgAreaBalance() {
        return gAreaBalance;
    }

    /**
     * G区域供雨水平衡
     * @param gAreaBalance G区域供雨水平衡
     */
    public void setgAreaBalance(String gAreaBalance) {
        this.gAreaBalance = gAreaBalance == null ? null : gAreaBalance.trim();
    }

    /**
     * y1区域雨水平衡
     * @return y1_area_balance y1区域雨水平衡
     */
    public String getY1AreaBalance() {
        return y1AreaBalance;
    }

    /**
     * y1区域雨水平衡
     * @param y1AreaBalance y1区域雨水平衡
     */
    public void setY1AreaBalance(String y1AreaBalance) {
        this.y1AreaBalance = y1AreaBalance == null ? null : y1AreaBalance.trim();
    }

    /**
     * y2区域雨水平衡
     * @return y2_area_balance y2区域雨水平衡
     */
    public String getY2AreaBalance() {
        return y2AreaBalance;
    }

    /**
     * y2区域雨水平衡
     * @param y2AreaBalance y2区域雨水平衡
     */
    public void setY2AreaBalance(String y2AreaBalance) {
        this.y2AreaBalance = y2AreaBalance == null ? null : y2AreaBalance.trim();
    }

    /**
     * y3区域雨水平衡
     * @return y3_area_balance y3区域雨水平衡
     */
    public String getY3AreaBalance() {
        return y3AreaBalance;
    }

    /**
     * y3区域雨水平衡
     * @param y3AreaBalance y3区域雨水平衡
     */
    public void setY3AreaBalance(String y3AreaBalance) {
        this.y3AreaBalance = y3AreaBalance == null ? null : y3AreaBalance.trim();
    }

    /**
     * 时间
     * @return create_time 时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 时间
     * @param createTime 时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}