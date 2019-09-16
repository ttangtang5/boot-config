package com.example.redisdemo.pojo;

import lombok.*;
import org.joda.money.Money;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author RLY
 * @Date 2019/4/29 16:24
 * @Version 1.0
 **/
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Coffee implements Serializable {

    private Long id;

    private String name;

    private Money price;

    private Date createTime;

    private Date updateTime;
}
