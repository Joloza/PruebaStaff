package com.jorgelondono.pruebastaff.services;

import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jorgelondono.pruebastaff.entities.Canciones;
import com.jorgelondono.pruebastaff.entities.ListaReproduccion;
import com.jorgelondono.pruebastaff.model.ListaReproduccionDTO;
import com.jorgelondono.pruebastaff.model.CancionesDTO;
import com.jorgelondono.pruebastaff.repository.ListaReproduccionDAO;

@Service
public class ListaReproduccionServicioImpl implements ListaReproduccionServicio{
	
	@Autowired
	private ListaReproduccionDAO listaDao;

	@Override
	public ResponseEntity<ListaReproduccion> crearLista(ListaReproduccionDTO listaDTO) {
		
		
		if(listaDTO.getNombre().isEmpty()) {
			
			return ResponseEntity.badRequest().build();
			
		}else if(listaDTO.getDescripcion().isEmpty()) {
			
			return ResponseEntity.badRequest().build();
			
		}else if (listaDao.existsByNombre(listaDTO.getNombre())){
						
			return ResponseEntity.badRequest().build();
			 
		} else {
			ListaReproduccion lista = new ListaReproduccion();			

		    BeanUtils.copyProperties(listaDTO, lista);
		
		    // Obtener las canciones de la solicitud y agregarlas a la lista
		    Set<Canciones> canciones = new HashSet<>();
		    for(CancionesDTO cancionDTO : listaDTO.getCanciones()) {
		        Canciones cancion = new Canciones();
		        BeanUtils.copyProperties(cancionDTO, cancion);
		        canciones.add(cancion);
		    }
		    lista.setCanciones(canciones);
				    
		    ListaReproduccion listaGuardada = listaDao.save(lista);
		    return ResponseEntity.status(HttpStatus.CREATED).body(listaGuardada);
		}
		
	}

	@Override
	public List<ListaReproduccion> consultarLista() {
		return listaDao.findAll();
	}

	@Override
	public ResponseEntity<Void> borrarLista(ListaReproduccionDTO listaDTO) {
		if (listaDao.existsByNombre(listaDTO.getNombre())) {
            listaDao.deleteByNombre(listaDTO.getNombre());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
	}


}
