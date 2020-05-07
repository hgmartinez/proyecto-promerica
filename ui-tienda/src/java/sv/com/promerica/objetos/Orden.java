/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.promerica.objetos;

import sv.com.promerica.objetos.Cliente;
import java.io.Serializable;

/**
 *
 * @author henrymartinez
 */

public class Orden implements Serializable{
    private Integer id_orden;
    private Cliente client;
    private Producto producto;
    private Integer cantidad;

    public Integer getId_orden() {
        return id_orden;
    }

    public void setId_orden(Integer id_orden) {
        this.id_orden = id_orden;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
}
