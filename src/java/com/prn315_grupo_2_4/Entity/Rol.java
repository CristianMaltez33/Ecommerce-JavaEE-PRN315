package com.prn315_grupo_2_4.Entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;


public class Rol {

    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String titulo;
    
    @NotNull
    @Size(min = 1, max = 250)
    private String descripcion;
    
    private boolean estado = true;

    public Rol() {
    }

    public Rol(Long id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
