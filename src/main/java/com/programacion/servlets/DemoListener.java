package com.programacion.servlets;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class DemoListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Iniciando Contenedor");
        //Creamos e inicializamos el contenedor
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        ServletContext sx = sce.getServletContext();
        sx.setAttribute("miContenedor", container);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
