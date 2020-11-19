package com.woniuxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.woniuxy.mapper")
@EnableSwagger2
@EnableFeignClients(basePackages = "com.woniuxy.client")
public class TravelStart
{
    public static void main( String[] args )
    {
        SpringApplication.run(TravelStart.class,args);

    }
}
