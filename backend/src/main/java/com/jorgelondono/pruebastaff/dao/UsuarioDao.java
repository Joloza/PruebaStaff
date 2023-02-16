package com.jorgelondono.pruebastaff.dao;

import org.springframework.data.repository.CrudRepository;

import com.jorgelondono.pruebastaff.entities.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Integer> {
}
