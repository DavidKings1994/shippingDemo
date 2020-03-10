package com.reyes.shipping.scheduleDomain.valueObjects;

import org.springframework.beans.factory.annotation.Value;

public class DeliveryConfigOptional extends DeliveryConfigInterface {

    @Value("DeliveryConfigOptional")
    private String name;

    public String getName() {
        return name;
    }

}
