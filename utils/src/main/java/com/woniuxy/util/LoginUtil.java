package com.woniuxy.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.lang.reflect.Field;
import java.security.Key;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName LoginUtil
 * @Author shadow
 * @Date 2020/11/9 16:46
 * @Description TODO
 **/
public class LoginUtil {
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
    @SuppressWarnings({ "unchecked", "deprecation" })
    public static <T> T parseToken(String token,Class<T> c) {
        Claims claims= Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(sert.getBytes())).build().parseClaimsJws(token).getBody();
        if(claims!=null&claims.size()>0) {
            Object obj=null;
            try {
                obj=c.newInstance();
                Field[] fields = c.getFields();
                if(fields!=null&&fields.length>0) {
                    for (Field field : fields) {
                        field.setAccessible(true);
                        field.set(obj, claims.get(field.getName()));
                    }
                }
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (SecurityException e) {
                e.printStackTrace();
                throw e;
            }
            return (T)obj;
        }else {
            return null;
        }
    }
}
