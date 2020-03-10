package com.reyes.shipping.scheduleDomain.DTOs;

import com.reyes.shipping.common.DTO;
import com.reyes.shipping.scheduleDomain.aggregates.DeliveryProgram;

public class DeliveryDTO implements DTO {

    private String scheduledDate;
    private String programmedDeliveryDate;
    private String deliveredDate;
    private DeliveryProgram deliveryProgram;

    public DeliveryDTO(String scheduledDate, String programmedDeliveryDate, String deliveredDate, DeliveryProgram deliveryProgram) {
        this.scheduledDate = scheduledDate;
        this.programmedDeliveryDate = programmedDeliveryDate;
        this.deliveredDate = deliveredDate;
        this.deliveryProgram = deliveryProgram;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public String getProgrammedDeliveryDate() {
        return programmedDeliveryDate;
    }

    public String getDeliveredDate() {
        return deliveredDate;
    }

    public DeliveryProgram getDeliveryProgram() {
        return deliveryProgram;
    }
}
