package com.example.exceptiondemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/20 16:10
 * @Version 1.0
 **/
//@ResponseStatus(HttpStatus.BAD_REQUEST) //设定抛出此异常时 请求状态码设定
public class GlobalException extends RuntimeException {

    private String code;

    private String message;

    public GlobalException() {

    }

    public GlobalException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public GlobalException setCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public GlobalException setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "GlobalException{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
