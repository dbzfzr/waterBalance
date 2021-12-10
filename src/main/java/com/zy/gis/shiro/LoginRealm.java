package com.zy.gis.shiro;

import com.zy.gis.common.exception.ServiceException;
import com.zy.gis.pojo.UserInfo;
import com.zy.gis.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * 验证是否有访问权限 由 AuthorizingRealm类定义
 * */
public class LoginRealm extends AuthorizingRealm {

    Logger logger = LoggerFactory.getLogger(LoginRealm.class);

    @Autowired
    UserService userService;

    /**
     * 身份验证
     * 在这个方法中，进行身份验证
     * login时调用
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        logger.info("身份验证");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        // 其实是手机号码
        String phone = usernamePasswordToken.getUsername();

        //UserInfo userInfo = userService.getUserInfoByUserName(username);
        UserInfo tempUserInfo = new UserInfo();
        tempUserInfo.setPhone(phone);

        UserInfo userInfo = userService.getUserInfoList(tempUserInfo).get(0);
        String password = null;

        if(userInfo != null) {
            password  = userInfo.getPassword();
        } else {
            logger.info("没有" + phone + "这个账号");
            throw new ServiceException("手机号或密码错误");
        }
        if ( password == null || password.length() <= 0) {
            throw new ServiceException("手机号或密码错误");
        }
        SecurityUtils.getSubject().getSession().setAttribute("users", userInfo);

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userInfo, password,
                ByteSource.Util.bytes(phone), getName()); //根据盐值自动判断密码是否合规
        return simpleAuthenticationInfo;
    }

    /**
     *      权限验证
     *      获取身份信息，我们可以在这个方法中，从数据库获取该用户的权限和角色信息
     *      当调用权限验证时，就会调用此方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        UserInfo username = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        logger.info(username.toString());
        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();
        logger.info("权限验证：" + userInfo.toString());
        Set<String> roles = new HashSet<>();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
        Set<String> perm = new HashSet<>();
        perm.add("test");
        simpleAuthorizationInfo.addStringPermissions(perm);  //添加权限
        return simpleAuthorizationInfo;
    }

//    public static void main(String[] args) {
//        String hashAlgorithmName = "MD5";//加密方式
//
//        /*Object crdentials = "123456";//密码原值
//        Object salt = ByteSource.Util.bytes("admin");   //盐值*/  //YWRtaW4=6a5ba91eb079ca05f46998744ed09e0b
//        String originalPassword = "123456";   //密码原值
//
//        Object salt = ByteSource.Util.bytes("18888888888");   //盐值  admin 用username来作为盐值
//        System.out.println(salt);
//        int hashIterations = 2;  //加密迭代次数
//        Object result = new SimpleHash(hashAlgorithmName, originalPassword, salt, hashIterations);
//        System.out.println(result);
//    }

}
