package com.reyes.shipping.modelos;

import org.springframework.stereotype.Component;

@Component
public class Orden {
    int id;
    String datos;

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
