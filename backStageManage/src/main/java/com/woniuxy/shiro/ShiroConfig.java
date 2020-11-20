//package com.woniuxy.shiro;
//
//
//import com.woniuxy.realm.UserRealm;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@Configuration
//public class ShiroConfig {
//
//    //初始化领域
//    @Bean
//    public UserRealm initRealm(){
//        return new UserRealm();
//    }
//
//    //实例化安全管理器
//    @Bean
//    public SecurityManager initSecurityManager(){
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        //注入领域对象
//        securityManager.setRealm(initRealm());
//        return securityManager;
//    }
//
//
//
//    //实例化Shiro过滤器工厂组件
//    @Bean
//    public ShiroFilterFactoryBean shiroFilter() throws Exception {
//        //实例化Filter工厂
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        //注册securityManager
//        shiroFilterFactoryBean.setSecurityManager(initSecurityManager());
//        //设置Shiro过滤器过滤规则
//        //LinkHashMap是有序的，shiro会根据添加的顺序进行拦截,匹配到过滤器后就执行该过滤器不会在继续向下查找过滤器
//        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
//        //配置不会被拦截地址规则
//        //anon:所有的url都可以不登陆的情况下访问
//        //authc：所有url都必须认证通过才可以访问
////        filterChainDefinitionMap.put("/js/**", "anon");
////        filterChainDefinitionMap.put("/css/**", "anon");
////        filterChainDefinitionMap.put("/img/**", "anon");
////        filterChainDefinitionMap.put("/user/login", "anon");
////        filterChainDefinitionMap.put("/html/login.html", "anon");
////        //如果不满足上方所有的规则 则需要进行登录验证
////        filterChainDefinitionMap.put("/logout", "logout");
////        filterChainDefinitionMap.put("/**", "user");
////
////        //未登录时重定向的网页地址
////        shiroFilterFactoryBean.setLoginUrl("/html/login.html");
//        //将地址过滤规则设置到Filter工厂中
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        //返回
//        return shiroFilterFactoryBean;
//    }
//
//}
