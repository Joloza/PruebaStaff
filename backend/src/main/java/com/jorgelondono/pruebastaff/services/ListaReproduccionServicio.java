package com.jorgelondono.pruebastaff.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jorgelondono.pruebastaff.entities.ListaReproduccion;
import com.jorgelondono.pruebastaff.model.ListaReproduccionDTO;

public interface ListaReproduccionServicio {
	
	public ResponseEntity<ListaReproduccion> crearLista(ListaReproduccionDTO listaDTO);
	public List<ListaReproduccion> consultarLista();
	public ResponseEntity<Void> borrarLista(ListaReproduccionDTO listaDTO);
	
}
