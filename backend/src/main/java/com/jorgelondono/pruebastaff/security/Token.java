package com.jorgelondono.pruebastaff.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.*;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class Token {

    private final static String ACCESS_TOKER_SECRET = "OiJIUzI1NiIsInR5cCI6I";
    private final static int ACCESS_TOKER_VALID_SECONDS = 1800;

    public static String createToken(String nombre, String email) {
        long expirationTime = ACCESS_TOKER_VALID_SECONDS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKER_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {

        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKER_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        } catch (JwtException e) {
            return null;
        }

    }

}
