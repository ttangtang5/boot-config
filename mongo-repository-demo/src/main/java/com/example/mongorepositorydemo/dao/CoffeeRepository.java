package com.example.mongorepositorydemo.dao;

import com.example.mongorepositorydemo.pojo.Coffee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Description
 * @Author RLY
 * @Date 2019/4/29 14:25
 * @Version 1.0
 **/
public interface CoffeeRepository extends MongoRepository<Coffee, String> {

    List<Coffee> findByName(String name);
}
