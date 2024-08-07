package com.kjb.exception;

import com.kjb.retutnformat.ReturnCodeEnum;
import com.kjb.retutnformat.ReturnData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author kjb~
 * @version 1.0.0
 */

//@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  // 响应的状态码是：500状态码
    public ReturnData<String> getException(Exception e) {
        System.out.println("发生异常： " + e.getMessage());
        log.error("发生异常： " + e.getMessage());
        return ReturnData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }

}
