package com.example.autodemo.config;

import com.tang.hello.Hello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/22 17:26
 * @Version 1.0
 **/
@Configuration
public class BeanConfig {

    @Bean
    public Hello hello() {
        return new Hello("spring boot");
    }
}
