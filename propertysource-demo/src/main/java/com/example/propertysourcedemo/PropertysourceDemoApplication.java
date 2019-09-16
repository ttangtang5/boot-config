package com.example.propertysourcedemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource("classpath:abc.properties")
public class PropertysourceDemoApplication implements ApplicationRunner {

    @Value("${abc.name}")
    private String name;

    public static void main(String[] args) {
        SpringApplication.run(PropertysourceDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(name);
    }
}
