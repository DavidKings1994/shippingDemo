package com.reyes.shipping;

import com.reyes.shipping.common.AggregateRoot;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Service
public class JPAEventListener {

    @PostPersist
    private void postPersist(AggregateRoot aggregateRoot) {
//        System.out.println("post persist");
    }

    @PostUpdate
    private void postUpdate(AggregateRoot aggregateRoot) {
//        System.out.println("post update");
    }

    @PostRemove
    private void postRemove(AggregateRoot aggregateRoot) {
//        System.out.println("post remove");
    }
}
