package com.zy.gis.service;

import com.zy.gis.pojo.UserInfo;

import java.util.List;

public interface UserService {

    /**
     * 根据用户名称查询用户信息
     * @date 202108201155
     * @author Wangchong
     * @param userName 用户名称
     * @return 用户信息
     */
    UserInfo getUserInfoByUserName(String userName);

    /**
     * 条件查询用户信息
     * @date 202108201701
     * @author Wangchong
     * @param userInfo 用户信息查询条件
     * @return 用户信息
     */
    List<UserInfo> getUserInfoList(UserInfo userInfo);

    /**
     * 条件查询用户信息数量
     * @date 202108201705
     * @author Wangchong
     * @param userInfo 用户信息查询条件
     * @return 用户信息记录条数
     */
    Integer getUserInfoListCount(UserInfo userInfo);

    Integer insertUserSelective(UserInfo record);

    Integer deleteByPrimaryKey(Integer userId);

}
