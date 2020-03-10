package com.reyes.shipping;

import com.reyes.shipping.cargoDomain.entities.CargoConfig;
import com.reyes.shipping.scheduleDomain.valueObjects.DeliveryConfig;
import com.reyes.shipping.scheduleDomain.valueObjects.DeliveryConfigInterface;
import com.reyes.shipping.scheduleDomain.valueObjects.DeliveryConfigOptional;
import com.reyes.shipping.scheduleDomain.valueObjects.DeliveryConfigSecondary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {

    @Bean

    DeliveryConfigInterface deliveryConfig() {
        return new DeliveryConfig();
    }

    @Bean
    @Primary
    //@Scope("prototype")
    DeliveryConfigInterface deliveryConfigSecondary() {
        DeliveryConfigSecondary config = new DeliveryConfigSecondary();
        config.setWorkStartTime("6:00");
        System.out.println("Instance 1: " + config);
        return config;
    }

    @Bean
    DeliveryConfigInterface deliveryConfigOptional() {
        return new DeliveryConfigOptional();
    }

    @Bean(destroyMethod = "myDestroy", initMethod = "myInit")
    public CargoConfig initializeCargoConfig() {
        return new CargoConfig(10, 100);
    }


    public CargoConfig secondaryCargoBean() {
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
