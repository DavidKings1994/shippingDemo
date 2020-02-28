/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reyes.shipping.common;

/**
 *
 * @author david.reyes.gomez
 * @param <T>
 */
public abstract class ValueObject<T> {

    /**
     *
     * @param other
     * @return
     */
    public abstract boolean Equals(T other);
    public abstract int getHashCode();
}
