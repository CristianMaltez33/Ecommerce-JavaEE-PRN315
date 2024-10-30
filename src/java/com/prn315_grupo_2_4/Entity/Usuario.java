package com.prn315_grupo_2_4.Entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

public class Usuario {

    private Long id;
    
    @ManyToOne  // Relación muchos a uno
    @JoinColumn(name = "id_rol", nullable = false)  // Crea la columna foreign key en 'usuarios'
    private Rol rol;

    @NotNull
    @Size(min = 1, max = 110)
    private String nombres;

    @NotNull
    @Size(min = 1, max = 110)
    private String apellidos;

    @NotNull
    @Size(min = 1, max = 110)
    private String correo;
    
    @NotNull
    private String password;
    
    private boolean estado = true;

    public Usuario() {
    }

    public Usuario(Long id, Rol rol, String nombres, String apellidos, String correo, String password) {
        this.id = id;
        this.rol = rol;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

		public void setUsername(String string) {
				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}

		public void setRole(String string) {
				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}
    
    

}
