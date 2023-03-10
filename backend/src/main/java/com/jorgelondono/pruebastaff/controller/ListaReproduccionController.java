package com.jorgelondono.pruebastaff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import com.jorgelondono.pruebastaff.entities.ListaReproduccion;
import com.jorgelondono.pruebastaff.entities.Usuario;
import com.jorgelondono.pruebastaff.model.ListaReproduccionDTO;
import com.jorgelondono.pruebastaff.repository.ListaReproduccionDAO;
import com.jorgelondono.pruebastaff.services.ListaReproduccionServicio;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ListaReproduccionController {
	
    @Autowired
    private ListaReproduccionServicio listaServicio;
    
    // POST
    @Transactional
    @PostMapping("/lists")
    public ResponseEntity<ListaReproduccion> crearLista(@RequestBody ListaReproduccionDTO listaDTO) {    	
    	return listaServicio.crearLista(listaDTO);   	
    }
 
    @Transactional
    @GetMapping("/lists")
    public List<ListaReproduccion> consultarUsuario() {
        return listaServicio.consultarLista();
    }

    // GET NOMBRE
    /*@GetMapping("/lists/listName")
    public ResponseEntity<Iterable<ListaReproduccion>> consultarDescripcion(@RequestParam String nombre) {
        Iterable<ListaReproduccion> listas = listaDao.findDescripcionByNombreContaining(nombre);
        if (listas.iterator().hasNext()) {
            return ResponseEntity.ok(listas);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    // DELETE
    /*@Transactional
    @DeleteMapping("/lists/listName")
    public ResponseEntity<Void> borrarLista(@RequestParam String nombre) {
        
    }*/
    
    @Transactional
    @DeleteMapping("/lists/listName")
    public ResponseEntity<Void> borrarLista(@RequestBody ListaReproduccionDTO listaDTO) {
		return listaServicio.borrarLista(listaDTO);        
    }

}
