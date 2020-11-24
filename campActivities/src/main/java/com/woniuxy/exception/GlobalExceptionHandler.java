package com.woniuxy.exception;



import com.woniuxy.util.JSONResult;
import com.woniuxy.util.Result;
import io.jsonwebtoken.MalformedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

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


    @ExceptionHandler({MalformedJwtException.class})
    public Result MalformedJwtException(Exception e){
        e.printStackTrace();
        return new Result(500,"取不出token",null);
    }

    //接受参数校验，处理器
    @ExceptionHandler({BindException.class, ValidationException.class})
    public Result handlerBindException(Exception e, BindingResult bindingResult) {
        e.printStackTrace();
        //参数检验的信息放在bindingResult对象里。
        if (bindingResult.hasErrors()) {
            String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
            return Result.fail(defaultMessage);
        }
        return null;
    }

}
