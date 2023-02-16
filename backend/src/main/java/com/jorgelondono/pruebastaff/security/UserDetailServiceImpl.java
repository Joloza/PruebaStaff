package com.jorgelondono.pruebastaff.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jorgelondono.pruebastaff.dao.UsuarioDao;
import com.jorgelondono.pruebastaff.entities.Usuario;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao
                .findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));
        return new UserDetailsImpl(usuario);
    }

}
