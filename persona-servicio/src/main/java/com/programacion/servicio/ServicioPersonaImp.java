package com.programacion.servicio;

import com.programacion.dto.PersonaDto;
import com.programacion.entidades.Persona;
import com.programacion.entidades.TipoDireccion;
import com.programacion.proxy.TipoDireccionRest;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ServicioPersonaImp implements ServicioPersona{

    @PersistenceContext
    private EntityManager emp;

    @Inject
    private TipoDireccionRest microServicioDirec;

    @Override
    @Transactional
    public void create(Persona persona) {

        emp.persist(persona);

    }

    @Override
    public PersonaDto find(Integer id) {

       Persona obj =  emp.find(Persona.class,id);
       TipoDireccion tipoDireccion = microServicioDirec.listarPorId(obj.getDireccionId());
       //System.out.println(tipoDireccion.getDescripcion());
       return new PersonaDto(obj.getCedula(), obj.getNombre(),tipoDireccion);
       //return emp.find(Persona.class,id);

    }

    @Override
    public List<PersonaDto> findAll() {

       //return emp.createQuery("select p from Persona p", Persona.class)
        // .getResultList();

        List<Persona> listado = emp.createQuery("select p from Persona p", Persona.class).getResultList();
        List<PersonaDto> listadoDto = new ArrayList<>();
        for (Persona persona:listado) {
            TipoDireccion tipoDireccion = microServicioDirec.listarPorId(persona.getDireccionId());
            listadoDto.add(new PersonaDto(persona.getCedula(), persona.getNombre(),tipoDireccion));
        }
        return listadoDto;
    }

    @Override
    @Transactional
    public void edit(Persona persona) {

        emp.merge(persona);

    }

    @Override
    @Transactional
    public void delete(Integer id) {

        emp.remove(find(id));

    }
}
