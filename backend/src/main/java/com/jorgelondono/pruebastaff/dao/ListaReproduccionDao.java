package com.jorgelondono.pruebastaff.dao;

import org.springframework.data.repository.CrudRepository;

import com.jorgelondono.pruebastaff.entities.ListaReproduccion;

public interface ListaReproduccionDao extends CrudRepository<ListaReproduccion, Integer> {

    Iterable<ListaReproduccion> findDescripcionByNombreContaining(String nombre);

    boolean existsByNombre(String nombre);

    void deleteByNombre(String nombre);

}
