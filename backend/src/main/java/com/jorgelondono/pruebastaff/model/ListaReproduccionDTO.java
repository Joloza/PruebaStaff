package com.jorgelondono.pruebastaff.model;

import java.util.List;
import java.util.Set;

import com.jorgelondono.pruebastaff.entities.Canciones;

public class ListaReproduccionDTO {
	
	private String nombre;	
	private String descripcion;
	private List<CancionesDTO> canciones;
	
	public ListaReproduccionDTO(String nombre, String descripcion, List<CancionesDTO> canciones) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.canciones = canciones;
	}
	
	public ListaReproduccionDTO() {
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

	public List<CancionesDTO> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<CancionesDTO> canciones) {
        this.canciones = canciones;
    }

}
