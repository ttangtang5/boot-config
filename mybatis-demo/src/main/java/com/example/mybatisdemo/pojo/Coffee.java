package com.example.mybatisdemo.pojo;

import lombok.*;
import org.joda.money.Money;

/**
 * @Description
 * @Author RLY
 * @Date 2019/4/26 10:36
 * @Version 1.0
 **/
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {

    private Long id;

    private String name;

    private Money price;
}
