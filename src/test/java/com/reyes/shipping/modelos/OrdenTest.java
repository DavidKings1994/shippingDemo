package com.reyes.shipping.modelos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrdenTest {

    @Autowired
    Orden orden;

    @Test
    public void ciclo_de_vida_del_bean() {
        System.out.println("orden: " + orden.getId() + " - " + orden.getDatos());
    }

}