package com.example.exceptiondemo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 异常处理
 * @Author RLY
 * @Date 2019/5/20 16:32
 * @Version 1.0
 **/
@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Map<String, String> nullHandler() {
        Map map = new HashMap();
        map.put("code", "500");
        map.put("message", "nullPoint");
        return map;
    }
}
