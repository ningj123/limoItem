package com.woniuxy.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName Configurat
 * @Author shadow
 * @Date 2020/11/9 21:47
 * @Description TODO
 **/
@Configuration
public class Configurat {
    @LoadBalanced
    @Bean
    public RestTemplate userTest() {
        return new RestTemplate();
    }
}
