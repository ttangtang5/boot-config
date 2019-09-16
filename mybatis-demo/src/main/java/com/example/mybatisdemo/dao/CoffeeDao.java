package com.example.mybatisdemo.dao;

import com.example.mybatisdemo.handler.MoneyTypeHandler;
import com.example.mybatisdemo.pojo.Coffee;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.joda.money.Money;

/**
 * @Description
 * @Author RLY
 * @Date 2019/4/26 10:40
 * @Version 1.0
 **/
@Mapper
public interface CoffeeDao {

    @Insert("insert into t_menu(id, name, price) values(#{id}, #{name}, #{price})")
    @Options(useGeneratedKeys = true)
    Long insert(Coffee coffee);

    @Select("select * from t_menu where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
    })
    Coffee findById(@Param("id") Long id);
}
