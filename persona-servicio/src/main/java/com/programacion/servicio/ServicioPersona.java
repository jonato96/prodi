package com.programacion.servicio;

import com.programacion.dto.PersonaDto;
import com.programacion.entidades.Persona;
import java.util.List;

public interface ServicioPersona {

    void create(Persona persona);
    PersonaDto find (Integer id);
    List<PersonaDto> findAll();
    void edit(Persona persona);
    void delete (Integer id);

}
