package com.zy.gis.pojo.devAndFacility;

import com.zy.gis.pojo.BaseQueryEntity;

public class DevTypeInfo extends BaseQueryEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dev_type_info.id
     *
     * @mbg.generated Thu Sep 02 10:53:46 CST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dev_type_info.dev_type_name
     *
     * @mbg.generated Thu Sep 02 10:53:46 CST 2021
     */
    private String devTypeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dev_type_info.create_time
     *
     * @mbg.generated Thu Sep 02 10:53:46 CST 2021
     */
    private String createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dev_type_info.update_time
     *
     * @mbg.generated Thu Sep 02 10:53:46 CST 2021
     */
    private String updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dev_type_info.id
     *
     * @return the value of dev_type_info.id
     *
     * @mbg.generated Thu Sep 02 10:53:46 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dev_type_info.id
     *
     * @param id the value for dev_type_info.id
     *
     * @mbg.generated Thu Sep 02 10:53:46 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dev_type_info.dev_type_name
     *
     * @return the value of dev_type_info.dev_type_name
     *
     * @mbg.generated Thu Sep 02 10:53:46 CST 2021
     */
    public String getDevTypeName() {
        return devTypeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dev_type_info.dev_type_name
     *
     * @param devTypeName the value for dev_type_info.dev_type_name
     *
     * @mbg.generated Thu Sep 02 10:53:46 CST 2021
     */
    public void setDevTypeName(String devTypeName) {
        this.devTypeName = devTypeName == null ? null : devTypeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dev_type_info.create_time
     *
     * @return the value of dev_type_info.create_time
     *
     * @mbg.generated Thu Sep 02 10:53:46 CST 2021
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dev_type_info.create_time
     *
     * @param createTime the value for dev_type_info.create_time
     *
     * @mbg.generated Thu Sep 02 10:53:46 CST 2021
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dev_type_info.update_time
     *
     * @return the value of dev_type_info.update_time
     *
     * @mbg.generated Thu Sep 02 10:53:46 CST 2021
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dev_type_info.update_time
     *
     * @param updateTime the value for dev_type_info.update_time
     *
     * @mbg.generated Thu Sep 02 10:53:46 CST 2021
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    @Override
    public String toString() {
        return "DevTypeInfo{" +
                "id=" + id +
                ", devTypeName='" + devTypeName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}