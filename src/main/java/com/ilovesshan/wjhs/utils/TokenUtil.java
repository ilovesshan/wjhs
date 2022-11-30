package com.ilovesshan.wjhs.utils;

import com.ilovesshan.wjhs.contants.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;

import java.util.Date;

public class TokenUtil {

    // 生成token+
    public static String generatorToken(String userId, String username) {
        Claims claims = new DefaultClaims();
        claims.put("userId", userId);
        claims.put("username", username);
        return Jwts.builder()
                .setId(userId)
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, Constants.JWT_KEY.getBytes())
                .setExpiration(new Date(System.currentTimeMillis() + Constants.JWT_EXPIRATION))
                .compact();
    }

    // 获取Claims对象
    public static Claims parseToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(Constants.JWT_KEY.getBytes()).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return claims;
    }

    // 获取用户Id
    public static String getUserId(String token) {
        return (String) parseToken(token).get("userId");
    }


    // 获取用户名
    public static String getUsername(String token) {
        return (String) parseToken(token).get("username");
    }
}
