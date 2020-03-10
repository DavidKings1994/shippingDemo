package com.reyes.shipping.restApi;

import com.reyes.shipping.cargoDomain.aggregates.Cargo;
import com.reyes.shipping.cargoDomain.domainServices.CargoJPARepository;
import com.reyes.shipping.cargoDomain.domainServices.CargoRepository;
import com.reyes.shipping.cargoDomain.events.CargoCreatedEvent;
import com.reyes.shipping.scheduleDomain.valueObjects.DeliveryConfig;
import com.reyes.shipping.scheduleDomain.valueObjects.DeliveryConfigInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/shipping")
//@Lazy
public class CargoController {

    private CargoRepository repository;
    private DeliveryConfigInterface deliveryConfig;

    @Autowired
    public CargoController(CargoRepository repository,
            /*@Qualifier("deliveryConfigOptional")*/ DeliveryConfigInterface deliveryConfig) {
        this.repository = repository;
        this.deliveryConfig = deliveryConfig;
        System.out.println("Instance 2: " + this.deliveryConfig);
        System.out.println("Delivery config Max Price:" + deliveryConfig.getMaxPrice());
        System.out.println("Delivery config Start Time:" + deliveryConfig.getWorkStartTime());
        System.out.println("Delivery config End Time:" + deliveryConfig.getWorkEndTime());
    }

    @GetMapping()
    public HttpEntity<List<Cargo>> getCargo() {
        return ResponseEntity.ok(repository.getAll());
    }

    @PostMapping
    public HttpEntity createCargo() {
        Cargo cargo = new Cargo(1, 100);
        cargo.addDomainEvent(new CargoCreatedEvent(cargo));
        repository.save(cargo);
        return new ResponseEntity(HttpStatus.OK);
    }

}
