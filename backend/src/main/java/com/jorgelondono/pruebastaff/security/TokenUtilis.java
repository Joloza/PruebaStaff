package com.jorgelondono.pruebastaff.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.*;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtilis {

    private final static String ACCESS_TOKEN_SECRET = "OiJIUzI1NiIsInR5cCI6I1NiIsInR5cF";
    private final static long ACCESS_TOKEN_VALID_SECONDS = 1800L;

    public static String createToken(String nombre) {
        long expirationTime = ACCESS_TOKEN_VALID_SECONDS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);

        return Jwts.builder()
                .setSubject(nombre)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {

        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String nombre = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(nombre, null, Collections.emptyList());
        } catch (JwtException e) {
        	System.err.println("ERROR UsernamePasswordAuthenticationToken "+e);
            return null;
        }

    }

}
