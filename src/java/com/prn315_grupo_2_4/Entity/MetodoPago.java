package com.prn315_grupo_2_4.Entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table( name = "metodo_pago_ctl" )
public class MetodoPago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50)
    @Column( name = "titulo" )
    private String titulo;
    
    @NotNull
    @Size(min = 1, max = 250)
    @Column( name = "descripcion" )
    private String descripcion;
    
    @Column( name = "estado" )
    private boolean estado = true;

    public MetodoPago() {
    }

    public MetodoPago(Long id, String titulo, String descripcion) {
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

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

   
    
}
