package com.programacion.servicio;

import com.programacion.dto.PersonaDto;
import com.programacion.entidades.Persona;
import com.programacion.entidades.TipoDireccion;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ServicioPersonaImp implements ServicioPersona{

    @PersistenceContext
    private EntityManager emp;

    @Override
    @Transactional
    public void create(Persona persona) {

        emp.persist(persona);

    }

    @Override
    public PersonaDto find(Integer id) {

       Persona obj =  emp.find(Persona.class,id);
       return new PersonaDto(obj.getId() ,obj.getCedula(), obj.getNombre(), new TipoDireccion());
       //return emp.find(Persona.class,id);

    }

    @Override
    public List<Persona> findAll() {
        return emp.createQuery("select p from Persona p", Persona.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void edit(Persona persona) {

        emp.merge(persona);

    }

    @Override
    @Transactional
    public void delete(Integer id) {

        emp.remove(id);

    }
}
