/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.promerica.entitys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author henrymartinez
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Orden implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_ORDEN")
    private Integer id_orden;
    @NotNull
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne
    private Cliente client;
    @NotNull
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID")
    @ManyToOne
    private Producto producto;
    @NotNull
    @Column(name="CANTIDAD")
    private Integer cantidad;
    @NotNull
    @Column(name="FECHA")
    private Date  fecha;

    public Integer getId_orden() {
        return id_orden;
    }

    public void setId_orden(Integer id_orden) {
        this.id_orden = id_orden;
    }

    public Cliente getCliente() {
        return client;
    }

    public void setCliente(Cliente client) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
