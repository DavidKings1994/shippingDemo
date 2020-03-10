package com.reyes.shipping;

import com.reyes.shipping.cargoDomain.entities.CargoConfig;
import com.reyes.shipping.scheduleDomain.valueObjects.DeliveryConfig;
import com.reyes.shipping.scheduleDomain.valueObjects.DeliveryConfigInterface;
import com.reyes.shipping.scheduleDomain.valueObjects.DeliveryConfigOptional;
import com.reyes.shipping.scheduleDomain.valueObjects.DeliveryConfigSecondary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {

    @Autowired
    private DeliveryConfigInterface deliveryConfig;

    @Autowired
    @Qualifier("deliveryConfigSecondary")
    private DeliveryConfigInterface deliveryConfigQualifier;

    @Autowired
    private DeliveryConfigInterface deliveryConfigOptional;

    @Autowired
    private CargoConfig cargoConfig;

    @Test
    public void dos_beans_con_mismo_nombre_y_primary() {
        Assertions.assertTrue(deliveryConfig instanceof DeliveryConfig);
    }

    @Test
    public void dos_beans_con_mismo_nombre_y_qualifier() {
        Assertions.assertTrue(deliveryConfigQualifier instanceof DeliveryConfigSecondary);
    }

    @Test
    public void dos_beans_con_mismo_nombre_con_autowired() {
        //Assertions.assertTrue(deliveryConfigOptional instanceof DeliveryConfig);
        Assertions.assertTrue(deliveryConfigOptional instanceof DeliveryConfigOptional);
    }

    @Test
    public void dos_beans_con_mismo_nombre_y_spel() {
        Assertions.assertTrue(deliveryConfig.getMaxPrice() == cargoConfig.getPricePerTon() * cargoConfig.getMaxWeight());
        Assertions.assertEquals("DeliveryConfig", ((DeliveryConfig)deliveryConfig).getName());
        Assertions.assertEquals("DeliveryConfigSecondary", ((DeliveryConfigSecondary)deliveryConfigQualifier).getName());
    }

}
