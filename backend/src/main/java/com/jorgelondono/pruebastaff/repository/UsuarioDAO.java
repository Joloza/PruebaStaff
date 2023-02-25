package com.jorgelondono.pruebastaff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jorgelondono.pruebastaff.entities.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

    Iterable<Usuario> findByNombre(String nombre);

}
