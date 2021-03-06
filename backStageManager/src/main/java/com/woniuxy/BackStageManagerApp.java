package com.woniuxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.woniuxy.mapper")
@EnableSwagger2
public class BackStageManagerApp
{
    public static void main( String[] args ) {

        SpringApplication.run(BackStageManagerApp.class,args);
    }
}
