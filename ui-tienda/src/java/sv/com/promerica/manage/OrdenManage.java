/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.promerica.manage;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.xml.ws.WebServiceRef;
import sv.com.promerica.wsOrden.Orden;
import sv.com.promerica.wsOrden.OrdenWs;
import sv.com.promerica.wsOrden.OrdenWs_Service;

/**
 *
 * @author henrymartinez
 */
@Named(value = "ordenManage")
@ViewScoped
public class OrdenManage {

    private static final Logger LOG = Logger.getLogger(OrdenManage.class.getName());
    
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/OrdenWs/OrdenWs.wsdl")
    private OrdenWs_Service service;
     private OrdenWs ordenWs;
     private Orden orden;
     private boolean editar;
    private boolean guardar;

    /**
     * Creates a new instance of OrdenManage
     */
    @PostConstruct
    public void inicio() {
         ordenWs = service.getOrdenWsPort();
         orden = new Orden();
         editar=false;
         guardar=true;
    }
    
    public void guardar(){
        try{
            ordenWs.insertar(orden);
            listar();
            addMessage("Guaradado", "Guarado Satisfactorio");
        }catch(Exception e){
            LOG.log(Level.SEVERE, "Problemas para guarorden"+e.getMessage());
        }
    }
    
    public void eliminar(Integer id){
        try{
            this.orden=ordenWs.buscar(id);
            ordenWs.eliminar(orden);
            listar();
            addMessage("Eliminar", "Eliminado Satisfactoriaente");
        }catch(Exception e){
            LOG.log(Level.SEVERE, "Problemas para eliminar "+e.getMessage());
        }
    }
    
    public void editar(){
        try{
            ordenWs.editar(orden);
            addMessage("Editar", "Editar Satisfactorio");
            guardar=true;
            editar=false;
            listar();
        }catch(Exception e){
            LOG.log(Level.SEVERE, "Error al editar");
        }
    
    }
    
    public void prepararEditar(Integer id){
        this.orden=ordenWs.buscar(id);
        editar=true;
        guardar=false;
    }
    public List<Orden> listar(){
        List<Orden> ordens=new ArrayList();
        try{
            ordens=ordenWs.listar();
        }catch(Exception e){
            LOG.log(Level.SEVERE, "Problemas para poder listar");
        }
        return ordens;
    }


    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

     public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }  
    
    
}
