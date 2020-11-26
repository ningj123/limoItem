package com.woniuxy;

import com.woniuxy.filter.CrosFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.Filter;

/**
 * Hello world!
 *
 */
@MapperScan("com.woniuxy.dao")
@EnableSwagger2
@SpringBootApplication
public class UserApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(UserApp.class,args);
    }

    //注册过滤器
    @Bean
    public FilterRegistrationBean<Filter> initFilterRegister(){
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<Filter>();
        registration.setFilter(new CrosFilter());
        registration.addUrlPatterns("/*");
        registration.setName("CrosFilter");
        registration.setOrder(1);
        return registration;
    }
}
