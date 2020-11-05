package com.huanletao.huanletao.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2020/4/14
 * @Time: 22:44
 * Description:MD5 密码加密工具类。
 */
public class MD5Utils {

    //获取加密后的字符串
    public static String MD5Encode(String password){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 计算md5函数
        md.update(password.getBytes());

        return new BigInteger(1, md.digest()).toString(14);
    }


    public static String encode(String resource,String salt){
        SimpleHash hash = null;
        if (StringUtils.isNotBlank(salt)) {
            hash = new Md5Hash(resource,salt);
        }
        return hash.toString();
    }

}
