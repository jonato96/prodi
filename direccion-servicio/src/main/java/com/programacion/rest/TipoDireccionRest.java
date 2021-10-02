package com.programacion.rest;

import com.programacion.db.TipoDireccion;
import com.programacion.servicio.TipoDireccionServicio;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/direccion")
public class TipoDireccionRest {

    @Inject
    private TipoDireccionServicio servicio;

    @GET
    @Path("/hola")
    @Produces(MediaType.APPLICATION_JSON)
    public String hola(){
        return "Hola que tal mi pez";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoDireccion> listar(){
        return servicio.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TipoDireccion listarPorId(@PathParam("id") Integer id){
        return servicio.find(id);
    }

}
