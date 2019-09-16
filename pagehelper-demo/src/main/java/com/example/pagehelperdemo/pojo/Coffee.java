package com.example.pagehelperdemo.pojo;

import lombok.*;
import org.joda.money.Money;

import java.util.Date;

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

    private Date createTime;

    private Date updateTime;
}
