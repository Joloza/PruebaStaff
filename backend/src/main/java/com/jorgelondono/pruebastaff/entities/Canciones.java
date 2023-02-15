package com.jorgelondono.pruebastaff.entities;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Canciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = true)
    private String artista;

    @Column(nullable = true)
    private String album;

    @Column(nullable = true)
    private String anno;

    @Column(nullable = true)
    private String genero;
}
