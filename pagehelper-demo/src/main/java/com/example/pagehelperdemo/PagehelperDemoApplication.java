package com.example.pagehelperdemo;

import com.example.pagehelperdemo.mapper.CoffeeDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.money.MoneyUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@MapperScan(basePackages = {"com.example.pagehelperdemo.mapper"})
public class PagehelperDemoApplication implements ApplicationRunner {

    @Autowired
    private CoffeeDao coffeeDao;

    public static void main(String[] args) {
        SpringApplication.run(PagehelperDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Money total = Money.total(CurrencyUnit.of("CNY"), Money.of(CurrencyUnit.of("CNY"), 0.01), Money.of(CurrencyUnit.of("CNY"), 100));
        System.out.println(MoneyUtils.add(Money.of(CurrencyUnit.of("CNY"), 0.01), Money.of(CurrencyUnit.of("CNY"), 100)).toString());
        System.out.println(total.toString());
        System.out.println(total.getAmount().toString());
        System.out.println(total.getAmount().toPlainString());
        System.out.println(total.getAmount().toEngineeringString());
        System.out.println(total.getAmountMinorLong());
//		RowBounds rowBounds = new RowBounds(1, 2);
//
//		coffeeDao.findList(rowBounds).forEach(o -> {
//			log.info("rowBounds: {}", o.toString());
//		});
//
//		coffeeDao.findList2(2, 2).forEach(o -> {
//			log.info("param: {}", o.toString());
//		});
    }
}
