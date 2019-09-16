package com.example.webclientdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/22 9:47
 * @Version 1.0
 **/
@Configuration
public class BeanConfig {

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.build();
    }
}
