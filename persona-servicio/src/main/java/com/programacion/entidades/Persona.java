package com.programacion.entidades;

import lombok.Getter;
import lombok.Setter;
import org.jboss.weld.executor.TimingOutFixedThreadPoolExecutorServices;

import javax.persistence.*;

@Entity
@Table(name="persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    //@SequenceGenerator(name = "category_local_seq", sequenceName = "persona_id_seq", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.AUTO, generator = "category_local_seq")
    private Integer id;

    @Getter @Setter
    private String cedula;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    @Column(name = "tipo_direccion_id")
    private Integer direccionId;



}
