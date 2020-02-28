package com.reyes.shipping.common;

public interface Handler<T extends DomainEvent> {

    void handle(T event);

}
