package com.example.mongorepositorydemo;

import com.example.mongorepositorydemo.converter.MoneyTypeConverter;
import com.example.mongorepositorydemo.dao.CoffeeRepository;
import com.example.mongorepositorydemo.pojo.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"com.example.mongorepositorydemo.dao"})
@Slf4j
public class MongoRepositoryDemoApplication implements ApplicationRunner {

    @Autowired
    private CoffeeRepository coffeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoRepositoryDemoApplication.class, args);
    }

    @Bean
    public MongoCustomConversions setMoneyConverter() {
        MongoCustomConversions customConversions = new MongoCustomConversions(Arrays.asList(new MoneyTypeConverter()));
        return customConversions;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Coffee espresso = Coffee.builder()
                .name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .build();
        Coffee latte = Coffee.builder()
                .name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .build();

        List<Coffee> insert = coffeeRepository.insert(Arrays.asList(espresso, latte));

        coffeeRepository.findAll(Sort.by("name")).forEach(o -> log.info("find:{}", o.toString()));

        Thread.sleep(1000);
        latte.setPrice(Money.of(CurrencyUnit.of("CNY"), 35.0));
        coffeeRepository.save(latte);
        coffeeRepository.findByName("latte")
                .forEach(c -> log.info("name {}", c));

        coffeeRepository.deleteAll();
    }
}
