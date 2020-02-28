/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reyes.shipping.common;

import javax.persistence.*;

/**
 *
 * @author david.reyes.gomez
 */
@MappedSuperclass
public abstract class Entity {

    @Version
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Entity() {
    }

    public Entity(Long id) {
        this.id = id;
    }

    public long getId() {
        return id == null ? 0 : id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public boolean equals(Entity e) {
        return this.id == e.id;
    }

    @Override
    public String toString() {
        return "[ " + this.id + " ]";
    }
}
