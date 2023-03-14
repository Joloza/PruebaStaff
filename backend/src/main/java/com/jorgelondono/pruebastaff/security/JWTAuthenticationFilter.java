package com.jorgelondono.pruebastaff.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jorgelondono.pruebastaff.model.UsuarioDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	@Autowired
    private UsuarioDTO usuarioDTO;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse reponse)
            throws AuthenticationException {    	

        try {
        	usuarioDTO = new ObjectMapper().readValue(request.getReader(), UsuarioDTO.class);
        } catch (IOException e) {
            System.err.println("ERROR attemptAuthentication "+e);
        }

        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
        		usuarioDTO.getNombre(), usuarioDTO.getContrasena(), Collections.emptyList());

        return getAuthenticationManager().authenticate(usernamePAT);

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse reponse, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {

        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
        String token = TokenUtilis.createToken(userDetails.getUsername());

        reponse.addHeader("Authorization","Bearer "+token);
        reponse.getWriter().flush();

        super.successfulAuthentication(request, reponse, chain, authResult);

    }

}
