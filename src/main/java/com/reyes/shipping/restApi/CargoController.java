package com.reyes.shipping.restApi;

import com.reyes.shipping.cargoDomain.aggregates.Cargo;
import com.reyes.shipping.cargoDomain.domainServices.CargoJPARepository;
import com.reyes.shipping.cargoDomain.domainServices.CargoRepository;
import com.reyes.shipping.cargoDomain.events.CargoCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CargoController {

    private CargoRepository repository;

    @Autowired
    public CargoController(CargoRepository repository) {
        this.repository = repository;
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
