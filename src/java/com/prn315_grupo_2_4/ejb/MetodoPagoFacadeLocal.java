/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prn315_grupo_2_4.ejb;

import com.prn315_grupo_2_4.Entity.MetodoPago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author crist
 */
@Local
public interface MetodoPagoFacadeLocal {

    void create(MetodoPago metodoPago);

    void edit(MetodoPago metodoPago);

    void remove(MetodoPago metodoPago);

    MetodoPago find(Object id);

    List<MetodoPago> findAll();

    List<MetodoPago> findRange(int[] range);

    int count();
    
}
