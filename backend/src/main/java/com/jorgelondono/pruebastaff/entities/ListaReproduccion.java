package com.jorgelondono.pruebastaff.entities;

import java.util.*;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "lista_reproduccion_canciones", joinColumns = @JoinColumn(name = "lista_reproduccion_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "canciones_id", referencedColumnName = "id"))
    private Set<Canciones> canciones = new HashSet<>();

}
