package com.zy.gis.mapper.devAndFacility;

import com.zy.gis.pojo.devAndFacility.DevInfo;
import com.zy.gis.pojo.devAndFacility.DevValveInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevValveInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_valve_info
     *
     * @mbg.generated Wed Sep 08 16:35:59 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_valve_info
     *
     * @mbg.generated Wed Sep 08 16:35:59 CST 2021
     */
    int insert(DevValveInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_valve_info
     *
     * @mbg.generated Wed Sep 08 16:35:59 CST 2021
     */
    int insertSelective(DevValveInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_valve_info
     *
     * @mbg.generated Wed Sep 08 16:35:59 CST 2021
     */
    DevValveInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_valve_info
     *
     * @mbg.generated Wed Sep 08 16:35:59 CST 2021
     */
    int updateByPrimaryKeySelective(DevValveInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dev_valve_info
     *
     * @mbg.generated Wed Sep 08 16:35:59 CST 2021
     */
    int updateByPrimaryKey(DevValveInfo record);

    int insertDev(DevInfo devInfo);

    List<DevInfo> getAllDev(DevInfo devInfo);

    int getAllDevCount(DevInfo devInfo);

    int updateDev(DevInfo devInfo);
}