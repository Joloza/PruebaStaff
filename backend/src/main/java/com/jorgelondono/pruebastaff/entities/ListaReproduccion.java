package com.jorgelondono.pruebastaff.entities;

import java.util.*;

import javax.persistence.*;

import com.jorgelondono.pruebastaff.model.CancionesDTO;


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
    
    /*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "playlist_id")
    private List<Canciones> canciones = new ArrayList<>();*/
    
    public ListaReproduccion(String nombre, String descripcion, Set<Canciones> canciones) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.canciones = canciones;
	}
    
    public ListaReproduccion() {
		super();
	}
  
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Canciones> getCanciones() {
		return canciones;
	}

	public void setCanciones(Set<Canciones> canciones2) {
		this.canciones = canciones2;
	}
    

}
