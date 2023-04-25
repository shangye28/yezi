package com.example.sshtest.utils;

import org.springframework.util.DigestUtils;

public class MD5Utils {
    public static void main(String[] args) {
        String s = "ba bai";
        System.out.println(DigestUtils.md5DigestAsHex(s.getBytes()));
    }

    public static String getMD5(String password){

        /**
         * 加密处理第一次
         */
        String pwd = "abc123";
        pwd+=password;
        pwd+="def123";
        String s = DigestUtils.md5DigestAsHex(pwd.getBytes());

        /**
         * 加密处理第二次
         */
        String Dpwd = "ghi123";
        Dpwd+=s;
        Dpwd+= "jkl123";
        String ss = DigestUtils.md5DigestAsHex(Dpwd.getBytes());
        return ss;
    }
}
