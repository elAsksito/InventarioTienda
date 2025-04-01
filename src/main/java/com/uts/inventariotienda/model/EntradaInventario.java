package com.uts.inventariotienda.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "entrada_inventario")
public class EntradaInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrada")
    private int idEntrada;

    @ManyToOne
    @JoinColumn(name = "id_juego")
    private Juego juego;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "precio_compra", nullable = false)
    private double precioCompra;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_entrada", nullable = false)
    private Date fechaEntrada = new Date();
}