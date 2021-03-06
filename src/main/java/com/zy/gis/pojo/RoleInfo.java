package com.zy.gis.pojo;

/**
 * 角色信息实体类
 * @date 202108201015
 * @author Wangchong
 */
public class RoleInfo extends BaseQueryEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_info.role_id
     *
     * @mbg.generated Fri Aug 20 10:21:31 CST 2021
     */
    private Integer roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_info.role_name
     *
     * @mbg.generated Fri Aug 20 10:21:31 CST 2021
     */
    private String roleName;

    /**
     * 角色对应的菜单名称的联合字符串
     */
    private String roleMenuNameStr;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_info.create_time
     *
     * @mbg.generated Fri Aug 20 10:21:31 CST 2021
     */
    private String createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_info.update_time
     *
     * @mbg.generated Fri Aug 20 10:21:31 CST 2021
     */
    private String updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_info.role_id
     *
     * @return the value of role_info.role_id
     *
     * @mbg.generated Fri Aug 20 10:21:31 CST 2021
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_info.role_id
     *
     * @param roleId the value for role_info.role_id
     *
     * @mbg.generated Fri Aug 20 10:21:31 CST 2021
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_info.role_name
     *
     * @return the value of role_info.role_name
     *
     * @mbg.generated Fri Aug 20 10:21:31 CST 2021
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_info.role_name
     *
     * @param roleName the value for role_info.role_name
     *
     * @mbg.generated Fri Aug 20 10:21:31 CST 2021
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_info.create_time
     *
     * @return the value of role_info.create_time
     *
     * @mbg.generated Fri Aug 20 10:21:31 CST 2021
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_info.create_time
     *
     * @param createTime the value for role_info.create_time
     *
     * @mbg.generated Fri Aug 20 10:21:31 CST 2021
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_info.update_time
     *
     * @return the value of role_info.update_time
     *
     * @mbg.generated Fri Aug 20 10:21:31 CST 2021
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_info.update_time
     *
     * @param updateTime the value for role_info.update_time
     *
     * @mbg.generated Fri Aug 20 10:21:31 CST 2021
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getRoleMenuNameStr() {
        return roleMenuNameStr;
    }

    public void setRoleMenuNameStr(String roleMenuNameStr) {
        this.roleMenuNameStr = roleMenuNameStr;
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleMenuNameStr='" + roleMenuNameStr + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}