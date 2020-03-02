package com.reyes.shipping.entities;

import com.reyes.shipping.cargoDomain.aggregates.Cargo;
import com.reyes.shipping.cargoDomain.domainServices.CargoRepository;
import com.reyes.shipping.cargoDomain.entities.CargoConfig;
import com.reyes.shipping.cargoDomain.events.CargoCreatedEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CargoTest {

    @Autowired
    private CargoRepository repository;

    @Autowired
    private CargoConfig cargoConfig;

//    @Autowired
//    public CargoTest(CargoConfig cargoConfig) {
//        this.cargoConfig = cargoConfig;
//    }

//    @Autowired
//    public void setCargoConfig(CargoConfig cargoConfig) {
//        this.cargoConfig = cargoConfig;
//    }

    @BeforeAll
    public void init() {
        Cargo cargo = new Cargo(0, 100);
        cargo.addDomainEvent(new CargoCreatedEvent(cargo));
        repository.save(cargo);
    }

    @Test
    public void ciclo_de_vida_del_bean() {
        Cargo cargo = repository.getById(1L);

        Assertions.assertNotNull(cargo, "No se encontro registro");
        Assertions.assertEquals(1000, cargo.getWeight() * cargoConfig.getPricePërTon(), cargo.getWeight() + "* 10 = 1000" );
    }

    @Test
    public void nuevo_cargo() {
        Cargo cargo = new Cargo(0, 100);
        cargo.addDomainEvent(new CargoCreatedEvent(cargo));
        repository.save(cargo);


        Assertions.assertEquals(0, cargo.getDomainEvents().size(), "No se publicaron los eventos");
    }

}