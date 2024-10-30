package com.prn315_grupo_2_4.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Entidad que representa una publicación en la base de datos.
 *
 * @author [Tu nombre]
 * @version 1.0
 */
public class Publicacion {

    /**
     * Identificador único de la publicación.
     */
    private Long id;
    private String titulo;
    private String descripcion;
    private String descripcion;
    private Categoria categoria;
    private Usuario usuario;
    private Date fechaDePublicacion;


    /**
     * Usuario que creó la publicación.
     */
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    /**
     * Categoría a la que pertenece la publicación.
     */
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    /**
     * Título de la publicación.
     */
    @NotNull
    @Size(min = 1, max = 150)
    private String titulo;

    /**
     * Descripción de la publicación.
     */
    @NotNull
    @Size(min = 1, max = 150)
    private String descripcion;

    /**
     * Precio de la publicación.
     */
    @NotNull
    private BigDecimal precio;

    /**
     * Número de existencias de la publicación.
     */
    @NotNull
    private Integer existencias;

    /**
     * Fecha de publicación.
     */
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date fechaDePublicacion;

    /**
     * Estado de la publicación (activo o inactivo).
     */
    private boolean activo;

    /**
     * Constructor vacío.
     */
    public Publicacion() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param id          Identificador único de la publicación.
     * @param usuario     Usuario que creó la publicación.
     * @param categoria   Categoría a la que pertenece la publicación.
     * @param titulo      Título de la publicación.
     * @param descripcion Descripción de la publicación.
     */
    public Publicacion(Long id, Usuario usuario, Categoria categoria, String titulo, String descripcion) {
        this.id = id;
        this.usuario = usuario;
        this.categoria = categoria;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el identificador único de la publicación.
     *
     * @return Identificador único de la publicación.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la publicación.
     *
     * @param id Identificador único de la publicación.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el usuario que creó la publicación.
     *
     * @return Usuario que creó la publicación.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario que creó la publicación.
     *
     * @param usuario Usuario que creó la publicación.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la categoría a la que pertenece la publicación.
     *
     * @return Categoría a la que pertenece la publicación.
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría a la que pertenece la publicación.
     *
     * @param categoria Categoría a la que pertenece la publicación.
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene el título de la publicación.
     *
     * @return Título de la publicación.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la publicación.
     *
     * @param titulo Título de la publicación.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;