package com.jorgelondono.pruebastaff.security;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse reponse)
            throws AuthenticationException {

        AuthCredentials authCredentials = new AuthCredentials();

        try {
            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
        } catch (IOException e) {
            // TODO: handle exception
        }

        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
                authCredentials.getEmail(), authCredentials.getPassword(), Collections.emptyList());

        return getAuthenticationManager().authenticate(usernamePAT);

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse reponse, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {

        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
        String token = TokenUtilis.createToken(userDetails.getNombre(), userDetails.getUsername());

        reponse.addHeader("Authorization", "Bearer" + token);
        reponse.getWriter().flush();

        super.successfulAuthentication(request, reponse, chain, authResult);

    }

}
