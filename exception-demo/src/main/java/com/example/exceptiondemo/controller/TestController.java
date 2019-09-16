package com.example.exceptiondemo.controller;

import com.example.exceptiondemo.exception.GlobalException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/20 16:08
 * @Version 1.0
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("exception")
    public String test() {
        //throw new GlobalException("200", "全局异常 mvc自行处理");
        String str = null;
        //str.toString();
        return "";
    }

}
