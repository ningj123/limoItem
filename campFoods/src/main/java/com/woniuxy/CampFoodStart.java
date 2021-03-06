package com.woniuxy;

import com.woniuxy.util.JSONResult;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.woniuxy.mapper")
@EnableSwagger2
@EnableFeignClients("com.woniuxy.client")
public class CampFoodStart
{
    public static void main( String[] args )
    {
        SpringApplication.run(CampFoodStart.class,args);
    }

}
