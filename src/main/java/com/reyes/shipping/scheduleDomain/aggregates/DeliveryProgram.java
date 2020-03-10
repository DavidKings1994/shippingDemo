package com.reyes.shipping.scheduleDomain.aggregates;

import com.reyes.shipping.common.AggregateRoot;
import com.reyes.shipping.scheduleDomain.entities.Delivery;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "delivery_program")
public class DeliveryProgram extends AggregateRoot {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "deliveryProgram")
    private List<Delivery> deliveries;

    public DeliveryProgram() {
    }

    public DeliveryProgram(Long id, List<Delivery> deliveries) {
        super(id);
        this.deliveries = deliveries;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }
}
