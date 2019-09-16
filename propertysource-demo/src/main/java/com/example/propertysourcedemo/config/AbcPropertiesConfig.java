package com.example.propertysourcedemo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

/**
 * @Description 手动添加配置文件至项目实现EnvironmentPostProcessor 或 BeanFactoryPostProcessor
 * @Author RLY
 * @Date 2019/5/23 14:02
 * @Version 1.0
 **/
public class AbcPropertiesConfig implements EnvironmentPostProcessor {

    private PropertiesPropertySourceLoader loader = new PropertiesPropertySourceLoader();

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        MutablePropertySources propertySources = environment.getPropertySources();
        Resource resource = new ClassPathResource("abc.properties");

        try {
            PropertySource otherProperties = loader.load("otherProperties", resource).get(0);
            propertySources.addFirst(otherProperties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
