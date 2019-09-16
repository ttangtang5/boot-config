package com.example.redisdemo;

import com.example.redisdemo.pojo.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@SpringBootApplication
@Slf4j
public class RedisDemoApplication implements CommandLineRunner {

    @Autowired
    private JedisPool jedisPool;

    public static void main(String[] args) {
        SpringApplication.run(RedisDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//		Coffee latte = Coffee.builder().name("latte")
//				.price(Money.of(CurrencyUnit.of("CNY"), 20.0))
//				.build();
//
//
//		Jedis jedis = jedisPool.getResource();
        //jedis.set("coffee", latte);
    }

}

