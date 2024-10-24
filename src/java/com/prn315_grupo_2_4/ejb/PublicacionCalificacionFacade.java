/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prn315_grupo_2_4.ejb;

import com.prn315_grupo_2_4.Entity.PublicacionCalificacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author crist
 */
@Stateless
public class PublicacionCalificacionFacade extends AbstractFacade<PublicacionCalificacion> implements PublicacionCalificacionFacadeLocal {

    @PersistenceContext(unitName = "Database")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PublicacionCalificacionFacade() {
        super(PublicacionCalificacion.class);
    }
    
}
