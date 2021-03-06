package com.zy.gis.pojo.devAndFacility;

import com.zy.gis.pojo.OrganizeInfo;

public class NetworkPointInfo extends OrganizeInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_point_info.id
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_point_info.point_no
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String pointNo;

    /**
    @author Wangchong
    @date 2021/11/19 10:55
    @description TODO 下一个有联系的高一级的点位编号
    */
    private String nextLinkPointNo;

    /**
    @author Wangchong
    @date 2021/11/19 10:54
    @description TODO 记录点位名称
    */
    private String pointName;

    /**
     @author Wangchong
     @date 2021/11/19 10:54
     @description TODO 记录所属类别
     */
    private String pointClass;


    /**
    @author Wangchong
    @date 2021/11/24 14:34
    @description TODO 点位所属划分区域,例如A区域
    */
    private String belongDivideArea;

    /**
    @author Wangchong
    @date 2021/11/24 14:35
    @description TODO 方向 N 江南大道以北 S 江南大道以南
    */
    private String direction;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_point_info.address_name
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String addressName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_point_info.address_id
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String addressId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_point_info.network_type
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String networkType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_point_info.network_level
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String networkLevel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_point_info.point_type
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String pointType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_point_info.system_type
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String systemType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_point_info.material
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String material;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_point_info.specs
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String specs;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_point_info.longitude
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String longitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_point_info.latitude
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String latitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_point_info.top_depth
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String topDepth;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_point_info.bottom_depth
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String bottomDepth;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_point_info.completion_date
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String completionDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_point_info.create_time
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_point_info.update_time
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_point_info.id
     *
     * @return the value of network_point_info.id
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_point_info.id
     *
     * @param id the value for network_point_info.id
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_point_info.point_no
     *
     * @return the value of network_point_info.point_no
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getPointNo() {
        return pointNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_point_info.point_no
     *
     * @param pointNo the value for network_point_info.point_no
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setPointNo(String pointNo) {
        this.pointNo = pointNo == null ? null : pointNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_point_info.address_name
     *
     * @return the value of network_point_info.address_name
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_point_info.address_name
     *
     * @param addressName the value for network_point_info.address_name
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName == null ? null : addressName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_point_info.address_id
     *
     * @return the value of network_point_info.address_id
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_point_info.address_id
     *
     * @param addressId the value for network_point_info.address_id
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setAddressId(String addressId) {
        this.addressId = addressId == null ? null : addressId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_point_info.network_type
     *
     * @return the value of network_point_info.network_type
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getNetworkType() {
        return networkType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_point_info.network_type
     *
     * @param networkType the value for network_point_info.network_type
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setNetworkType(String networkType) {
        this.networkType = networkType == null ? null : networkType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_point_info.network_level
     *
     * @return the value of network_point_info.network_level
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getNetworkLevel() {
        return networkLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_point_info.network_level
     *
     * @param networkLevel the value for network_point_info.network_level
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setNetworkLevel(String networkLevel) {
        this.networkLevel = networkLevel == null ? null : networkLevel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_point_info.point_type
     *
     * @return the value of network_point_info.point_type
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getPointType() {
        return pointType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_point_info.point_type
     *
     * @param pointType the value for network_point_info.point_type
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setPointType(String pointType) {
        this.pointType = pointType == null ? null : pointType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_point_info.system_type
     *
     * @return the value of network_point_info.system_type
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getSystemType() {
        return systemType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_point_info.system_type
     *
     * @param systemType the value for network_point_info.system_type
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setSystemType(String systemType) {
        this.systemType = systemType == null ? null : systemType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_point_info.material
     *
     * @return the value of network_point_info.material
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getMaterial() {
        return material;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_point_info.material
     *
     * @param material the value for network_point_info.material
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_point_info.specs
     *
     * @return the value of network_point_info.specs
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getSpecs() {
        return specs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_point_info.specs
     *
     * @param specs the value for network_point_info.specs
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setSpecs(String specs) {
        this.specs = specs == null ? null : specs.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_point_info.longitude
     *
     * @return the value of network_point_info.longitude
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_point_info.longitude
     *
     * @param longitude the value for network_point_info.longitude
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_point_info.latitude
     *
     * @return the value of network_point_info.latitude
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_point_info.latitude
     *
     * @param latitude the value for network_point_info.latitude
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_point_info.top_depth
     *
     * @return the value of network_point_info.top_depth
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getTopDepth() {
        return topDepth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_point_info.top_depth
     *
     * @param topDepth the value for network_point_info.top_depth
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setTopDepth(String topDepth) {
        this.topDepth = topDepth == null ? null : topDepth.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_point_info.bottom_depth
     *
     * @return the value of network_point_info.bottom_depth
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getBottomDepth() {
        return bottomDepth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_point_info.bottom_depth
     *
     * @param bottomDepth the value for network_point_info.bottom_depth
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setBottomDepth(String bottomDepth) {
        this.bottomDepth = bottomDepth == null ? null : bottomDepth.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_point_info.completion_date
     *
     * @return the value of network_point_info.completion_date
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getCompletionDate() {
        return completionDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_point_info.completion_date
     *
     * @param completionDate the value for network_point_info.completion_date
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate == null ? null : completionDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_point_info.create_time
     *
     * @return the value of network_point_info.create_time
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_point_info.create_time
     *
     * @param createTime the value for network_point_info.create_time
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_point_info.update_time
     *
     * @return the value of network_point_info.update_time
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_point_info.update_time
     *
     * @param updateTime the value for network_point_info.update_time
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getNextLinkPointNo() {
        return nextLinkPointNo;
    }

    public void setNextLinkPointNo(String nextLinkPointNo) {
        this.nextLinkPointNo = nextLinkPointNo;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getPointClass() {
        return pointClass;
    }

    public void setPointClass(String pointClass) {
        this.pointClass = pointClass;
    }

    public String getBelongDivideArea() {
        return belongDivideArea;
    }

    public void setBelongDivideArea(String belongDivideArea) {
        this.belongDivideArea = belongDivideArea;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}