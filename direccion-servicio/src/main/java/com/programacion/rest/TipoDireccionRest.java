package com.programacion.rest;

import com.programacion.db.TipoDireccion;
import com.programacion.servicio.TipoDireccionServicio;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/direccion")
public class TipoDireccionRest {

    @Inject
    private TipoDireccionServicio servicio;

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void crear(TipoDireccion tipoDireccion){
        servicio.create(tipoDireccion);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void editar(TipoDireccion tipoDireccion){
        servicio.edit(tipoDireccion);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void eliminar(@PathParam("id") Integer id){
        servicio.delete(id);
    }

    @GET
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public String hola(){
        return "Hola mundo desde Tipo Direccion Rest";
    }

}
