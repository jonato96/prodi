package com.programacion.servicio;

import com.programacion.db.TipoDireccion;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class TipoDireccionServicioImp implements TipoDireccionServicio{

    @PersistenceContext
    private EntityManager emp;

    @Override
    public void create(TipoDireccion direccion) {
        emp.persist(direccion);
    }

    @Override
    public TipoDireccion find(Integer id) {
        return emp.find(TipoDireccion.class, id);
    }

    @Override
    public List<TipoDireccion> findAll() {
        return emp.createQuery("select p from TipoDireccion p", TipoDireccion.class)
                .getResultList();
    }

    @Override
    public void edit(TipoDireccion direccion) {
        emp.merge(direccion);
    }

    @Override
    public void delete(Integer id) {
        emp.remove(find(id));
    }
}
