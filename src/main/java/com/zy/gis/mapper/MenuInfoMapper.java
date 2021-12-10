package com.zy.gis.mapper;

import com.zy.gis.pojo.EasyUITreeInfo;
import com.zy.gis.pojo.MenuInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuInfoMapper {

    /**获取菜单信息
     * @author Wangchong
     * @date 20201019
     * @param menuIds 菜单id
     * @return 菜单信息
     */
    List<MenuInfo> selectMenuInfo(@Param("menuIds") List<Integer> menuIds);

    /**
     * 获取权限信息
     * @author Wangchong
     * @date 20201019
     * @param menuIds 菜单id
     * @return 权限信息
     */
    List<String> selectPermissionInfo(@Param("menuIds") List<Integer> menuIds);

    /**
     * 获取菜单名称
     * @param menuIds 菜单id
     * @return
     */
    List<String> selectMenuName(@Param("menuIds") List<Integer> menuIds);

    List<Integer> selectAllMenuIds();

    /**
     * 获取主菜单 level为1 parentId为0的菜单信息封装为easytree
     * @author Wangchong
     * @date 20201021
     * @return
     */
    List<EasyUITreeInfo> selectPrimaryNavigation();

    /**
     * 根据parentId 获取 主菜单下的子菜单
     * @param parentId 父节点id
     * @author Wangchong
     * @date 20201021
     * @return
     */
    List<EasyUITreeInfo> selectMenuByParentId(@Param("parentId") Integer parentId);

    /**
    @author Wangchong
    @date 2021/11/11 11:55
    @description TODO 查询菜单信息
    @param menuInfo
    @return {@Link MenuInfo}
    */
    List<MenuInfo>selectMenuInfoList(MenuInfo menuInfo);

}