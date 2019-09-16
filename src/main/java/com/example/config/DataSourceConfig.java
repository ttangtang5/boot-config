package com.example.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Description
 * @Author RLY
 * @Date 2019/4/18 12:43
 * @Version 1.0
 **/
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("custom.datasource")
    public DataSourceProperties setDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource setDataSource() {
        DataSourceProperties dataSourceProperties = this.setDataSourceProperties();
        System.out.println("datasource:" + dataSourceProperties.getUrl());
        HikariDataSource build = dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
        return build;
    }

}
