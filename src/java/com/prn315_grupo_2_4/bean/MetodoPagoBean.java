package com.prn315_grupo_2_4.bean;

import com.prn315_grupo_2_4.Entity.MetodoPago;
import javax.annotation.ManagedBean;
import com.prn315_grupo_2_4.ejb.MetodoPagoFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("metodoPagoBean")
@ManagedBean
public class MetodoPagoBean implements Serializable {

    @Inject
    private MetodoPagoFacadeLocal metodoPagoFacadeLocal;
    private MetodoPago metodoPago;
    private List<MetodoPago> metodosPago;

    public MetodoPagoBean() {
        metodoPago = new MetodoPago();
    }

    @PostConstruct
    public void init() {
        String metodoPagoIdParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("metodoPagoId");

        if (metodoPagoIdParam != null) {
            Long rolId = Long.parseLong(metodoPagoIdParam);
            metodoPago = metodoPagoFacadeLocal.find(rolId);
        } else {
            metodoPago = new MetodoPago();
        }

        this.metodosPago = metodoPagoFacadeLocal.findAll();
    }

    public void create() throws IOException {
        metodoPagoFacadeLocal.create(metodoPago);
        this.init();
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro creado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public void edit() throws IOException {
        metodoPagoFacadeLocal.edit(metodoPago);
        this.init();
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro editado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public void eliminar(MetodoPago metodoPagoParam) {
        try {
            metodoPagoFacadeLocal.remove(metodoPagoParam);
            this.metodosPago.remove(metodoPagoParam);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Categoría eliminada correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo eliminar el rol"));
        }
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public List<MetodoPago> getMetodosPago() {
        return metodosPago;
    }
}
