package com.jorgelondono.pruebastaff.security;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public userDetails loadUserByUserName(String email) throws UsernameNotFoundException {
        usuarioDao
    }

}
