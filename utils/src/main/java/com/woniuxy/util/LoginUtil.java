package com.woniuxy.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LoginUtil
 * @Author shadow
 * @Date 2020/11/9 16:46
 * @Description TODO
 **/
public class LoginUtil {
    private static String key="laisdjfoiwqjflksaasfdasdfadsfwfrasdfsadffcasijfasadfasfdlkfjlasjflksajfd";

    public static String createToken(Map<String, Object> value, Integer sec) {
        return Jwts.builder().setClaims(value).setExpiration(new Date(System.currentTimeMillis() + sec * 1000))
                .signWith(Keys.hmacShaKeyFor(key.getBytes())).compact();
    }
    public static String createToken(Object value, Integer sec) {
        Map<String,Object> maps=new HashMap<>();
        Class<?> c = value.getClass();
        Field[] fields = c.getFields();
        if(fields!=null&&fields.length>0) {
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    maps.put(field.getName(), field.get(value));
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return Jwts.builder().setClaims(maps).setExpiration(new Date(System.currentTimeMillis() + sec * 1000))
                .signWith(Keys.hmacShaKeyFor(key.getBytes())).compact();
    }
    public static Claims parseToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
    @SuppressWarnings({ "unchecked", "deprecation" })
    public static <T> T parseToken(String token,Class<T> c) {
        Claims claims= Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
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
