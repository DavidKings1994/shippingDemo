package com.reyes.shipping.scheduleDomain.applicationServices;

import com.reyes.shipping.common.DTO;
import com.reyes.shipping.scheduleDomain.DTOs.DeliveryArrivalDTO;
import com.reyes.shipping.scheduleDomain.DTOs.DeliveryDTO;
import com.reyes.shipping.scheduleDomain.DTOs.DeliveryProgramDTO;
import com.reyes.shipping.scheduleDomain.DTOs.EmptyDTO;
import com.reyes.shipping.scheduleDomain.entities.Delivery;

public class DeliveryDTOFactory {

    public enum TYPE {FULL, ARRIVAL, PROGRAM}

    public static DTO build(TYPE type, Delivery delivery) {
        switch (type) {
            case FULL: return new DeliveryDTO(delivery.getScheduledDate(), delivery.getProgrammedDeliveryDate(), delivery.getDeliveredDate(), delivery.getDeliveryProgram());
            case ARRIVAL: return new DeliveryArrivalDTO(delivery.getProgrammedDeliveryDate(), delivery.getDeliveredDate());
            case PROGRAM: return new DeliveryProgramDTO(delivery.getScheduledDate(), delivery.getDeliveryProgram());
            default: return new EmptyDTO();
        }
    }

}
