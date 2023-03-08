package com.jorgelondono.pruebastaff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorgelondono.pruebastaff.entities.ListaReproduccion;

public interface ListaReproduccionDAO extends JpaRepository<ListaReproduccion, Integer> {

    public List<ListaReproduccion> findDescripcionByNombreContaining(String nombre);

    public boolean existsByNombre(String nombre);

    public void deleteByNombre(String nombre);

}
