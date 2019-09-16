package com.example.jpademo;

import com.example.jpademo.dao.CoffeeDao;
import com.example.jpademo.dao.CoffeeOrderDao;
import com.example.jpademo.pojo.Coffee;
import com.example.jpademo.pojo.CoffeeOrder;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.jpademo.dao"})
@Slf4j
public class JpaDemoApplication implements CommandLineRunner {

    @Autowired
    private CoffeeDao coffeeDao;

    @Autowired
    private CoffeeOrderDao coffeeOrderDao;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.insertOrder();
    }

    public void insertOrder() {
        Coffee espresso = Coffee.builder().name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .build();
        coffeeDao.save(espresso);
        log.info("Coffee: {}", espresso);

        Coffee latte = Coffee.builder().name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .build();
        coffeeDao.save(latte);
        log.info("Coffee: {}", latte);

        CoffeeOrder order = CoffeeOrder.builder()
                .customer("Li Lei")
                .items(Collections.singletonList(espresso))
                .state(0)
                .build();
        coffeeOrderDao.save(order);
        log.info("Order: {}", order);

        order = CoffeeOrder.builder()
                .customer("Li Lei")
                .items(Arrays.asList(espresso, latte))
                .state(0)
                .build();
        coffeeOrderDao.save(order);
        log.info("Order: {}", order);
    }
}
