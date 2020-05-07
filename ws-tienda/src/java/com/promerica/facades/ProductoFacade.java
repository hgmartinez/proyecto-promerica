/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.promerica.facades;

import com.promerica.entitys.Producto;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author henrymartinez
 */
@Stateless
@LocalBean
public class ProductoFacade extends FacadeAbstracto<Producto>{
    @PersistenceContext(unitName = "uni_persis")
    private EntityManager entityM;

    public ProductoFacade() {
        super(Producto.class);
    }

    @Override
    protected EntityManager getEntidadManager() {
        return entityM;
    }

  
}
