package com.reyes.shipping.modelos;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Orden implements InitializingBean, DisposableBean {
    int id;
    String datos;

    //JSR-250 annotations - BEST PRACTICE//
    @PostConstruct
    public void init() {
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

    public Orden() {
    }

    public Orden(int id, String datos) {
        this.id = id;
        this.datos = datos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

}
