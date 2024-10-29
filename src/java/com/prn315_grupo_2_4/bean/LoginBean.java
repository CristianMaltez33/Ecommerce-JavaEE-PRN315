/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prn315_grupo_2_4.bean;

import com.prn315_grupo_2_4.Entity.Usuario;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author edwin
 */
@ManagedBean
@SessionScoped
public class LoginBean implements  Serializable{
       private String username;
    private String password;
    private Usuario usuario;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public String autenticar() {
        usuario = usuarioDAO.obtenerUsuario(username, password);

        if (usuario != null) {
            return "home?faces-redirect=true"; // Redirige a la página principal tras autenticarse
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Credenciales incorrectas"));
            return null;
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true"; // Redirige a login tras cerrar sesión
    }

    // Getters y Setters     

		public String getUsername() {
				return username;
		}

		public void setUsername(String username) {
				this.username = username;
		}

		public String getPassword() {
				return password;
		}

		public void setPassword(String password) {
				this.password = password;
		}

		public Usuario getUsuario() {
				return usuario;
		}

		public void setUsuario(Usuario usuario) {
				this.usuario = usuario;
		}

		public UsuarioDAO getUsuarioDAO() {
				return usuarioDAO;
		}

		public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
				this.usuarioDAO = usuarioDAO;
		}
				
                                                  
}
