package com.master.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author ColorXJH
 * @version 1.0
 * @description  jwt工具类
 * @date 2020/9/24 17:21
 */
public class JWTUtil {
    //过期时间
    private static final long EXPIRE_TIME=24*60*60*1000;
    //密钥
    private static final String SECRET="shiro+jwt";

    /**
     * @description: 生成token
     * @method: createToken
     * @param: [username]
     * @return: java.lang.String
     * @author: ColorXJH
     * @date: 2020/9/24 17:24
     */
    public static String createToken(String username){
        try {
            //创建时间
            Date date=new Date(System.currentTimeMillis()+EXPIRE_TIME);
            //密钥加密
            Algorithm algorithm=Algorithm.HMAC256(SECRET);
            //创建token
            return JWT.create()
                    //附带username信息
                    .withClaim("username",username)
                    //过期时间
                    .withExpiresAt(date)
                    //标记内容，防止篡改
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @description: 校验token是否正确
     * @method: verify
     * @param: [token, username]
     * @return: boolean
     * @author: ColorXJH
     * @date: 2020/9/24 17:33
     */
    public static boolean verify(String token,String username){
        try {
            Algorithm algorithm=Algorithm.HMAC256(SECRET);
            //根据已知的username,secret创建一个jwt验证器
            JWTVerifier verifier=JWT.require(algorithm)
                    .withClaim("username",username)
                    .build();
            //验证token
            verifier.verify(token);
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description: 获得token中的信息，无需secret解密也能获得
     * @method: getUsername
     * @param: []
     * @return: java.lang.String
     * @author: ColorXJH
     * @date: 2020/9/24 17:38
     */
    public static String getUsername(String token){

        try {
            DecodedJWT decodedJWT= JWT.decode(token);
            return decodedJWT.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            e.printStackTrace();
            return null;
        }
    }
}
