package com.uts.inventariotienda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private int idProveedor;

    @Column(name = "nombre_proveedor", unique = true, nullable = false)
    private String nombreProveedor;

    @Column(name = "contacto_proveedor")
    private String contactoProveedor;
}