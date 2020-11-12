package com.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName config
 * @Author shadow
 * @Date 2020/11/9 15:32
 * @Description TODO
 **/
@Configuration
public class Config {
    @Bean
    public IRule createIRule() {
        return new WeightRule();
    }
}
