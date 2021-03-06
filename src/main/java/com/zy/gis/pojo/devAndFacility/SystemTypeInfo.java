package com.zy.gis.pojo.devAndFacility;

import com.zy.gis.pojo.BaseQueryEntity;

public class SystemTypeInfo extends BaseQueryEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column control_system_type_info.id
     *
     * @mbg.generated Mon Sep 06 14:01:09 CST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column control_system_type_info.system_type_name
     *
     * @mbg.generated Mon Sep 06 14:01:09 CST 2021
     */
    private String systemTypeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column control_system_type_info.dev_type_id_group
     *
     * @mbg.generated Mon Sep 06 14:01:09 CST 2021
     */
    private String devTypeIdGroup;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column control_system_type_info.dev_type_name_group
     *
     * @mbg.generated Mon Sep 06 14:01:09 CST 2021
     */
    private String devTypeNameGroup;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column control_system_type_info.create_time
     *
     * @mbg.generated Mon Sep 06 14:01:09 CST 2021
     */
    private String createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column control_system_type_info.update_time
     *
     * @mbg.generated Mon Sep 06 14:01:09 CST 2021
     */
    private String updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column control_system_type_info.id
     *
     * @return the value of control_system_type_info.id
     *
     * @mbg.generated Mon Sep 06 14:01:09 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column control_system_type_info.id
     *
     * @param id the value for control_system_type_info.id
     *
     * @mbg.generated Mon Sep 06 14:01:09 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column control_system_type_info.system_type_name
     *
     * @return the value of control_system_type_info.system_type_name
     *
     * @mbg.generated Mon Sep 06 14:01:09 CST 2021
     */
    public String getSystemTypeName() {
        return systemTypeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column control_system_type_info.system_type_name
     *
     * @param systemTypeName the value for control_system_type_info.system_type_name
     *
     * @mbg.generated Mon Sep 06 14:01:09 CST 2021
     */
    public void setSystemTypeName(String systemTypeName) {
        this.systemTypeName = systemTypeName == null ? null : systemTypeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column control_system_type_info.dev_type_id_group
     *
     * @return the value of control_system_type_info.dev_type_id_group
     *
     * @mbg.generated Mon Sep 06 14:01:09 CST 2021
     */
    public String getDevTypeIdGroup() {
        return devTypeIdGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column control_system_type_info.dev_type_id_group
     *
     * @param devTypeIdGroup the value for control_system_type_info.dev_type_id_group
     *
     * @mbg.generated Mon Sep 06 14:01:09 CST 2021
     */
    public void setDevTypeIdGroup(String devTypeIdGroup) {
        this.devTypeIdGroup = devTypeIdGroup == null ? null : devTypeIdGroup.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column control_system_type_info.dev_type_name_group
     *
     * @return the value of control_system_type_info.dev_type_name_group
     *
     * @mbg.generated Mon Sep 06 14:01:09 CST 2021
     */
    public String getDevTypeNameGroup() {
        return devTypeNameGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column control_system_type_info.dev_type_name_group
     *
     * @param devTypeNameGroup the value for control_system_type_info.dev_type_name_group
     *
     * @mbg.generated Mon Sep 06 14:01:09 CST 2021
     */
    public void setDevTypeNameGroup(String devTypeNameGroup) {
        this.devTypeNameGroup = devTypeNameGroup == null ? null : devTypeNameGroup.trim();
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column control_system_type_info.create_time
     *
     * @return the value of control_system_type_info.create_time
     *
     * @mbg.generated Mon Sep 06 14:01:09 CST 2021
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column control_system_type_info.create_time
     *
     * @param createTime the value for control_system_type_info.create_time
     *
     * @mbg.generated Mon Sep 06 14:01:09 CST 2021
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column control_system_type_info.update_time
     *
     * @return the value of control_system_type_info.update_time
     *
     * @mbg.generated Mon Sep 06 14:01:09 CST 2021
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column control_system_type_info.update_time
     *
     * @param updateTime the value for control_system_type_info.update_time
     *
     * @mbg.generated Mon Sep 06 14:01:09 CST 2021
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}