package com.jorgelondono.pruebastaff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jorgelondono.pruebastaff.entities.ListaReproduccion;
import com.jorgelondono.pruebastaff.dao.ListaReproduccionDao;

@CrossOrigin(allowedHeaders = "*")
@RestController
public class Controller {
    @Autowired
    private ListaReproduccionDao listaDao;

    // POST
    @PostMapping("/lists")
    public ListaReproduccion crearLista(@RequestBody ListaReproduccion nuevaLista) {
        return listaDao.save(nuevaLista);
    }

    // GET
    @GetMapping("/lists")
    public Iterable<ListaReproduccion> consultarLista() {
        return listaDao.findAll();
    }

    @GetMapping("/lists/")
    public Iterable<ListaReproduccion> consultarDescripcion(@RequestParam String descripcion) {
        return listaDao.findListaReproduccionDaoByDescripcion(descripcion);
    }

    // DELETE
    @GetMapping("/lists/listName")
    public void borrarLista(@RequestParam int id) {
        listaDao.deleteById(id);
    }
}
