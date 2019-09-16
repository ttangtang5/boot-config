package com.example.complexresttemplatedemo.pojo;

import lombok.*;
import org.joda.money.Money;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/21 15:52
 * @Version 1.0
 **/
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {


    private String name;

    private Money price;
}
