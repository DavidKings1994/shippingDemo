/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reyes.shipping.common;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author david.reyes.gomez
 * @param <T>
 */
@Repository
public abstract class EntityRepository<T extends  AggregateRoot> {

    public abstract void save(T aggregateRoot);

    public abstract void update(T aggregateRoot);

    public abstract void delete(T aggregateRoot);

    public abstract List<T> getAll();

    public abstract T getById(long id);

}
