/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.promerica.manage;

import java.io.Serializable;
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
import sv.com.promerica.wsProducto.Producto;
import sv.com.promerica.wsProducto.ProductoWs;
import sv.com.promerica.wsProducto.ProductoWs_Service;

/**
 *
 * @author henrymartinez
 */
@Named(value = "productoManage")
@ViewScoped
public class ProductoManage implements Serializable{

    private static final Logger LOG = Logger.getLogger(ProductoManage.class.getName());
    
    private Producto producto;
     @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ProductoWs/ProductoWs.wsdl")
    private ProductoWs_Service service;
    private ProductoWs productoWs;
    private boolean editar;
    private boolean guardar;
    /**
     * Creates a new instance of ProductoManage
     */
    @PostConstruct
    public void inicio() {
        producto= new Producto();
        productoWs=  service.getProductoWsPort();
        editar=false;
        guardar=true;
    }
    
   public void guardar(){
        try{
            productoWs.insertar(producto);
            listar();
            addMessage("Guaradado", "Guarado Satisfactorio");
        }catch(Exception e){
            LOG.log(Level.SEVERE, "Problemas para guarproducto"+e.getMessage());
        }
    }
    
    public void eliminar(Integer id){
        try{
            this.producto=productoWs.buscar(id);
            productoWs.eliminar(producto);
            listar();
            addMessage("Eliminar", "Eliminado Satisfactoriaente");
        }catch(Exception e){
            LOG.log(Level.SEVERE, "Problemas para eliminar "+e.getMessage());
        }
    }
    
    public void editar(){
        try{
            productoWs.editar(producto);
            addMessage("Editar", "Editar Satisfactorio");
            guardar=true;
            editar=false;
            listar();
        }catch(Exception e){
            LOG.log(Level.SEVERE, "Error al editar");
        }
    
    }
    
    public void prepararEditar(Integer id){
        this.producto=productoWs.buscar(id);
        editar=true;
        guardar=false;
    }
    public List<Producto> listar(){
        List<Producto> productos=new ArrayList();
        try{
            productos=productoWs.listar();
        }catch(Exception e){
            LOG.log(Level.SEVERE, "Problemas para poder listar");
        }
        return productos;
    }

     public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }  

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
}
