package com.tang.backport;

import com.tang.hello.Hello;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.util.ClassUtils;

/**
 * @Description BeanFactoryPostProcessor这个类是spring bean初始化完成后置处理   可以从中是否能获取到类 而判断 是否启动配置
 * @Author RLY
 * @Date 2019/5/23 10:37
 * @Version 1.0
 **/
@Slf4j
public class HelloBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        // 判断是否存在该类
        boolean hasClass = ClassUtils.isPresent("com.tang.hello.Hello", HelloBeanFactoryPostProcessor.class.getClassLoader());
        if (!hasClass) {
            log.info("com.tang.hello.Hello is not present in classpath");
            return;
        }

        // 是否存在bean对象
        boolean hasBean = configurableListableBeanFactory.containsBeanDefinition("hello");
        if (hasBean) {
            log.info("we already have a hello bean registered");
            return;
        }

        // 没有对象注册一个
        register(configurableListableBeanFactory);
    }

    public void register(ConfigurableListableBeanFactory listableBeanFactory) {
        if (listableBeanFactory instanceof BeanDefinitionRegistry) {
            GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
            genericBeanDefinition.setBeanClass(Hello.class);

            ((BeanDefinitionRegistry) listableBeanFactory).registerBeanDefinition("hello", genericBeanDefinition);
        } else {
            listableBeanFactory.registerSingleton("hello", new Hello());
        }

    }
}
