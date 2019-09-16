package com.example.jpacomplexdemo;

import com.example.jpacomplexdemo.dao.CoffeeDao;
import com.example.jpacomplexdemo.dao.CoffeeOrderDao;
import com.example.jpacomplexdemo.pojo.Coffee;
import com.example.jpacomplexdemo.pojo.CoffeeOrder;
import com.example.jpacomplexdemo.pojo.OrderState;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.jpacomplexdemo.dao"})
@EnableTransactionManagement
@Slf4j
public class JpaComplexDemoApplication implements ApplicationRunner {

    @Autowired
    private CoffeeDao coffeeDao;

    @Autowired
    private CoffeeOrderDao coffeeOrderDao;

    public static void main(String[] args) {
        SpringApplication.run(JpaComplexDemoApplication.class, args);
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        this.initOrders();
        this.findOrder();
    }

    public void initOrders() {
        Coffee coffee_1 = Coffee.builder().name("coffee_1")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .build();
        coffeeDao.save(coffee_1);
        log.info("coffee: {}", coffee_1);

        Coffee coffee_2 = Coffee.builder().name("coffee_2")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .build();
        coffeeDao.save(coffee_2);
        log.info("coffee: {}", coffee_2);

        CoffeeOrder order_1 = CoffeeOrder.builder().customer("张三")
                .items(Arrays.asList(coffee_1))
                .state(OrderState.BREWED)
                .build();
        coffeeOrderDao.save(order_1);
        log.info("order: {}", order_1);

        CoffeeOrder order_2 = CoffeeOrder.builder().customer("李四")
                .items(Arrays.asList(coffee_1, coffee_2))
                .state(OrderState.BREWED)
                .build();
        coffeeOrderDao.save(order_2);
        log.info("order: {}", order_2);
    }

    public void findOrder() {
        // 不开启事务会因为没Session而报LazyInitializationException 或在多对多出设置为急加载
        coffeeOrderDao.findAll().forEach(o -> log.info("order: {}", o));

        //coffeeOrderDao.findTop3ByOrderByUpdateTimeDescIdAsc().forEach(o -> log.info("top: {}", o));
        List<CoffeeOrder> lists = coffeeOrderDao.findTop3ByOrderByUpdateTimeDescIdAsc();
        log.info("findByCustomerOrderById: {}", getJoinedOrderId(lists));

        coffeeOrderDao.findByCustomer("张三").forEach(o -> log.info("张三order：{}", o));

        coffeeOrderDao.findByItems_Name("coffee_2").forEach(o -> log.info("exist coffee_2 order: {}", o));
    }

    /**
     * java8中的的stream集合 获取list中对象id 拼接成字符串
     *
     * @param list
     * @return
     */
    private String getJoinedOrderId(List<CoffeeOrder> list) {
        return list.stream().map(o -> o.getId().toString())
                .collect(Collectors.joining(","));
    }
}
