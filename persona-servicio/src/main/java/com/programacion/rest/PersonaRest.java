package com.programacion.rest;

import com.programacion.dto.PersonaDto;
import com.programacion.entidades.Persona;
import com.programacion.servicio.ServicioPersona;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/personas")
public class PersonaRest {

    @Inject
    private ServicioPersona servicio;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonaDto> listar(){
        return servicio.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public PersonaDto listarPorId(@PathParam("id") Integer id){
        return servicio.find(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void crear(Persona persona){
        servicio.create(persona);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void editar(Persona persona){
        servicio.edit(persona);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void eliminar(@PathParam("id") Integer id){
        servicio.delete(id);
    }

    @GET
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public String hola(){
        return "Hola mundo desde Persona Rest";
    }

}
