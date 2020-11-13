package com.woniuxy.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.nio.charset.Charset;

/**
 * @author zhuyuli
 * @description: 配置类
 * @date: 2020/11/9 9:48
 */
@Configuration
public class Config {
    
    /**
     * @Author zhuyuli
     * @Description 创建mybatisPlus分页插件
     * @Date 2020/11/9 9:50
     * @return MybatisPlusInterceptor
     **/
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
    /**
     * @Author zhuyuli
     * @Description 封装redis的hash
     * @Date 2020/11/11 14:37
     * @Param [ref]
     * @return org.springframework.data.redis.core.RedisTemplate<java.lang.String,java.lang.Object>
     **/
    @Bean
    public RedisTemplate<String, Object> creatRT(RedisConnectionFactory ref){

        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(ref);
        StringRedisSerializer stringserializer = new StringRedisSerializer(Charset.forName("utf-8"));
        template.setKeySerializer(stringserializer);
        Jackson2JsonRedisSerializer<Object> jsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        template.setValueSerializer(jsonRedisSerializer);
        template.setHashKeySerializer(stringserializer);
        template.setHashValueSerializer(jsonRedisSerializer);

        return template;
    }
}
