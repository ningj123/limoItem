/*
package com.woniuxy.filter;

import com.woniuxy.util.LoginUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

*/
/**
 * @ClassName AuthenticationFilter
 * @Author shadow
 * @Date 2020/11/17 9:30
 * @Description TODO
 **//*

//@Component
public class AuthenticationFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst("x-token");
        if("/user/login".equals(exchange.getRequest().getPath().toString())) {
            return chain.filter(exchange);
        }
        if(token==null) {
            throw new RuntimeException("未登录");
        }
        try {
            LoginUtil.parseToken(token);
        }catch(ExpiredJwtException e) {
            e.printStackTrace();
            throw new RuntimeException("令牌已过期");
        }catch(MalformedJwtException e) {
            e.printStackTrace();
            throw new RuntimeException("令牌不合法");
        }catch(Exception e) {
            throw new RuntimeException("未知错误");
        }
        return chain.filter(exchange);
    }
}
*/
