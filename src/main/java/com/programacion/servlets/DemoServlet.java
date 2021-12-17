package com.programacion.servlets;

import com.programacion.servicios.Operaciones;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/demo")
public class DemoServlet extends HttpServlet {

    @Inject
    private Operaciones servicio;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Creamos el contenedor
        //SeContainer container = SeContainerInitializer.newInstance().initialize();

        //Obtenemos el contexto
        //ServletContext sx = req.getServletContext();
        //SeContainer container = (SeContainer) sx.getAttribute("miContenedor");
        //Buscamos el componente
        //Instance<Operaciones> obj = container.select(Operaciones.class);
        //Obtenemos el metodo
        //Operaciones servicio = obj.get();

        int resultado = servicio.suma(2,2);
        System.out.println("La suma de los numero es: "+resultado);
        PrintWriter p = resp.getWriter();
        p.println("Hola mundo desde Servlet, el resultado es: "+resultado);

        //Ahora estamos creando solo una vez el contenedor, y cada vez que ejecutamos
        //no se vuelve a crear
    }
}
