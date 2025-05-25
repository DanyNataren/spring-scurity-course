package com.danielflores.app_security.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;

/***
 * Project: Spring security course
 * Package: com.danielflores.app_security.security
 * Created by Kevin Daniel Flores Nataren
 * File created at 05/May/2025 at 13:51
 * All rights reserved 2025.
 **/
@Service

public class JwtService {
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    public static final String JWT_SECRET = "jxgEQE.XHuPq8VdbyYFNkAN.dudQ0903yUn4";
    private Claims getAllclaims(String token) {
        final var key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T getClaimsFromToken(String token, Function<Claims, T> claimsResolver) {
        final var claims = getAllclaims(token);
        return claimsResolver.apply(claims);
    }
    private Date getExpirationDateFromToken(String token) {
        return getClaimsFromToken(token, Claims::getExpiration);
    }
    private Boolean isTokenExpired(String token) {
        final var expirationdate = getExpirationDateFromToken(token);
        return expirationdate.before(new Date());
    }

    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token, Claims::getSubject);
    }

    public String generateToken(UserDetails userDetails) {
        final Map<String, Object> claims = Collections.singletonMap("ROLES", userDetails.getAuthorities().toString());
        return getToken(claims, userDetails.getUsername());
    }

    private String getToken(Map<String, Object> claims, String subject) {
        final var key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(key)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final var usernameFromUserDetails = userDetails.getUsername();
        final var usernameFromJwt = getUsernameFromToken(token);
        return (usernameFromUserDetails.equals(usernameFromJwt) && !isTokenExpired(token));
    }
}
