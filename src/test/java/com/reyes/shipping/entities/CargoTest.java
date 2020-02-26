package com.reyes.shipping.entities;

import com.reyes.shipping.cargo.entities.Cargo;
import com.reyes.shipping.cargo.entities.CargoConfig;
import com.reyes.shipping.cargo.entities.CargoJPARepository;
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
    private CargoJPARepository cargoJPARepository;

    @Autowired
    private CargoConfig cargoConfig;

    @BeforeAll
    public void init() {
        Cargo cargo = new Cargo();
        cargo.setWeight(100);
        cargoJPARepository.save(cargo);
    }

    @Test
    public void ciclo_de_vida_del_bean() {
        Cargo cargo = cargoJPARepository.findById(1).orElse(null);

        Assertions.assertNotNull(cargo, "No se encontro registro");
        Assertions.assertEquals(1000, cargo.getWeight() * cargoConfig.getPricePërTon(), cargo.getWeight() + "* 10 = 1000" );
    }

}