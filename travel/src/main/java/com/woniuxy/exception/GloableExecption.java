package com.woniuxy.exception;


import com.woniuxy.util.JSONResult;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhuyuli
 * @description: 全局异常处理
 * @date: 2020/11/9 9:23
 */

@RestControllerAdvice
public class GloableExecption {
    @ExceptionHandler(TravelExecption.class)
    public JSONResult TravelExecptionHandler(Exception e){
        e.printStackTrace();
        return new JSONResult("500",e.getMessage(),null,null);
    }
    @ExceptionHandler(MalformedJwtException.class)
    public JSONResult MalformedJwtExceptionHandler(Exception e){
        e.printStackTrace();
        return new JSONResult("500","token解析失败",null,null);
    }
}
