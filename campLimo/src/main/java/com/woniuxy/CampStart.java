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
//@ServletComponentScan("com.woniuxy.cq.soft.filter")
//@ImportResource("classpath:transaction.xml")
@EnableSwagger2
public class CampStart
{
    public static void main( String[] args )
    {
        SpringApplication.run(CampStart.class,args);
    }
}
