package com.woniuxy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName RegisterFilter
 * @Author shadow
 * @Date 2020/11/17 14:42
 * @Description TODO
 **/
//@WebFilter
public class RegisterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse resp=(HttpServletResponse) response;
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization,x-token");
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 支持HTTP 1.1.
        resp.setHeader("Pragma", "no-cache"); // 支持HTTP 1.0. response.setHeader("Expires", "0");
        chain.doFilter(request, response);
    }
}
