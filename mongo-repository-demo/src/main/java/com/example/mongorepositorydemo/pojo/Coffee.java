package com.example.mongorepositorydemo.pojo;

import lombok.*;
import org.joda.money.Money;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @Description
 * @Author RLY
 * @Date 2019/4/24 11:06
 * @Version 1.0
 **/

@Document
@Data
@Builder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Coffee implements Serializable {

    @Id
    private String id;

    private String name;

    private Money price;
}
