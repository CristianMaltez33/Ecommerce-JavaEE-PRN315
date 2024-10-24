/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prn315_grupo_2_4.ejb;

import com.prn315_grupo_2_4.Entity.Publicacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author crist
 */
@Local
public interface PublicacionFacadeLocal {

    void create(Publicacion publicacion);

    void edit(Publicacion publicacion);

    void remove(Publicacion publicacion);

    Publicacion find(Object id);

    List<Publicacion> findAll();

    List<Publicacion> findRange(int[] range);

    int count();
    
}
