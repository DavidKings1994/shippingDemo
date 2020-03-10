package com.reyes.shipping.scheduleDomain.DTOs;

import com.reyes.shipping.common.DTO;

public class DeliveryArrivalDTO implements DTO {

    private String programmedDeliveryDate;
    private String deliveredDate;

    public DeliveryArrivalDTO(String programmedDeliveryDate, String deliveredDate) {
        this.programmedDeliveryDate = programmedDeliveryDate;
        this.deliveredDate = deliveredDate;
    }

    public String getProgrammedDeliveryDate() {
        return programmedDeliveryDate;
    }

    public String getDeliveredDate() {
        return deliveredDate;
    }
}
