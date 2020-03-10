package com.reyes.shipping.scheduleDomain.domainServices;

import com.reyes.shipping.common.EntityRepository;
import com.reyes.shipping.scheduleDomain.aggregates.DeliveryProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeliveryRepository extends EntityRepository<DeliveryProgram> {

    @Autowired
    private  DeliveryJPARepository repository;


    @Override
    public void save(DeliveryProgram aggregateRoot) {
        repository.save(aggregateRoot);
    }

    @Override
    public void update(DeliveryProgram aggregateRoot) {
        repository.save(aggregateRoot);
    }

    @Override
    public void delete(DeliveryProgram aggregateRoot) {
        repository.delete(aggregateRoot);
    }

    @Override
    public List<DeliveryProgram> getAll() {
        return repository.findAll();
    }

    @Override
    public DeliveryProgram getById(long id) {
        return repository.findById(id).orElse(null);
    }
}
