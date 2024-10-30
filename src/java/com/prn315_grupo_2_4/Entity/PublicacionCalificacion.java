package com.prn315_grupo_2_4.Entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

public class PublicacionCalificacion {

    private Long id;
    
    @ManyToOne  // Relación muchos a uno
    @JoinColumn(name = "id_publicacion", nullable = false)
    private Publicacion publicacion;

    @ManyToOne  // Relación muchos a uno
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    
    private int calificacion = 5;

    public PublicacionCalificacion() {
    }

    public PublicacionCalificacion(Long id, Publicacion publicacion, Usuario usuario) {
        this.id = id;
        this.publicacion = publicacion;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
    
    
}
