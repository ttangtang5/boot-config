package com.example.jpacomplexdemo.dao;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Description 相当于你在使用spring data jpa 的时候，每个实体类有需要实现的相同的方法，就可以单独抽取出来，
 * 放在一个公共的接口MyRepository中，并这个类继承了jpa的相关Repository接口或类，
 * 由MyRepository接口来衔接jpa的相关操作，其他实体类需要实现的操作就直接继承MyRepository接口，
 * 不用每次都去继承jpa的相关接口或类啦，所以这个公共接口就需要这个注解@NoRepositoryBean来标识
 * @Author RLY
 * @Date 2019/4/24 11:31
 * @Version 1.0
 **/
@NoRepositoryBean
public interface BaseEntityDao<T, Long> extends PagingAndSortingRepository<T, Long> {


}
