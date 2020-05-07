/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.promerica.facades;


import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author henrymartinez
 */

public abstract class FacadeAbstracto<T> {

   private Class<T> tipoEntidad;

    public FacadeAbstracto(Class<T> tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    protected abstract EntityManager getEntidadManager();

    public void insertar(T entity) {
        getEntidadManager().persist(entity);
    }

    public void editar(T entity) {
        getEntidadManager().merge(entity);
    }

    public void eliminar(T entity) {
        getEntidadManager().remove(getEntidadManager().merge(entity));
    }

    public T buscar(Object id) {
        return getEntidadManager().find(tipoEntidad, id);
    }
    public List<T> listar() {
        javax.persistence.criteria.CriteriaQuery cq = getEntidadManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(tipoEntidad));
        return getEntidadManager().createQuery(cq).getResultList();
    }
}
