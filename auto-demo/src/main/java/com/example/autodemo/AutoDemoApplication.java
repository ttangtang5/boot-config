package com.example.autodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.tang", "com.example"})
public class AutoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoDemoApplication.class, args);
    }

}
