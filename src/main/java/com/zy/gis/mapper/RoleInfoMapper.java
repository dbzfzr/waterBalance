package com.zy.gis.mapper;

import com.zy.gis.pojo.RoleInfo;
import com.zy.gis.pojo.devAndFacility.MaterialTypeInfo;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;

@Repository
public interface RoleInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbg.generated Fri Aug 20 10:21:31 CST 2021
     */
    Integer deleteByPrimaryKey(Integer roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbg.generated Fri Aug 20 10:21:31 CST 2021
     */
    Integer insert(RoleInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbg.generated Fri Aug 20 10:21:31 CST 2021
     */
    Integer insertSelective(RoleInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbg.generated Fri Aug 20 10:21:31 CST 2021
     */
    RoleInfo selectByPrimaryKey(Integer roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbg.generated Fri Aug 20 10:21:31 CST 2021
     */
    Integer updateByPrimaryKeySelective(RoleInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbg.generated Fri Aug 20 10:21:31 CST 2021
     */
    Integer updateByPrimaryKey(RoleInfo record);

    List<RoleInfo> getRoleInfoList(RoleInfo roleInfo);


    List<RoleInfo> getAllRoleInfo(RoleInfo roleInfo);

    int getAllRoleInfoCount(RoleInfo roleInfo);
}