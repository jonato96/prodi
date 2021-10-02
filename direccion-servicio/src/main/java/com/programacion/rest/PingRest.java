package com.programacion.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ping")
public class PingRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String ping(){
        return "OK";
    }

}
