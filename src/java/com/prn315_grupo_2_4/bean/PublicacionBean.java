package com.prn315_grupo_2_4.bean;

import com.prn315_grupo_2_4.Entity.Publicacion;
import com.prn315_grupo_2_4.Service.PublicacionService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class PublicacionBean implements Serializable {

    private Publicacion publicacion;
    private List<Publicacion> listaPublicaciones;

    @Inject
    private PublicacionService publicacionService;

    public PublicacionBean() {
        publicacion = new Publicacion();
        listaPublicaciones = publicacionService.obtenerPublicaciones();
    }

    public void crear() {
        try {
            if (validarDatos()) {
                publicacionService.crearPublicacion(publicacion);
                publicacion = new Publicacion();
                listaPublicaciones = publicacionService.obtenerPublicaciones();
                FacesMessage message = new FacesMessage("Publicación creada con éxito");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("Error al crear publicación: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void editar(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public void guardar() {
        try {
            if (validarDatos()) {
                publicacionService.actualizarPublicacion(publicacion);
                publicacion = new Publicacion();
                listaPublicaciones = publicacionService.obtenerPublicaciones();
                FacesMessage message = new FacesMessage("Publicación actualizada con éxito");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("Error al actualizar publicación: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void eliminar(Publicacion publicacion) {
        try {
            publicacionService.eliminarPublicacion(publicacion);
            listaPublicaciones = publicacionService.obtenerPublicaciones();
            FacesMessage message = new FacesMessage("Publicación eliminada con éxito");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("Error al eliminar publicación: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    private boolean validarDatos() {
        if (publicacion.getTitulo() == null || publicacion.getTitulo().isEmpty()) {
            FacesMessage message = new FacesMessage("El título es requerido");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return false;
        }
        if (publicacion.getContenido() == null || publicacion.getContenido().isEmpty()) {
            FacesMessage message = new FacesMessage("El contenido es requerido");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return false;
        }
        if (publicacion.getPrecio() <= 0) {
            FacesMessage message = new FacesMessage("El precio debe ser mayor que cero");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return false;
        }
        return true;
    }

    // Getters y Setters
    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public List<Publicacion> getListaPublicaciones() {
        return listaPublicaciones;
    }
}