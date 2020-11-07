package com.woniuxy.exception;



import com.woniuxy.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public Result handler (RuntimeException e){
        log.error("运行时异常：-----------------{}",e);
        return  new Result(401,e.getMessage(),null);
    }


    @ExceptionHandler({IncorrectCredentialsException.class})
    public Result handlerIncorrectCredentialsException(Exception e){
        e.printStackTrace();
        return new Result(500,"密码错误",null);
    }


    @ExceptionHandler({UnknownAccountException.class})
    public Result handlerUnknownAccountException(Exception e){
        e.printStackTrace();
        return new Result(500,"用户名不存在",null);
    }



}
