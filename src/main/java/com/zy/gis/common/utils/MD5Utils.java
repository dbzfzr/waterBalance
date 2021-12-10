package com.zy.gis.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Utils {

    private static String hashAlgorithmName = "MD5";//加密方式

    private static int hashIterations = 2;  //加密迭代次数

    public static String getPassword(Object salt, String originalPassword) {
        int hashIterations = 2;  //加密迭代次数
        Object result = new SimpleHash(hashAlgorithmName, originalPassword, salt, hashIterations);
        return result.toString();
    }
}
