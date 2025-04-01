package com.uts.inventariotienda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "desarrollador")
public class Desarrollador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_desarrollador")
    private int idDesarrollador;

    @Column(name = "nombre_desarrollador", unique = true, nullable = false)
    private String nombreDesarrollador;
}