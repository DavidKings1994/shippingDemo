package com.reyes.shipping.scheduleDomain.applicationServices;

import com.reyes.shipping.cargoDomain.events.CargoCreatedEvent;
import com.reyes.shipping.common.Handler;

public class CargoCreatedEventHandle implements Handler<CargoCreatedEvent> {
    @Override
    public void handle(CargoCreatedEvent event) {
        System.out.println("Cargo created");
    }
}
