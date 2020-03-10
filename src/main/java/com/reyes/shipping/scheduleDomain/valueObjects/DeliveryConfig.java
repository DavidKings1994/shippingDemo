package com.reyes.shipping.scheduleDomain.valueObjects;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class DeliveryConfig extends DeliveryConfigInterface {

    @Value("DeliveryConfig")
    private String name;

    public String getName() {
        return name;
    }

}
