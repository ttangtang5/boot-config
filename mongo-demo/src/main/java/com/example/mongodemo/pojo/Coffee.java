package com.example.mongodemo.pojo;

import lombok.*;
import org.joda.money.Money;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Description
 * @Author RLY
 * @Date 2019/4/29 11:24
 * @Version 1.0
 **/
@Document
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {

    @Id
    private String id;

    private String name;

    private Money price;
}
