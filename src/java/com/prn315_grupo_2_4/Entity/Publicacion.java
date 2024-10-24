package com.prn315_grupo_2_4.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table( name = "publicacion_mtn" )
public class Publicacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne  // Relación muchos a uno
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne  // Relación muchos a uno
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;
    
    @Column(name = "titulo")
    @NotNull
    @Size(min = 1, max = 150)
    private String titulo;
    
    @Column(name = "descripcion")
    @NotNull
    @Size(min = 1, max = 150)
    private String descripcion;
    
    @Column(name = "precio")
    @NotNull
    private double precio = 0.0;
    
    @Column(name = "existencias")
    @NotNull
    private int existencias = 0;
    
    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "fecha_publicacion")
    private Date fecha_publicacion = new Date();
    
    @Column( name = "estado" )
    private boolean estado = true;

    public Publicacion() {
    }

    public Publicacion(Long id, Usuario usuario, Categoria categoria, String titulo, String descripcion) {
        this.id = id;
        this.usuario = usuario;
        this.categoria = categoria;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }
    
}
