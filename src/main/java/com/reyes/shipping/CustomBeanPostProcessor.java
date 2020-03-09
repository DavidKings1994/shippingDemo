package com.reyes.shipping;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().getSimpleName().equals("CargoConfig"))
        System.out.println("postProcessBeforeInitialization on " + bean.getClass().getSimpleName());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().getSimpleName().equals("CargoConfig"))
        System.out.println("postProcessAfterInitialization on " + bean.getClass().getSimpleName());
        return bean;
    }
}
