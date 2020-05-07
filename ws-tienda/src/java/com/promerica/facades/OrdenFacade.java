/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.promerica.facades;

import com.promerica.entitys.Orden;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author henrymartinez
 */
@Stateless
public class OrdenFacade extends FacadeAbstracto<Orden>{
     @PersistenceContext(unitName = "uni_persis")
    private EntityManager entityM;

    public OrdenFacade() {
        super(Orden.class);
    }

    @Override
    protected EntityManager getEntidadManager() {
        return entityM;    
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
