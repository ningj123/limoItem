package com.woniuxy.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

/**
 * @version: V1.0
 * @author: Xbao
 * @className: JwtUtil
 * @packageName: com.woniu.project.common.core.util
 * @description: Jwt登录认证
 * @data: 2020-09-27 21:07
 */
public class JwtUtilLong {

    public static String sert = "mysecretkeywqerpiouqetpysbsdnvcsadhfakdsmsdjkslfhlajdkhasfdjkasdf";

    //生成token
    public static String createToken(Map<String,Object> maps,Integer second){
        Key key = Keys.hmacShaKeyFor(sert.getBytes());
        return Jwts.builder()
                .setClaims(maps)
                .setExpiration(new Date(System.currentTimeMillis()+second*1000))
                .signWith(key)
                .compact();
    }

    //解析token
    public static Map<String, Object> parseToken(String jwt){
        return Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(sert.getBytes())).build().parseClaimsJws(jwt).getBody();
    }


}
