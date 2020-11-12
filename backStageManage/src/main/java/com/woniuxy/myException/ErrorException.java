package com.woniuxy.myException;
import javax.validation.ValidationException;

import com.woniuxy.util.JSONResult;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName ErrorException
 * @Author shadow
 * @Date 2020/11/12 10:11
 * @Description TODO
 **/
@RestControllerAdvice
public class ErrorException {
    @ExceptionHandler({BindException.class,ValidationException.class})
    public JSONResult dataExceptionDatil(Exception e){
        e.printStackTrace();
        return new JSONResult("500", "参数异常", null, null);
    }
    @ExceptionHandler({UnknownAccountException.class})
    public JSONResult unknownAccountException(Exception e) {
        e.printStackTrace();
        return new JSONResult("500", "用户不存在", null, null);
    }
    @ExceptionHandler({IncorrectCredentialsException.class})
    public JSONResult incorrectCredentialsException(Exception e) {
        e.printStackTrace();
        return new JSONResult("500", "密码错误", null, null);
    }
    @ExceptionHandler({AuthorizationException.class})
    public JSONResult authorizationException(Exception e) {
        e.printStackTrace();
        return new JSONResult("500", "权限不足", null, null);
    }
    @ExceptionHandler({Exception.class})
    public JSONResult exceptionDetail(Exception e) {
        e.printStackTrace();
        return new JSONResult("500", "服务器异常", null, null);
    }
}
