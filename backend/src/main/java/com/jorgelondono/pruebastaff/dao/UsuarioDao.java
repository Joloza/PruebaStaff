package com.jorgelondono.pruebastaff.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jorgelondono.pruebastaff.entities.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findOneByEmail(String email);

}
