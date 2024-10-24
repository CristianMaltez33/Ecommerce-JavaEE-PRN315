package com.prn315_grupo_2_4.bean;

import javax.annotation.ManagedBean;
import com.prn315_grupo_2_4.Entity.Rol;
import com.prn315_grupo_2_4.ejb.RolFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("rolBean")
@ManagedBean
public class RolBean implements Serializable {

    @Inject
    private RolFacadeLocal rolFacadeLocal;
    private Rol rol;
    private List<Rol> roles;

    public RolBean() {
        rol = new Rol();
    }

    @PostConstruct
    public void init() {
        String rolIdParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("rolId");

        if (rolIdParam != null) {
            Long rolId = Long.parseLong(rolIdParam);
            rol = rolFacadeLocal.find(rolId);
        } else {
            rol = new Rol();
        }

        this.roles = rolFacadeLocal.findAll();
    }

    public void create() throws IOException {
        rolFacadeLocal.create(rol);
        this.init();
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro creado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public void edit() throws IOException {
        rolFacadeLocal.edit(rol);
        this.init();
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro editado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public void eliminar(Rol rolParam) {
        try {
            rolFacadeLocal.remove(rolParam);
            this.roles.remove(rolParam);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Categoría eliminada correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo eliminar el rol"));
        }
    }

    public Rol getRol() {
        return rol;
    }

    public List<Rol> getRoles() {
        return roles;
    }
}
