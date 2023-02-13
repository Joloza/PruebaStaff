package com.jorgelondono.pruebastaff.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity

public class ListaReproduccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 6)
    private String nombre;

    @Column(nullable = true, length = 20)
    private String descripcion;

    @Column(nullable = true, length = 10)
    private Object canciones;

}