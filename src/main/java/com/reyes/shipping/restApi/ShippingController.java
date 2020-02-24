package com.reyes.shipping.restApi;

import com.reyes.shipping.modelos.Orden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/shipping")
public class ShippingController {

    @Autowired
    Orden orden;

    @GetMapping
    public HttpEntity<Orden> test() {
        return new HttpEntity<Orden>(orden);
    }

}
