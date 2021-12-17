package com.programacion.servicios;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class OperacionesImpl implements Operaciones{
    @Inject
    private ServicioLog servicio;
    @Override
    public int suma(int x, int y) {
        servicio.log("Inicializando servicios");
        return x+y;
    }
}
