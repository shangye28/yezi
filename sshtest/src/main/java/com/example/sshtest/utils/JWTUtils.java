package com.example.sshtest.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class JWTUtils {

    //自定义签名密钥
    private static final String SIG = "HIUDe9%^#&dsf4%#4tr115&*&*wer6grfvewfw";

    /**
     * 生成token
     * @param map 自定义数据
     * @return String
     */

    public static String getToken(Map<String,String> map){
        Algorithm alg = Algorithm.HMAC256(SIG); //自定义签名密钥
        Calendar ins = Calendar.getInstance();
        ins.add(Calendar.DATE,1); //默认过期时间为1天
//        ins.add(Calendar.MINUTE,15); //默认过期时间为15分钟
//        ins.add(Calendar.SECOND,30);
        //jwt builder
        JWTCreator.Builder builder = JWT.create();
        builder.withIssuedAt(new Date());
        //payload
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        //signature
        String token = builder.withExpiresAt(ins.getTime()).sign(alg);

        return token;
    }

    /**
     * 获取token信息
     * @param token
     * @return DecodedJWT
     */
    public static DecodedJWT getTokenInfo(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIG)).build().verify(token);
        return verify;
    }

    /**
     * @属性 检验token合法性
     * @作用 80
     */
    public static boolean checkToken(String token){
        boolean flag = false;
        try{
            getTokenInfo(token);
            flag=true;
        }catch (Exception e){
            flag=false;
        }finally {
            return flag;
        }
    }
    /**
     * @属性 通过token获取用户名
     * @作用 80
     */
    public static String getNameByToken(String token){
        DecodedJWT tokenInfo = getTokenInfo(token);
        String username = tokenInfo.getClaim("username").asString();
        return username;
    }

    /**
     * @属性 通过token获取用户id
     * @作用 80
     */
    public static String getIdByToken(String token){
        DecodedJWT tokenInfo = getTokenInfo(token);
        String userid = tokenInfo.getClaim("userid").asString();
        return userid;
    }

}
