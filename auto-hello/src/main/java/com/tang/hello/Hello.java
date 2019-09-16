package com.tang.hello;

import org.springframework.boot.CommandLineRunner;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/22 16:49
 * @Version 1.0
 **/
public class Hello implements CommandLineRunner {

    public Hello() {
        System.out.println("Initializing Hello");
    }

    public Hello(String hello) {
        System.out.println("Initializing " + hello);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello spring boot");
    }
}
