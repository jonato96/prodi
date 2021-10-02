package com.programacion.proxy;

import com.programacion.entidades.TipoDireccion;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/direccion")
public interface TipoDireccionRest {

    @GET
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    String hola();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<TipoDireccion> listar();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    TipoDireccion listarPorId(@PathParam("id") Integer id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void crear(TipoDireccion tipoDireccion);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    void editar(TipoDireccion tipoDireccion);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    void eliminar(@PathParam("id") Integer id);

}
