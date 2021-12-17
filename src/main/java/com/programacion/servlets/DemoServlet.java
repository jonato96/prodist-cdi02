package com.programacion.servlets;

import com.programacion.servicios.Operaciones;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/demo")
public class DemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Creamos el contenedor
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        //Buscamos el componente
        Instance<Operaciones> obj = container.select(Operaciones.class);
        //Obtenemos el metodo
        Operaciones servicio = obj.get();
        int resultado = servicio.suma(2,2);

        PrintWriter p = resp.getWriter();
        p.println("Hola mundo desde Servlet, el resultado es: "+resultado);

        //En este punto el problema es que el contenedor se crea demasiadas veces,
        //Si ejecutamos 100 veces se crearan 100 contenedores
        //Lo ideal es crear solo uno y reutilizarlo
        //Esta forma no es la ideal
    }
}
