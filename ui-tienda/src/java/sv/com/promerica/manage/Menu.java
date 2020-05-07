/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.promerica.manage;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author henrymartinez
 */
@Named(value = "menu")
@RequestScoped
public class Menu implements Serializable{

    /**
     * Creates a new instance of Menu
     */
    public Menu() {
    }
    
    
    public String producto(){
        return "/producto";
    }
    public String cliente(){
        return "/index";
    }
    public String orden(){
        return "/orden";
    }
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
