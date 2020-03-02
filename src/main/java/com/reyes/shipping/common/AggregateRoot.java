package com.reyes.shipping.common;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

public abstract class AggregateRoot extends Entity {

    @Autowired
    @Transient
    private DomainEventPublisher<DomainEvent> eventPublisher;

    @Transient
    private List<DomainEvent> domainEvents;

    public AggregateRoot() {
        domainEvents = new ArrayList<>();
    }

    public AggregateRoot(Long id) {
        super(id);
        domainEvents = new ArrayList<>();
    }

    public final void addDomainEvent(DomainEvent newEvent) {
        domainEvents.add(newEvent);
    }

    public final void clearEvents() {
        domainEvents.clear();
    }

    public final List<DomainEvent> getDomainEvents() {
        return domainEvents;
    }

    public boolean isValid() {
        return true;
    }

}
