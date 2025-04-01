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
@Table(name = "salidas_inventario")
public class SalidaInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salida")
    private int idSalida;

    @ManyToOne
    @JoinColumn(name = "id_juego")
    private Juego juego;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "precio_venta", nullable = false)
    private double precioVenta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_salida", nullable = false)
    private Date fechaSalida = new Date();
}