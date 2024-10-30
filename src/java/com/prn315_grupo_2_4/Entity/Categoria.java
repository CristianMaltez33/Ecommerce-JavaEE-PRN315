package com.prn315_grupo_2_4.Entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

public class Categoria {

    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    private String titulo;

    @NotNull
    @Size(min = 1, max = 250)
    private String descripcion;

    private boolean estado = true;

    public Categoria() {
    }

    public Categoria(Long id, String titulo, String descripcion, boolean estado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
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

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
