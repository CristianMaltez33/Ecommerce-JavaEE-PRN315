package com.prn315_grupo_2_4.bean;

import javax.annotation.ManagedBean;
import com.prn315_grupo_2_4.Entity.Categoria;
import com.prn315_grupo_2_4.ejb.CategoriaFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("categoriaBean")
@ManagedBean
//@ViewScoped
public class CategoriaBean implements Serializable {

    @Inject
    private CategoriaFacadeLocal categoriaFacadeLocal;
    private Categoria categoria;
    private List<Categoria> categorias;

    public CategoriaBean() {
        categoria = new Categoria();
    }

    @PostConstruct
    public void init() {
        String categoriaIdParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("categoriaId");

        if (categoriaIdParam != null) {
            Long categoriaId = Long.parseLong(categoriaIdParam);
            categoria = categoriaFacadeLocal.find(categoriaId);
        } else {
            categoria = new Categoria();
        }

        this.categorias = categoriaFacadeLocal.findAll();
    }

    public void create() throws IOException {
        categoriaFacadeLocal.create(categoria);
        this.init();
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro creado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public void edit() throws IOException {
        categoriaFacadeLocal.edit(categoria);
        this.init();
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro editado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public void eliminar(Categoria cat) {
        try {
            categoriaFacadeLocal.remove(cat);
            this.categorias.remove(cat);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Categoría eliminada correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo eliminar la categoría"));
        }
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
