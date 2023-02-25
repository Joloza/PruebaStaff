package com.jorgelondono.pruebastaff.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jorgelondono.pruebastaff.entities.Usuario;
import com.jorgelondono.pruebastaff.model.UsuarioDTO;

public interface UsuarioServicio {
	
	public ResponseEntity<Usuario> registrarUsuario(UsuarioDTO usuarioDTO);

	public List<Usuario> consultarUsuario();
}
