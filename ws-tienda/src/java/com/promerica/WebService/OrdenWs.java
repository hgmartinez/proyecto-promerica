/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.promerica.WebService;

import com.promerica.entitys.Orden;
import com.promerica.facades.OrdenFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author henrymartinez
 */
@WebService(serviceName = "OrdenWs")
@Stateless()
public class OrdenWs {

    @EJB
    private OrdenFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "insertar")
    @Oneway
    public void insertar(@WebParam(name = "entity") Orden entity) {
        ejbRef.insertar(entity);
    }

    @WebMethod(operationName = "editar")
    @Oneway
    public void editar(@WebParam(name = "entity") Orden entity) {
        ejbRef.editar(entity);
    }

    @WebMethod(operationName = "eliminar")
    @Oneway
    public void eliminar(@WebParam(name = "entity") Orden entity) {
        ejbRef.eliminar(entity);
    }

    @WebMethod(operationName = "buscar")
    public Orden buscar(@WebParam(name = "id") Object id) {
        return ejbRef.buscar(id);
    }

    @WebMethod(operationName = "listar")
    public List<Orden> listar() {
        return ejbRef.listar();
    }
    
}
