/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.promerica.test;

import com.promerica.entitys.Cliente;
import com.promerica.facades.ClienteFacade;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *
 * @author henrymartinez
 */
@Singleton
public class Testing implements Serializable{
    private final static Logger LOGGER = Logger.getLogger("bitacora.subnivel.Utilidades");
    @EJB
    ClienteFacade cm;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PostConstruct
    public void main(){
        LOGGER.log(Level.INFO, "INGRESO AL METODO ");
        Cliente henry= new Cliente();
        henry.setNombres("Henry Giovanni");
        henry.setApellidos("Martinez Cruz");
        cm.insertar(henry);
    }
}
