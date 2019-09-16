package com.example.demo;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariJNDIFactory;
import com.zaxxer.hikari.util.DriverDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Description CommandLineRunner接口主要用于实现在应用初始化后，去执行一段代码块逻辑，这段初始化代码在整个应用生命周期内只会执行一次。
 * @Author RLY
 * @Date 2019/4/17 9:17
 * @Version 1.0
 **/
@Component
public class Test implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    //@Bean
    public DataSource setDataSource() {
        DataSource dataSource = new DriverDataSource("jdbc:h2:mem:testdb", "org.h2.Driver", new Properties(), "saa", "123");
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDataSource(dataSource);

//        DataSourceProperties dataSourceProperties = new DataSourceProperties();
//        HikariDataSource hikariDataSource1 = dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
        return hikariDataSource;
    }
}
