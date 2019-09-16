package com.tang.backport;

import com.tang.hello.Hello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description spring 3.0 没有condition注解。将自定义的bean后置处理注入spring context
 * @Author RLY
 * @Date 2019/5/23 10:36
 * @Version 1.0
 **/
@Configuration
public class HelloAutoConfigure {

    @Bean
    public HelloBeanFactoryPostProcessor helloBeanFactoryPostProcessor() {
        return new HelloBeanFactoryPostProcessor();
    }
}
