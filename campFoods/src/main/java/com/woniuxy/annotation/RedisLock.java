package com.woniuxy.annotation;

public @interface RedisLock {
    String key() default "";
    int timeOut() default 10;
    int time() default 20;
    String pre() default "";
    int index() default 0;
}
