package com.reyes.shipping;

import com.reyes.shipping.cargoDomain.aggregates.Cargo;
import com.reyes.shipping.common.AggregateRoot;
import com.reyes.shipping.common.DomainEvent;
import com.reyes.shipping.common.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Service
public class JPAEventsListener {

    @Autowired
    private DomainEventPublisher<DomainEvent> eventPublisher;

    @PostPersist
    private void postPersist(AggregateRoot aggregateRoot) {
//        System.out.println("post persist");
        publishEvents(aggregateRoot);
    }

    @PostUpdate
    private void postUpdate(AggregateRoot aggregateRoot) {
//        System.out.println("post update");
        publishEvents(aggregateRoot);
    }

    @PostRemove
    private void postRemove(AggregateRoot aggregateRoot) {
//        System.out.println("post remove");
        publishEvents(aggregateRoot);
    }

    private void publishEvents(AggregateRoot aggregateRoot) {
        aggregateRoot.getDomainEvents().forEach(domainEvent -> {
            System.out.println(domainEvent.getClass().getName());
            eventPublisher.publish(domainEvent);
        });
        aggregateRoot.clearEvents();
    }

}
