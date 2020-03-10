package com.reyes.shipping.scheduleDomain.valueObjects;

import org.springframework.beans.factory.annotation.Value;

public abstract class DeliveryConfigInterface {

    @Value("#{initializeCargoConfig.maxWeight * initializeCargoConfig.pricePerTon}")
    private float maxPrice;

    @Value("9:00")
    private String workStartTime;

    private String workEndTime;

    public float getMaxPrice() {
        return maxPrice;
    }

    public String getWorkStartTime() {
        return workStartTime;
    }

    public String getWorkEndTime() {
        return workEndTime;
    }

    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setWorkStartTime(String workStartTime) {
        this.workStartTime = workStartTime;
    }

    public void setWorkEndTime(String workEndTime) {
        this.workEndTime = workEndTime;
    }
}
