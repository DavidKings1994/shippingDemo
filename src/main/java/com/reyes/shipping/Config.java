package com.reyes.shipping;

import com.reyes.shipping.cargoDomain.entities.CargoConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean(destroyMethod = "myDestroy", initMethod = "myInit")
    public CargoConfig initializeCargoConfig() {
        return new CargoConfig(10, 100);
    }

    @Bean
    public static CustomBeanFactoryPostProcessor customerBeanFactoryPostProcessor() {
        return new CustomBeanFactoryPostProcessor();
    }

    @Bean
    public static CustomBeanPostProcessor customBeanPostProcessor() {
        return new CustomBeanPostProcessor();
    }
}
