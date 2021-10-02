package com.programacion.dto;

import com.programacion.entidades.TipoDireccion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class PersonaDto {

    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String cedula;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private TipoDireccion direccion;

}
