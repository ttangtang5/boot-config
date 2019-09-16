package com.example.complexresttemplatedemo.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/21 15:50
 * @Version 1.0
 **/
@Configuration
public class BeanConfig {

    @Bean
    public RestTemplate setRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
