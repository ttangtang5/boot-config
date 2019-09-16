package com.example.pagehelperdemo.mapper;

import com.example.pagehelperdemo.pojo.Coffee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @Description 通过PageHelper 直接传入如下两种参数  在sql不用处理该参数。
 * @Author RLY
 * @Date 2019/4/26 15:44
 * @Version 1.0
 **/
public interface CoffeeDao {

    @Select("select * from t_menu")
    List<Coffee> findList(RowBounds rowBounds);

    @Select("select * from t_menu")
    List<Coffee> findList2(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}