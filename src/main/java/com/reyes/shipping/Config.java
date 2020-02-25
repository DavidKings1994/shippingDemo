package com.reyes.shipping;

import com.reyes.shipping.modelos.Orden;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean(destroyMethod = "myDestroy", initMethod = "myInit")
    public Orden initializeOrden() {
        return new Orden(0, "prueba");
    }

}
