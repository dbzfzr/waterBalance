package com.zy.gis.mapper;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMenuMapper {

    /**
     * 获取角色id所对应的菜单信息的id
     * @author Wangchong
     * @date 20201020
     * @param roleId 角色id
     * @return 菜单id信息
     */
    List<Integer> selectMenuId(@Param("roleId") Integer roleId);

    /**
     * 插入角色菜单信息
     *@author Wangchong
     *@date 20201022
     * @param param {"roleId":'',"menuIds":}
     * @return 插入条数
     */
    Integer insertRoleMenu(JSONObject param);

    /**
     *
     * 删除角色菜单信息
     * @author Wangchong
     * @date 20201022
     * @param param {"roleId":'',"menuIds":}
     * @return 删除条数
     */
    Integer deleteRoleMenu(JSONObject param);
}