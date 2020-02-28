package com.reyes.shipping.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

public class DomainEventPublisher<T> {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void publish(T event) {

    }

}
