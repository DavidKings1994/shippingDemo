package com.reyes.shipping;

import com.reyes.shipping.cargoDomain.entities.CargoConfig;
import com.reyes.shipping.scheduleDomain.valueObjects.DeliveryConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {

    @Autowired
    private DeliveryConfig deliveryConfigPrimary;

    @Autowired
    @Qualifier("deliveryConfiginitialized")
    private DeliveryConfig deliveryConfigQualifier;

    @Autowired
    private CargoConfig cargoConfig;

    @Test
    public void dos_beans_con_mismo_nombre_y_primary() {
        Assertions.assertTrue(deliveryConfigPrimary.getWorkStartTime().equals("9:00"));
        Assertions.assertTrue(deliveryConfigPrimary.getMaxPrice() == cargoConfig.getPricePerTon() * cargoConfig.getMaxWeight());
    }

    @Test
    public void dos_beans_con_mismo_nombre_y_qualifier() {
        Assertions.assertTrue(deliveryConfigQualifier.getWorkEndTime().equals("12:00"));
    }

    @Test
    public void dos_beans_con_mismo_nombre_y_spel() {

    }

}
