package com.woniuxy.configuration;

import com.config.Config;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName Configurat
 * @Author shadow
 * @Date 2020/11/9 19:22
 * @Description TODO
 **/
@Configuration
@RibbonClients(defaultConfiguration = Config.class)
public class Configurat {
    @LoadBalanced
    @Bean
    public RestTemplate userTest() {
        return new RestTemplate();
    }
}
