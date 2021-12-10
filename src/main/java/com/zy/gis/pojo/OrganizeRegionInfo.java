package com.zy.gis.pojo;

public class OrganizeRegionInfo {
    /**
    自增主键
     */
    private Integer id;

    /**
    所属组织ID
     */
    private Integer organizeId;

    /**
    经度（百度坐标系）
     */
    private String longitude;

    /**
    纬度（百度坐标系）
     */
    private String latitude;

    /**
    区域点位排序
     */
    private Integer sort;

    /**
    创建时间
     */
    private String createTime;

    /**
    更新时间
     */
    private String updateTime;

    /**
     * 自增主键
     * @return id 自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 自增主键
     * @param id 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 所属组织ID
     * @return organize_id 所属组织ID
     */
    public Integer getOrganizeId() {
        return organizeId;
    }

    /**
     * 所属组织ID
     * @param organizeId 所属组织ID
     */
    public void setOrganizeId(Integer organizeId) {
        this.organizeId = organizeId;
    }

    /**
     * 经度（百度坐标系）
     * @return longitude 经度（百度坐标系）
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 经度（百度坐标系）
     * @param longitude 经度（百度坐标系）
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * 纬度（百度坐标系）
     * @return latitude 纬度（百度坐标系）
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 纬度（百度坐标系）
     * @param latitude 纬度（百度坐标系）
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * 区域点位排序
     * @return sort 区域点位排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 区域点位排序
     * @param sort 区域点位排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
}