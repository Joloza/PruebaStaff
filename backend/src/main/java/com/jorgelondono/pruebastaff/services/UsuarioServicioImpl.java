package com.jorgelondono.pruebastaff.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jorgelondono.pruebastaff.entities.Usuario;
import com.jorgelondono.pruebastaff.model.UsuarioDTO;
import com.jorgelondono.pruebastaff.repository.UsuarioDAO;
import com.jorgelondono.pruebastaff.security.UserDetailsImpl;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {
	
	private BCryptPasswordEncoder passwordEncoder;

    public UsuarioServicioImpl(@Lazy BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
	
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
			Usuario usuario= new Usuario(usuarioDTO.getNombre(), passwordEncoder.encode(usuarioDTO.getContrasena()));
			Usuario usuarioGuardado = usuarioDao.save(usuario);
			result = ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado);
		}	
		return result;
	}

	@Override
	public List<Usuario> consultarUsuario() {
		return usuarioDao.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao
				.findOneByNombre(nombre)
				.orElseThrow(()-> new UsernameNotFoundException("El usuario con nombre "+nombre+" no existe"));
				
		return new UserDetailsImpl(usuario);
	}
	
}
