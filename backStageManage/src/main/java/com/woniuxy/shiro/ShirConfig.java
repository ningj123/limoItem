package com.woniuxy.shiro;

import com.woniuxy.realm.ManageRealm;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName ShirConfig
 * @Author shadow
 * @Date 2020/11/12 16:05
 * @Description TODO
 **/
@Configuration
public class ShirConfig {
    @Bean
    public ManageRealm initRealm(){
        return new ManageRealm();
    }
    @Bean
    public SecurityManager initSecurityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(initRealm());
        securityManager.setRememberMeManager(rememberManager());
        return securityManager;
    }
    @Bean
    public CookieRememberMeManager rememberManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        SimpleCookie cookie = new SimpleCookie("shadow");
        cookie.setMaxAge(7*32*60*60);
        cookieRememberMeManager.setCookie(cookie);
        cookieRememberMeManager.setCipherKey(Base64.decode("potentialshadow9201314=="));
        return cookieRememberMeManager;
    }
    @Bean
    public ShiroFilterFactoryBean shirFilter() throws UnsupportedEncodingException {
        //实例化Filter工厂
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //注册securityManager
        shiroFilterFactoryBean.setSecurityManager(initSecurityManager());
        //设置Shiro过滤器过滤规则
        //LinkHashMap是有序的，shiro会根据添加的顺序进行拦截,匹配到过滤器后就执行该过滤器不会在继续向下查找过滤器
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        //配置不会被拦截地址规则
        //anon:所有的url都可以不登陆的情况下访问
        //authc：所有url都必须认证通过才可以访问
        filterChainDefinitionMap.put("/*", "anon");
//        filterChainDefinitionMap.put("/page/login.html", "anon");
//        filterChainDefinitionMap.put("/page/user/login.html", "anon");
//        filterChainDefinitionMap.put("/page/user/index.html", "anon");
//        filterChainDefinitionMap.put("/js/**", "anon");
//        filterChainDefinitionMap.put("/css/**", "anon");
//        filterChainDefinitionMap.put("/img/**", "anon");
//        filterChainDefinitionMap.put("/employees/login", "anon");
//        filterChainDefinitionMap.put("/user/login", "anon");
//        filterChainDefinitionMap.put("/user/register", "anon");
//        filterChainDefinitionMap.put("/menu/user", "anon");
//        //如果不满足上方所有的规则 则需要进行登录验证
//        filterChainDefinitionMap.put("/logout", "logout");
//        filterChainDefinitionMap.put("/**", "user");

        //未登录时重定向的网页地址
        shiroFilterFactoryBean.setLoginUrl("/page/login.html");
        //将地址过滤规则设置到Filter工厂中
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //返回
        return shiroFilterFactoryBean;
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(initSecurityManager());
        return advisor;
    }
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator app=new DefaultAdvisorAutoProxyCreator();
        app.setProxyTargetClass(true);
        return app;
    }
}