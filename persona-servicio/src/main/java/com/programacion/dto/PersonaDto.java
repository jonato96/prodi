package com.programacion.dto;

import com.programacion.entidades.TipoDireccion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
public class PersonaDto {



    @Getter @Setter
    private String cedula;

    @Getter @Setter
    private String nombre;

//    @Getter @Setter
//    private String direccion;

//    @Getter @Setter
//    private List<TipoDireccion> direccionLista;

    @Getter @Setter
    private TipoDireccion direccion;

}
