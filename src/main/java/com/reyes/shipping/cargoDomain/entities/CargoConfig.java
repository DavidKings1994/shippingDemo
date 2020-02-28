package com.reyes.shipping.cargoDomain.entities;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.Embeddable;

@Embeddable
public class CargoConfig implements InitializingBean, DisposableBean {

    float pricePërTon;
    float maxWeight;

    public CargoConfig(float pricePërTon, float maxWeight) {
        this.pricePërTon = pricePërTon;
        this.maxWeight = maxWeight;
    }

    public float getPricePërTon() {
        return pricePërTon;
    }

    public void setPricePërTon(float pricePërTon) {
        this.pricePërTon = pricePërTon;
    }

    public float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
    }

    //JSR-250 annotations - BEST PRACTICE//
    @PostConstruct
    public void init() {
//        this.pricePërTon = 5;
        System.out.println("init con annotation");
    }

    @PreDestroy
    public void _destroy() {
        System.out.println("destroy con annotation");
    }

    //CUSTOM - SEGUNDA OPCION//
    public void myInit() {
        System.out.println("init custom");
    }

    public void myDestroy() {
        System.out.println("destroy custom");
    }

    //INTERFACES - MALA IDEA//
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init con interfaz");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy con interfaz");
    }

}
