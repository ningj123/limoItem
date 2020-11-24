package com.woniuxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.woniuxy.mapper")
public class BackStageManagerApp
{
    public static void main( String[] args ) {

        SpringApplication.run(BackStageManagerApp.class,args);
    }
}
