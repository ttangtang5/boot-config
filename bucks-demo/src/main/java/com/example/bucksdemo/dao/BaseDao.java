package com.example.bucksdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @Description
 * @Author RLY
 * @Date 2019/4/28 14:52
 * @Version 1.0
 **/
@NoRepositoryBean
public interface BaseDao<T, ID> extends JpaRepository<T, ID> {
}
