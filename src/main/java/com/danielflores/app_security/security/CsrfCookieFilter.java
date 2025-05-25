package com.danielflores.app_security.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

/***
 * Project: Spring security course
 * Package: com.danielflores.app_security.security
 * Created by Kevin Daniel Flores Nataren
 * File created at 05/May/2025 at 12:26
 * All rights reserved 2025.
 **/
public class CsrfCookieFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        var csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        if (Objects.nonNull(csrfToken.getHeaderName())){
            response.setHeader(csrfToken.getHeaderName(), csrfToken.getToken());
        }
        filterChain.doFilter(request, response);
    }
}
