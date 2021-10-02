package com.programacion.servicio;

import com.programacion.db.TipoDireccion;

import java.util.List;

public interface TipoDireccionServicio {

    void create(TipoDireccion direccion);
    TipoDireccion find (Integer id);
    List<TipoDireccion> findAll();
    void edit(TipoDireccion direccion);
    void delete (Integer id);

}
