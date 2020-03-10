package com.reyes.shipping;

import com.reyes.shipping.cargoDomain.entities.CargoConfig;
import com.reyes.shipping.scheduleDomain.valueObjects.DeliveryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {

    @Bean
    @Primary
    DeliveryConfig deliveryConfig() {
        return new DeliveryConfig();
    }

    @Bean
    DeliveryConfig deliveryConfiginitialized() {
        return new DeliveryConfig(1000, "6:00", "12:00");
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
