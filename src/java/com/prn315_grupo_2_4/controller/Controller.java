package com.prn315_grupo_2_4.controller;

import com.prn315_grupo_2_4.Entity.Categoria;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Controller implements ServletContextListener {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Database");

    public Controller() {
        
//        CategoriaJpaController categoria = new CategoriaJpaController(emf);
//        UsuarioJpaController usuario = new UsuarioJpaController(emf);

//        this. emf = Persistence.createEntityManagerFactory("Database");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Levantando XD");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Cerrando XD");
    }
}

