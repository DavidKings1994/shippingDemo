package com.reyes.shipping.cargoDomain.events;

import com.reyes.shipping.common.DomainEvent;
import org.springframework.context.ApplicationEvent;

public class CargoCreatedEvent extends ApplicationEvent implements DomainEvent {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public CargoCreatedEvent(Object source) {
        super(source);
    }
}
