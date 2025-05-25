package com.danielflores.app_security.security;

import com.danielflores.app_security.services.JwtService;
import com.danielflores.app_security.services.JwtUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

/***
 * Project: Spring security course
 * Package: com.danielflores.app_security.security
 * Created by Kevin Daniel Flores Nataren
 * File created at 05/May/2025 at 15:10
 * All rights reserved 2025.
 **/

@Component
@AllArgsConstructor
@Slf4j
public class JwtValidationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final JwtUserDetailsService jwtUserDetailsService;
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        final var requestTokenHeader = request.getHeader(AUTHORIZATION_HEADER);
        String username = null;
        String jwt = null;
        if(Objects.nonNull(requestTokenHeader) && requestTokenHeader.startsWith(BEARER_PREFIX)) {
            jwt = requestTokenHeader.substring(BEARER_PREFIX.length());
            try {
                username = jwtService.getUsernameFromToken(jwt);
            }catch (IllegalArgumentException e) {
                log.error(e.getMessage());
            }catch (ExpiredJwtException e){
                log.warn(e.getMessage());
            }
            if( Objects.nonNull(username) && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())) {
                final var userDetails = jwtUserDetailsService.loadUserByUsername(username);
                if (this.jwtService.validateToken(jwt, userDetails)) {
                    var usernameAndPasswordAuthToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities()
                    );
                    SecurityContextHolder.getContext().setAuthentication(usernameAndPasswordAuthToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
