package com.reyes.shipping.cargoDomain.aggregates;

import com.reyes.shipping.JPAEventListener;
import com.reyes.shipping.common.AggregateRoot;

import javax.persistence.*;

@Entity
@EntityListeners(JPAEventListener.class)
public class Cargo extends AggregateRoot {

    @Column
    private float weight;

    public Cargo() {
    }

    public Cargo(long id, float weight) {
        super(id);
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}