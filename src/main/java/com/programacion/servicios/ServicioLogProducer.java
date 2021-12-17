package com.programacion.servicios;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class ServicioLogProducer {
    @Produces
    @ApplicationScoped
    public ServicioLog create(){
        System.out.println("Productor");
        return new ServicioLogImpl();
    }
}
