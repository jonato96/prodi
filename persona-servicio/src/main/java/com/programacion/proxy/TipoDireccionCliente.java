package com.programacion.proxy;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import java.net.URI;

@ApplicationScoped
public class TipoDireccionCliente {

    public static final String URL = "http://localhost:9091";

    @ApplicationScoped
    @Produces
    public TipoDireccionRest create(){
        TipoDireccionRest servicio = RestClientBuilder.newBuilder()
                .baseUri(URI.create(URL))
                .build(TipoDireccionRest.class);
        return servicio;
    }

}
