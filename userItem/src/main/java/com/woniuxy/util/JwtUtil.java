package com.woniuxy.util;//package com.gy.website.aspect;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

//**
// * @version: V1.0
// * @author: Xbao
// * @className: JwtUtil
// * @packageName: com.woniu.project.common.core.util
// * @description: Jwt登录认证
// * @data: 2020-09-27 21:07
// */
public class JwtUtil {

  public static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);;

    /**
     * 生成token
     *
     */
    public static String createToken(Map<String, Object> values,Integer sec){
        return Jwts.builder()
                .setClaims(values)
                .setExpiration(new Date(System.currentTimeMillis() + sec *1000))
                .signWith(key)
                .compact();
    }

    /**
     * 解析token
     */
    public static Claims parseToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


}
