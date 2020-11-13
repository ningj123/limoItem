//package com.woniuxy.utils;
//
//import com.woniuxy.annotation.RedisLock;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import java.lang.reflect.Method;
//import java.util.concurrent.TimeUnit;
//
//@Component
//@Aspect
//public class RedissionLock {
//    @Autowired
//    private RedissonClient rc;
//    @Around("execution(* *..service..*.*(..)) && @annotation(com.woniuxy.annotation.RedisLock)")
//    public Object redisLock(ProceedingJoinPoint pjp) throws Throwable {
//        MethodSignature signature =(MethodSignature) pjp.getSignature();
//        Method method = signature.getMethod();
//        RedisLock redisLock = method.getAnnotation(RedisLock.class);
//        RLock lock =null;
//        if (StringUtils.isEmpty(redisLock.key())){
//            lock = rc.getLock(redisLock.pre()+redisLock.index());
//        }else{
//            lock = rc.getLock(redisLock.key());
//        }
//        try {
//            lock.tryLock(redisLock.timeOut(),redisLock.time(), TimeUnit.SECONDS);
//            Thread.sleep(20000);
//            return pjp.proceed();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }finally {
//            lock.unlock();
//        }
//        return null;
//    }
//}
