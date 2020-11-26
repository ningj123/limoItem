package com.woniuxy.exception;


import com.woniuxy.util.JSONResult;
import io.jsonwebtoken.MalformedJwtException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhuyuli
 * @description: 全局异常处理
 * @date: 2020/11/9 9:23
 */

@RestControllerAdvice
public class GloableExecption {
    @ExceptionHandler(BackExecption.class)
    public JSONResult TravelExecptionHandler(Exception e){
        e.printStackTrace();
        return new JSONResult("500",e.getMessage(),null,null);
    }

    @ExceptionHandler({IncorrectCredentialsException.class})
    public JSONResult handlerIncorrectCredentialsException(Exception e){
        e.printStackTrace();
        return new JSONResult("500","密码错误",null,null);
    }


    @ExceptionHandler({UnknownAccountException.class})
    public JSONResult handlerUnknownAccountException(Exception e){
        e.printStackTrace();
        return new JSONResult("500","用户名不存在",null,null);
    }
}
