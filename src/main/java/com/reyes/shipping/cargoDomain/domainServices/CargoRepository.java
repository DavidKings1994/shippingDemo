package com.reyes.shipping.cargoDomain.domainServices;

import com.reyes.shipping.cargoDomain.aggregates.Cargo;
import com.reyes.shipping.common.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CargoRepository extends EntityRepository<Cargo> {

    @Autowired
    CargoJPARepository cargoJPARepository;

    @Override
    public void save(Cargo aggregateRoot) {
        cargoJPARepository.save(aggregateRoot);
    }

    @Override
    public void update(Cargo aggregateRoot) {
        cargoJPARepository.save(aggregateRoot);
    }

    @Override
    public void delete(Cargo aggregateRoot) {
        cargoJPARepository.delete(aggregateRoot);
    }

    @Override
    public List<Cargo> getAll() {
        return cargoJPARepository.findAll();
    }

    @Override
    public Cargo getById(long id) {
        return cargoJPARepository.findById(id).orElse(null);
    }
}
