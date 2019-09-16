package com.example.jpademo.dao;

import com.example.jpademo.pojo.CoffeeOrder;
import org.springframework.data.repository.CrudRepository;

/**
 * @Description
 * @Author RLY
 * @Date 2019/4/24 10:02
 * @Version 1.0
 **/
public interface CoffeeOrderDao extends CrudRepository<CoffeeOrder, Long> {
}
