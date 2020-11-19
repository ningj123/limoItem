package com.woniuxy.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisLock {
    String key() default "";
    int timeOut() default 10;
    int time() default 20;
    String pre() default "";
    int index() default 0;
}
