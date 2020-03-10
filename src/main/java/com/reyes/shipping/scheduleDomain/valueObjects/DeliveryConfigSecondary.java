package com.reyes.shipping.scheduleDomain.valueObjects;

import org.springframework.beans.factory.annotation.Value;

public class DeliveryConfigSecondary extends DeliveryConfigInterface {

    @Value("DeliveryConfigSecondary")
    private String name;

    public String getName() {
        return name;
    }
}
