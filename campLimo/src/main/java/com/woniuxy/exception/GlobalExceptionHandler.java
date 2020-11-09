package com.woniuxy.exception;

import com.woniuxy.util.JSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ErrorException.class})
    public JSONResult error(Exception e){
        e.printStackTrace();
        return new JSONResult("406",e.getMessage(),null,null);
    }
}
