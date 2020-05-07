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
import sv.com.promerica.wsCliente.Cliente;
import sv.com.promerica.wsCliente.ClienteWs;
import sv.com.promerica.wsCliente.ClienteWs_Service;

/**
 *
 * @author henrymartinez
 */
@Named(value = "clienteManage")
@ViewScoped
public class ClienteManage implements Serializable{

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ClienteWs/ClienteWs.wsdl")
    private ClienteWs_Service service;

    private static final Logger LOG = Logger.getLogger(ClienteManage.class.getName());
    private ClienteWs clientews;
    private Cliente cliente;
    private List<Cliente>  listadoClientes;
    private boolean editar;
    private boolean guardar;
   
    @PostConstruct
    public void init() {
        cliente=new Cliente();
        clientews= new ClienteWs_Service().getClienteWsPort();
        listadoClientes=new ArrayList();
        editar=false;
        guardar=true;
        
    }
    
    public void guardar(){
        try{
            clientews.insertar(cliente);
            listar();
            addMessage("Guaradado", "Guarado Satisfactorio");
        }catch(Exception e){
            LOG.log(Level.SEVERE, "Problemas para guarcliente"+e.getMessage());
        }
    }
    
    public void eliminar(Integer id){
        try{
            this.cliente=clientews.buscar(id);
            clientews.eliminar(cliente);
            listar();
            addMessage("Eliminar", "Eliminado Satisfactoriaente");
        }catch(Exception e){
            LOG.log(Level.SEVERE, "Problemas para eliminar "+e.getMessage());
        }
    }
    
    public void editar(){
        try{
            clientews.editar(cliente);
            addMessage("Editar", "Editar Satisfactorio");
            guardar=true;
            editar=false;
            listar();
        }catch(Exception e){
            LOG.log(Level.SEVERE, "Error al editar");
        }
    
    }
    
    public void prepararEditar(Integer id){
        this.cliente=clientews.buscar(id);
        editar=true;
        guardar=false;
    }
    public List<Cliente> listar(){
        List<Cliente> clientes=new ArrayList();
        try{
            clientes=clientews.listar();
        }catch(Exception e){
            LOG.log(Level.SEVERE, "Problemas para poder listar");
        }
        return clientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }

    public boolean isGuardar() {
        return guardar;
    }

    public void setGuardar(boolean guardar) {
        this.guardar = guardar;
    }

   
    

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }  
}
