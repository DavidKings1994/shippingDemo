package com.reyes.shipping.scheduleDomain.applicationServices;

import com.reyes.shipping.cargoDomain.aggregates.Cargo;
import com.reyes.shipping.cargoDomain.events.CargoCreatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class CargoCreatedEventHandle implements ApplicationListener<CargoCreatedEvent> {

    @Override
    public void onApplicationEvent(CargoCreatedEvent event) {
        System.out.println("Cargo created");
        System.out.println("Cargo weight: " + ((Cargo)event.getSource()).getWeight());
    }
}
