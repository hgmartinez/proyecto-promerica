/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.promerica.facades;

import com.promerica.entitys.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author henrymartinez
 */
@Stateless
public class ClienteFacade extends FacadeAbstracto<Cliente>{
    @PersistenceContext(unitName = "uni_persis")
    private EntityManager entityM;

    public ClienteFacade() {
        super(Cliente.class);
    }

    @Override
    protected EntityManager getEntidadManager() {
       return entityM;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
