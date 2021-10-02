package com.programacion.proxy;

import com.programacion.entidades.TipoDireccion;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/direccion")
public interface TipoDireccionRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<TipoDireccion> listar();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    TipoDireccion listarPorId(@PathParam("id") Integer id);

}
