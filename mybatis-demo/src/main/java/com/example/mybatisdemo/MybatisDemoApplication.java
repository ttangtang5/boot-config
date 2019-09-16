package com.example.mybatisdemo;

import com.example.mybatisdemo.dao.CoffeeDao;
import com.example.mybatisdemo.pojo.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.mybatisdemo.dao"})
@Slf4j
public class MybatisDemoApplication implements ApplicationRunner {

    @Autowired
    private CoffeeDao coffeeDao;

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Coffee coffee = Coffee.builder().name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 20))
                .build();

        long insert = coffeeDao.insert(coffee);
        System.out.println(insert);
        log.info("coffee: {}", coffee);

        Coffee byId = coffeeDao.findById(1L);

        log.info("find: {}", byId);
    }
}
