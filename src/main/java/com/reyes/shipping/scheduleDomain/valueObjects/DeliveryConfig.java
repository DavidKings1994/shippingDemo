package com.reyes.shipping.scheduleDomain.valueObjects;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class DeliveryConfig {

    @Value("#{initializeCargoConfig.maxWeight * initializeCargoConfig.pricePerTon}")
    private float maxPrice;

    @Value("9:00")
    private String workStartTime;

    private String workEndTime;

    public DeliveryConfig() {
    }

    public DeliveryConfig(float maxPrice, String workStartTime, String workEndTime) {
        this.maxPrice = maxPrice;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public String getWorkStartTime() {
        return workStartTime;
    }

    public String getWorkEndTime() {
        return workEndTime;
    }
}
