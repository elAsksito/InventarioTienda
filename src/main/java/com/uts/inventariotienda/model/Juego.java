package com.uts.inventariotienda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "juego")
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juego")
    private int idJuego;

    @Column(name = "titulo_juego", nullable = false)
    private String tituloJuego;

    @Column(name = "descripcion_juego")
    private String descripcionJuego;

    @Column(name = "precio_juego", nullable = false)
    private double precioJuego;

    @Column(name = "stock_juego", nullable = false)
    private int stockJuego;

    @Column(name = "anio_lanzamiento_juego", nullable = false)
    private int anioLanzamientoJuego;

    @Column(name = "imagen_url")
    private String imagenUrl;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_desarrollador")
    private Desarrollador desarrollador;

}