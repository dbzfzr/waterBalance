package com.zy.gis.pojo.waterbalance;

import java.io.Serializable;

/**
@author Wangchong
@date 2021/11/25 16:43
@description TODO 污水平衡信息封装类
*/
public class SewageBalance implements Serializable {
    /**
     * 记录id
     */
    private Integer id;

    /**
     * 污水总量平衡
     */
    private String totalSewageBalance;

    /**
     * 区域污水总量平衡
     */
    private String regionalTotalSewageBalance;

    /**
     * 局部污水总量平衡
     */
    private String localSewageBalance;

    /**
     * A区域供排水平衡
     */
    private String aAreaBalance;

    /**
     * B区域供排水平衡
     */
    private String bAreaBalance;

    /**
     * C区域供排水平衡
     */
    private String cAreaBalance;

    /**
     * D区域供排水平衡
     */
    private String dAreaBalance;

    /**
     * E区域供排水平衡
     */
    private String eAreaBalance;

    /**
     * F区域供排水平衡
     */
    private String fAreaBalance;

    /**
     * G区域供排水平衡
     */
    private String gAreaBalance;

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
     * 污水总量平衡
     * @return total_sewage_balance 污水总量平衡
     */
    public String getTotalSewageBalance() {
        return totalSewageBalance;
    }

    /**
     * 污水总量平衡
     * @param totalSewageBalance 污水总量平衡
     */
    public void setTotalSewageBalance(String totalSewageBalance) {
        this.totalSewageBalance = totalSewageBalance == null ? null : totalSewageBalance.trim();
    }

    /**
     * 区域污水总量平衡
     * @return regional_total_sewage_balance 区域污水总量平衡
     */
    public String getRegionalTotalSewageBalance() {
        return regionalTotalSewageBalance;
    }

    /**
     * 区域污水总量平衡
     * @param regionalTotalSewageBalance 区域污水总量平衡
     */
    public void setRegionalTotalSewageBalance(String regionalTotalSewageBalance) {
        this.regionalTotalSewageBalance = regionalTotalSewageBalance == null ? null : regionalTotalSewageBalance.trim();
    }

    /**
     * 局部污水总量平衡
     * @return local_sewage_balance 局部污水总量平衡
     */
    public String getLocalSewageBalance() {
        return localSewageBalance;
    }

    /**
     * 局部污水总量平衡
     * @param localSewageBalance 局部污水总量平衡
     */
    public void setLocalSewageBalance(String localSewageBalance) {
        this.localSewageBalance = localSewageBalance == null ? null : localSewageBalance.trim();
    }

    /**
     * A区域供排水平衡
     * @return a_area_balance A区域供排水平衡
     */
    public String getaAreaBalance() {
        return aAreaBalance;
    }

    /**
     * A区域供排水平衡
     * @param aAreaBalance A区域供排水平衡
     */
    public void setaAreaBalance(String aAreaBalance) {
        this.aAreaBalance = aAreaBalance == null ? null : aAreaBalance.trim();
    }

    /**
     * B区域供排水平衡
     * @return b_area_balance B区域供排水平衡
     */
    public String getbAreaBalance() {
        return bAreaBalance;
    }

    /**
     * B区域供排水平衡
     * @param bAreaBalance B区域供排水平衡
     */
    public void setbAreaBalance(String bAreaBalance) {
        this.bAreaBalance = bAreaBalance == null ? null : bAreaBalance.trim();
    }

    /**
     * C区域供排水平衡
     * @return c_area_balance C区域供排水平衡
     */
    public String getcAreaBalance() {
        return cAreaBalance;
    }

    /**
     * C区域供排水平衡
     * @param cAreaBalance C区域供排水平衡
     */
    public void setcAreaBalance(String cAreaBalance) {
        this.cAreaBalance = cAreaBalance == null ? null : cAreaBalance.trim();
    }

    /**
     * D区域供排水平衡
     * @return d_area_balance D区域供排水平衡
     */
    public String getdAreaBalance() {
        return dAreaBalance;
    }

    /**
     * D区域供排水平衡
     * @param dAreaBalance D区域供排水平衡
     */
    public void setdAreaBalance(String dAreaBalance) {
        this.dAreaBalance = dAreaBalance == null ? null : dAreaBalance.trim();
    }

    /**
     * E区域供排水平衡
     * @return e_area_balance E区域供排水平衡
     */
    public String geteAreaBalance() {
        return eAreaBalance;
    }

    /**
     * E区域供排水平衡
     * @param eAreaBalance E区域供排水平衡
     */
    public void seteAreaBalance(String eAreaBalance) {
        this.eAreaBalance = eAreaBalance == null ? null : eAreaBalance.trim();
    }

    /**
     * F区域供排水平衡
     * @return f_area_balance F区域供排水平衡
     */
    public String getfAreaBalance() {
        return fAreaBalance;
    }

    /**
     * F区域供排水平衡
     * @param fAreaBalance F区域供排水平衡
     */
    public void setfAreaBalance(String fAreaBalance) {
        this.fAreaBalance = fAreaBalance == null ? null : fAreaBalance.trim();
    }

    /**
     * G区域供排水平衡
     * @return g_area_balance G区域供排水平衡
     */
    public String getgAreaBalance() {
        return gAreaBalance;
    }

    /**
     * G区域供排水平衡
     * @param gAreaBalance G区域供排水平衡
     */
    public void setgAreaBalance(String gAreaBalance) {
        this.gAreaBalance = gAreaBalance == null ? null : gAreaBalance.trim();
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