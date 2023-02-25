package com.jorgelondono.pruebastaff.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jorgelondono.pruebastaff.entities.Usuario;
import com.jorgelondono.pruebastaff.model.UsuarioDTO;
import com.jorgelondono.pruebastaff.repository.UsuarioDAO;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {
	
	@Autowired
	private UsuarioDAO usuarioDao;

	@Override
	public ResponseEntity<Usuario> registrarUsuario(UsuarioDTO usuarioDTO)  {
		
		ResponseEntity<Usuario> result=null;
				
		if(usuarioDTO.getNombre().isEmpty()) {					
			
			result = ResponseEntity.badRequest().build();
			
		}else if(usuarioDTO.getContrasena().isEmpty()) {
			result = ResponseEntity.badRequest().build();
		} else {
			Usuario usuario= new Usuario(usuarioDTO.getNombre(),usuarioDTO.getContrasena());
			Usuario usuarioGuardado = usuarioDao.save(usuario);
			result = ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado);
		}	
		return result;
	}

	@Override
	public List<Usuario> consultarUsuario() {
		return usuarioDao.findAll();
	}
	
}
