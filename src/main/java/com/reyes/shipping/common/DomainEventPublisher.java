package com.reyes.shipping.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class DomainEventPublisher<T> {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void publish(T event) {
//        System.out.println("Publishing event " + event.getClass().getName());
        publisher.publishEvent(event);
    }

}
