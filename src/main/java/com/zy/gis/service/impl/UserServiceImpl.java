package com.zy.gis.service.impl;

import com.zy.gis.common.utils.DateUtil;
import com.zy.gis.common.utils.MD5Utils;
import com.zy.gis.mapper.UserInfoMapper;
import com.zy.gis.pojo.UserInfo;
import com.zy.gis.service.UserService;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 条件查询用户信息
     * @date 202108201701
     * @author Wangchong
     * @param userInfo 用户信息查询条件
     * @return 用户信息
     */
    @Transactional(readOnly = true)
    public List<UserInfo> getUserInfoList(UserInfo userInfo){
        return userInfoMapper.getUserInfoList(userInfo);
    }

    @Transactional(readOnly = true)
    public UserInfo getUserInfoByUserName(String userName){
        return userInfoMapper.getUserInfoByUserName(userName);
    }

    /**
     * 条件查询用户信息数量
     * @date 202108201705
     * @author Wangchong
     * @param userInfo 用户信息查询条件
     * @return 用户信息记录条数
     */
    @Transactional(readOnly = true)
    public Integer getUserInfoListCount(UserInfo userInfo){
        return userInfoMapper.getUserInfoListCount(userInfo);
    }

    /**
     * 添加用户信息
     * @date 202108231721
     * @author Wangchong
     * @param record 用户信息
     * @return 用户信息记录条数
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public Integer insertUserSelective(UserInfo record){
        record.setCreateTime(DateUtil.getNowTime());

        switch (record.getRoleId()){
            case 1:
                record.setRoleName("管理员");
                break;
            case 2:
                record.setRoleName("街道人员");
                break;
            case 3:
                record.setRoleName("社区单位人员");
                break;
            case 4:
                record.setRoleName("小区单位人员");
                break;
            case 5:
                record.setRoleName("运维人员");
                break;
        }

       // Object salt = ByteSource.Util.bytes(record.getUserName());   //盐值  admin 用username来作为盐值
        Object salt = ByteSource.Util.bytes(record.getPhone());   //盐值
        // 密码加密
        String password = MD5Utils.getPassword(salt, record.getPassword());
        record.setPassword(password);
        record.setSalt(salt.toString());
        return  userInfoMapper.insertSelective(record);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public Integer deleteByPrimaryKey(Integer userId){
         return userInfoMapper.deleteByPrimaryKey(userId);
    }

}
