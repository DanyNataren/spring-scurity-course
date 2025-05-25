package com.danielflores.app_security.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

/***
 * Project: Spring security course
 * Package: com.danielflores.app_security.security
 * Created by Kevin Daniel Flores Nataren
 * File created at 05/May/2025 at 13:32
 * All rights reserved 2025.
 **/


public class ApiKeyFilter extends OncePerRequestFilter {
    private static final String API_KEY = "myKey";
    private static final String API_KEY_HEADER = "api_key";
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            final var apiKeyOpt = Optional.of(request.getHeader(API_KEY_HEADER));
            final var apiKey = apiKeyOpt.orElseThrow(() -> new BadCredentialsException("No header api key provided"));
            if (!apiKey.equals(API_KEY)) throw new BadCredentialsException("Invalid api key");
        }catch (Exception e) {
            throw new BadCredentialsException(e.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}
