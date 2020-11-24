package com.woniuxy.config;

import feign.Feign;
import feign.Logger;
import feign.Retryer;
import feign.querymap.BeanQueryMapEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 当你的参数对象是有父类的时候，你会发现父类的属性是没有被映射过来的，只传递了对象本身的属性值。
 * 然后在FeignClient上去配置即可。
 */
@Configuration
public class FeginConfiguration {
    /**
     * @Description
     * @date 2019/5/21 17:27
     * @version V1.0.0
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        //这里记录所有，根据实际情况选择合适的日志level
        return Logger.Level.FULL;
    }

    /**
     * @Description 替换解析queryMap的类，实现父类中变量的映射
     * @date 2019/5/21 16:59
     * @version V1.0.0
     */
    @Bean
    public Feign.Builder feignBuilder() {
        return Feign.builder()
                .queryMapEncoder(new BeanQueryMapEncoder())
                .retryer(Retryer.NEVER_RETRY);
    }
}
