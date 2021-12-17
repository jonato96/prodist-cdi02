package com.programacion.servicios;

import jakarta.enterprise.context.ApplicationScoped;

//@ApplicationScoped
public class ServicioLogImpl implements ServicioLog{
    @Override
    public void log(String msg) {
        System.out.println("Log: "+msg);
    }
}
