package com.jorgelondono.pruebastaff.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jorgelondono.pruebastaff.entities.Usuario;
import com.jorgelondono.pruebastaff.model.UsuarioDTO;
import com.jorgelondono.pruebastaff.services.UsuarioServicio;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UsuarioController {
	
	@Autowired
    private UsuarioServicio usuarioServicio;

    @Transactional
    @PostMapping("/registrarUsuario")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody UsuarioDTO usuario) {    	   	
        return usuarioServicio.registrarUsuario(usuario);
    }
    
    @Transactional
    @GetMapping("/consultarUsuario")
    public List<Usuario> consultarUsuario() {
        return usuarioServicio.consultarUsuario();
    }

}
