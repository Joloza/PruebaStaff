package com.jorgelondono.pruebastaff.controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.jorgelondono.pruebastaff.entities.ListaReproduccion;
import com.jorgelondono.pruebastaff.repository.ListaReproduccionDao;
import com.jorgelondono.pruebastaff.entities.Usuario;
import com.jorgelondono.pruebastaff.model.UsuarioDTO;
import com.jorgelondono.pruebastaff.services.UsuarioServicio;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ListaReproduccionController {
	
    @Autowired
    private UsuarioServicio usuarioServicio;

    /*@Transactional
    @PostMapping("/registrarUsuario")
    public String registrarUsuario(@RequestBody UsuarioDTO usuario) {   	

    	usuarioServicio.registrarUsuario(usuario);
    	
        return "redirect:/registrarUsuario?exito";
    }*/

    /*@Transactional
    @GetMapping("/consultarUsuario")
    public List<Usuario> consultarUsuario() {
        return usuarioServicio.consultarUsuario();
    }*/

    /*@PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDTO usuario) {
        Iterable<Usuario> user = usuarioDao.findByNombre(usuario.getNombre());

        if (user == null || !user.iterator().hasNext()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Credenciales inválidas");
        }

        if (((Usuario) user.iterator().next()).getContrasena().equals(usuario.getContrasena())) {
            return ResponseEntity.ok("Token de acceso");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Credenciales inválidas");
        }
    }

    // POST
    @PostMapping("/lists")
    public ResponseEntity<ListaReproduccion> crearLista(@RequestBody ListaReproduccion nuevaLista) {
        if (nuevaLista.getNombre() == null) {
            return ResponseEntity.badRequest().build();
        } else {
            ListaReproduccion listaGuardada = listaDao.save(nuevaLista);
            return ResponseEntity.status(HttpStatus.CREATED).body(listaGuardada);
        }
    }

    // GET
    @GetMapping("/lists")
    public Iterable<ListaReproduccion> consultarLista() {
        return listaDao.findAll();
    }

    // GET NOMBRE
    @GetMapping("/lists/listName")
    public ResponseEntity<Iterable<ListaReproduccion>> consultarDescripcion(@RequestParam String nombre) {
        Iterable<ListaReproduccion> listas = listaDao.findDescripcionByNombreContaining(nombre);
        if (listas.iterator().hasNext()) {
            return ResponseEntity.ok(listas);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @Transactional
    @DeleteMapping("/lists/listName")
    public ResponseEntity<Void> borrarLista(@RequestParam String nombre) {
        if (listaDao.existsByNombre(nombre)) {
            listaDao.deleteByNombre(nombre);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

}
