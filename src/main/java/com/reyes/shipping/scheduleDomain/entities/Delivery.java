package com.reyes.shipping.scheduleDomain.entities;

import com.reyes.shipping.common.Entity;
import com.reyes.shipping.scheduleDomain.aggregates.DeliveryProgram;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "delivery")
public class Delivery extends Entity {

    @Column
    private String scheduledDate;

    @Column
    private String programmedDeliveryDate;

    @Column
    private String deliveredDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deliveryProgram", referencedColumnName = "id", nullable = false)
    private DeliveryProgram deliveryProgram;

    public Delivery() {
    }

    public Delivery(Long id, String scheduledDate, String programmedDeliveryDate, String deliveredDate, DeliveryProgram deliveryProgram) {
        super(id);
        this.scheduledDate = scheduledDate;
        this.programmedDeliveryDate = programmedDeliveryDate;
        this.deliveredDate = deliveredDate;
        this.deliveryProgram = deliveryProgram;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public String getProgrammedDeliveryDate() {
        return programmedDeliveryDate;
    }

    public void setProgrammedDeliveryDate(String programmedDeliveryDate) {
        this.programmedDeliveryDate = programmedDeliveryDate;
    }

    public String getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(String deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public DeliveryProgram getDeliveryProgram() {
        return deliveryProgram;
    }

    public void setDeliveryProgram(DeliveryProgram deliveryProgram) {
        this.deliveryProgram = deliveryProgram;
    }
}
