package com.jorgelondono.pruebastaff.dao;

import org.springframework.data.repository.CrudRepository;

import com.jorgelondono.pruebastaff.entities.ListaReproduccion;

public interface ListaReproduccionDao extends CrudRepository<ListaReproduccion, Integer> {

    Iterable<ListaReproduccion> findDescripcionByNombre(String nombre);

}
