package com.woniuxy.utils;


import com.woniuxy.annotation.RedisLock;
import com.woniuxy.param.OrdersParam;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Component
@Aspect
public class RedissionLock {
    @Autowired
    private RedissonClient rc;
    @Around("execution(* *..service..*.*(..)) && @annotation(com.woniuxy.annotation.RedisLock)")
    public Object redissionLock(ProceedingJoinPoint pjp) {
        MethodSignature signature =(MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        RedisLock redisLock = method.getDeclaredAnnotation(RedisLock.class);
        System.out.println(redisLock);
        RLock lock =null;
        try {
            if (StringUtils.isEmpty(redisLock.key())){
                lock = rc.getLock(redisLock.pre()+redisLock.index());
            }else{
                lock = rc.getLock(redisLock.key());
            }
            lock.tryLock(redisLock.timeOut(),redisLock.time(), TimeUnit.SECONDS);
            return pjp.proceed();
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            if (lock!=null){
                lock.unlock();
            }
        }
        return null;
    }
}
