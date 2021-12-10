package com.zy.gis.pojo.devAndFacility;

import com.zy.gis.pojo.OrganizeInfo;

public class NetworkPipelineInfo extends OrganizeInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.id
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.pipeline_no
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String pipelineNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.start_point_no
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String startPointNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.end_point_no
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String endPointNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.address_name
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String addressName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.address_id
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String addressId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.network_type
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String networkType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.network_level
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String networkLevel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.system_type
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String systemType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.material
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String material;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.specs
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String specs;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.start_longitude
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String startLongitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.start_latitude
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String startLatitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.end_longitude
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String endLongitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.end_latitude
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String endLatitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.start_top_depth
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String startTopDepth;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.start_bottom_depth
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String startBottomDepth;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.end_top_depth
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String endTopDepth;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.end_bottom_depth
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String endBottomDepth;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.completion_date
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String completionDate;

    /**
     * 20211116 Wanghcong
     * 新加字段
     * 管线上的点位的报警状态，设备故障等与管线无关的报警信息，状态为false,而管网堵塞，为true
     */
    private String alarmState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.create_time
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column network_pipeline_info.update_time
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    private String updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.id
     *
     * @return the value of network_pipeline_info.id
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.id
     *
     * @param id the value for network_pipeline_info.id
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.pipeline_no
     *
     * @return the value of network_pipeline_info.pipeline_no
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getPipelineNo() {
        return pipelineNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.pipeline_no
     *
     * @param pipelineNo the value for network_pipeline_info.pipeline_no
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setPipelineNo(String pipelineNo) {
        this.pipelineNo = pipelineNo == null ? null : pipelineNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.start_point_no
     *
     * @return the value of network_pipeline_info.start_point_no
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getStartPointNo() {
        return startPointNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.start_point_no
     *
     * @param startPointNo the value for network_pipeline_info.start_point_no
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setStartPointNo(String startPointNo) {
        this.startPointNo = startPointNo == null ? null : startPointNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.end_point_no
     *
     * @return the value of network_pipeline_info.end_point_no
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getEndPointNo() {
        return endPointNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.end_point_no
     *
     * @param endPointNo the value for network_pipeline_info.end_point_no
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setEndPointNo(String endPointNo) {
        this.endPointNo = endPointNo == null ? null : endPointNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.address_name
     *
     * @return the value of network_pipeline_info.address_name
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.address_name
     *
     * @param addressName the value for network_pipeline_info.address_name
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName == null ? null : addressName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.address_id
     *
     * @return the value of network_pipeline_info.address_id
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.address_id
     *
     * @param addressId the value for network_pipeline_info.address_id
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setAddressId(String addressId) {
        this.addressId = addressId == null ? null : addressId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.network_type
     *
     * @return the value of network_pipeline_info.network_type
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getNetworkType() {
        return networkType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.network_type
     *
     * @param networkType the value for network_pipeline_info.network_type
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setNetworkType(String networkType) {
        this.networkType = networkType == null ? null : networkType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.network_level
     *
     * @return the value of network_pipeline_info.network_level
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getNetworkLevel() {
        return networkLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.network_level
     *
     * @param networkLevel the value for network_pipeline_info.network_level
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setNetworkLevel(String networkLevel) {
        this.networkLevel = networkLevel == null ? null : networkLevel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.system_type
     *
     * @return the value of network_pipeline_info.system_type
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getSystemType() {
        return systemType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.system_type
     *
     * @param systemType the value for network_pipeline_info.system_type
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setSystemType(String systemType) {
        this.systemType = systemType == null ? null : systemType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.material
     *
     * @return the value of network_pipeline_info.material
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getMaterial() {
        return material;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.material
     *
     * @param material the value for network_pipeline_info.material
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.specs
     *
     * @return the value of network_pipeline_info.specs
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getSpecs() {
        return specs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.specs
     *
     * @param specs the value for network_pipeline_info.specs
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setSpecs(String specs) {
        this.specs = specs == null ? null : specs.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.start_longitude
     *
     * @return the value of network_pipeline_info.start_longitude
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getStartLongitude() {
        return startLongitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.start_longitude
     *
     * @param startLongitude the value for network_pipeline_info.start_longitude
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setStartLongitude(String startLongitude) {
        this.startLongitude = startLongitude == null ? null : startLongitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.start_latitude
     *
     * @return the value of network_pipeline_info.start_latitude
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getStartLatitude() {
        return startLatitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.start_latitude
     *
     * @param startLatitude the value for network_pipeline_info.start_latitude
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setStartLatitude(String startLatitude) {
        this.startLatitude = startLatitude == null ? null : startLatitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.end_longitude
     *
     * @return the value of network_pipeline_info.end_longitude
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getEndLongitude() {
        return endLongitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.end_longitude
     *
     * @param endLongitude the value for network_pipeline_info.end_longitude
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setEndLongitude(String endLongitude) {
        this.endLongitude = endLongitude == null ? null : endLongitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.end_latitude
     *
     * @return the value of network_pipeline_info.end_latitude
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getEndLatitude() {
        return endLatitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.end_latitude
     *
     * @param endLatitude the value for network_pipeline_info.end_latitude
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setEndLatitude(String endLatitude) {
        this.endLatitude = endLatitude == null ? null : endLatitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.start_top_depth
     *
     * @return the value of network_pipeline_info.start_top_depth
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getStartTopDepth() {
        return startTopDepth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.start_top_depth
     *
     * @param startTopDepth the value for network_pipeline_info.start_top_depth
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setStartTopDepth(String startTopDepth) {
        this.startTopDepth = startTopDepth == null ? null : startTopDepth.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.start_bottom_depth
     *
     * @return the value of network_pipeline_info.start_bottom_depth
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getStartBottomDepth() {
        return startBottomDepth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.start_bottom_depth
     *
     * @param startBottomDepth the value for network_pipeline_info.start_bottom_depth
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setStartBottomDepth(String startBottomDepth) {
        this.startBottomDepth = startBottomDepth == null ? null : startBottomDepth.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.end_top_depth
     *
     * @return the value of network_pipeline_info.end_top_depth
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getEndTopDepth() {
        return endTopDepth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.end_top_depth
     *
     * @param endTopDepth the value for network_pipeline_info.end_top_depth
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setEndTopDepth(String endTopDepth) {
        this.endTopDepth = endTopDepth == null ? null : endTopDepth.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.end_bottom_depth
     *
     * @return the value of network_pipeline_info.end_bottom_depth
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getEndBottomDepth() {
        return endBottomDepth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.end_bottom_depth
     *
     * @param endBottomDepth the value for network_pipeline_info.end_bottom_depth
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setEndBottomDepth(String endBottomDepth) {
        this.endBottomDepth = endBottomDepth == null ? null : endBottomDepth.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.completion_date
     *
     * @return the value of network_pipeline_info.completion_date
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getCompletionDate() {
        return completionDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.completion_date
     *
     * @param completionDate the value for network_pipeline_info.completion_date
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate == null ? null : completionDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.create_time
     *
     * @return the value of network_pipeline_info.create_time
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.create_time
     *
     * @param createTime the value for network_pipeline_info.create_time
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column network_pipeline_info.update_time
     *
     * @return the value of network_pipeline_info.update_time
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column network_pipeline_info.update_time
     *
     * @param updateTime the value for network_pipeline_info.update_time
     *
     * @mbg.generated Sat Sep 04 15:15:47 CST 2021
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getAlarmState() {
        return alarmState;
    }

    public void setAlarmState(String alarmState) {
        this.alarmState = alarmState;
    }
}