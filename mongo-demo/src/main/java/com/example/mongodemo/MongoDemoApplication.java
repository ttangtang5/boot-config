package com.example.mongodemo;

import com.example.mongodemo.converter.MoneyTypeConverter;
import com.example.mongodemo.pojo.Coffee;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class MongoDemoApplication implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(MongoDemoApplication.class, args);
    }

    @Bean
    public MongoCustomConversions setMoneyConversions() {
        MongoCustomConversions mongoCustomConversions = new MongoCustomConversions(Arrays.asList(new MoneyTypeConverter()));
        return mongoCustomConversions;
    }

    @Override
    public void run(String... args) throws Exception {
        Coffee latte = Coffee.builder().name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .build();

        Coffee save = mongoTemplate.save(latte);

        mongoTemplate.findAll(Coffee.class).forEach(o -> log.info("coffee: {}", o.toString()));

        mongoTemplate.find(Query.query(Criteria.where("name").is("latte")), Coffee.class)
                .forEach(o -> log.info("find: {}", o.toString()));

        //更新
        UpdateResult upsert = mongoTemplate.upsert(Query.query(Criteria.where("name").is("latte")), Update.update("name", "updatevalue"), Coffee.class);

        log.info("Update Result: {}", upsert.getModifiedCount());
        Coffee updateOne = mongoTemplate.findById(save.getId(), Coffee.class);
        log.info("Update Result: {}", updateOne);

        //mongoTemplate.remove(updateOne);
    }
}
