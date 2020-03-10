package com.reyes.shipping.scheduleDomain.DTOs;

import com.reyes.shipping.common.DTO;
import com.reyes.shipping.scheduleDomain.aggregates.DeliveryProgram;

public class DeliveryProgramDTO implements DTO {

    private String scheduledDate;
    private DeliveryProgram deliveryProgram;

    public DeliveryProgramDTO(String scheduledDate, DeliveryProgram deliveryProgram) {
        this.scheduledDate = scheduledDate;
        this.deliveryProgram = deliveryProgram;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public DeliveryProgram getDeliveryProgram() {
        return deliveryProgram;
    }
}
