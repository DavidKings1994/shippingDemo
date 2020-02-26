package com.reyes.shipping.restApi;

import com.reyes.shipping.cargo.entities.Cargo;
import com.reyes.shipping.cargo.entities.CargoJPARepository;
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

    @Autowired
    private CargoJPARepository cargoJPARepository;

    @GetMapping()
    public HttpEntity<List<Cargo>> getCargo() {
        return ResponseEntity.ok(cargoJPARepository.findAll());
    }

    @PostMapping
    public HttpEntity createCargo() {
        Cargo cargo = new Cargo();
        cargo.setWeight(100);
        cargoJPARepository.save(cargo);
        return new ResponseEntity(HttpStatus.OK);
    }

}
