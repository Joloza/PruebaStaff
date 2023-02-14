package com.jorgelondono.pruebastaff.entities;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class ListaReproduccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = true)
    private String descripcion;

    @ElementCollection
    @Column()
    private List<String> cancion;

}
