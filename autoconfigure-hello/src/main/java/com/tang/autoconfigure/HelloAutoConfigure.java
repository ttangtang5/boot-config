package com.tang.autoconfigure;

import com.tang.hello.Hello;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/22 16:55
 * @Version 1.0
 **/
@Configuration
@ConditionalOnClass(value = Hello.class)
public class HelloAutoConfigure {

    @Bean
    @ConditionalOnMissingBean(value = Hello.class)
    @ConditionalOnProperty(name = "hello.enable", havingValue = "true", matchIfMissing = true)
    public Hello hello() {
        return new Hello();
    }
}
