package com.jorgelondono.pruebastaff.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jorgelondono.pruebastaff.entities.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

    public Optional<Usuario> findOneByNombre(String nombre);

}
