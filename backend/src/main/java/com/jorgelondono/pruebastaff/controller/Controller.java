package com.jorgelondono.pruebastaff.controller;

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
import com.jorgelondono.pruebastaff.dao.ListaReproduccionDao;
import com.jorgelondono.pruebastaff.entities.Usuario;
import com.jorgelondono.pruebastaff.dao.UsuarioDao;

@CrossOrigin(allowedHeaders = "*")
@RestController
public class Controller {
    @Autowired
    private ListaReproduccionDao listaDao;

    @Autowired
    private UsuarioDao usuarioDao;

    // usuario

    /*
     * @PostMapping("/registrarUsuario")
     * public ResponseEntity<String> creareUser(@RequestBody Usuario usuario) {
     * Usuario existingUser = usuarioDao.findUsuarioByNombre(usuario.getNombre());
     * if (existingUser != null) {
     * return new ResponseEntity<String>("El usuario ya existe",
     * HttpStatus.CONFLICT);
     * } else {
     * String contrasenaCifrada =
     * bCryptPasswordEncoder.encode(usuario.getContrasena());
     * usuario.setContrasena(contrasenaCifrada);
     * usuarioDao.save(usuario);
     * return new ResponseEntity<String>("Usuario creado", HttpStatus.OK);
     * }
     * }
     */

    @PostMapping("/registrarUsuario")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @GetMapping("/consultarUsuario")
    public Iterable<Usuario> consultarUsuario() {
        return usuarioDao.findAll();
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
    }

}
