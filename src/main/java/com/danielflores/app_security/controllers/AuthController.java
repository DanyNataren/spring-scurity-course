package com.danielflores.app_security.controllers;

import com.danielflores.app_security.entities.JwtRequest;
import com.danielflores.app_security.entities.JwtResponse;
import com.danielflores.app_security.services.JwtService;
import com.danielflores.app_security.services.JwtUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * Project: Spring security course
 * Package: com.danielflores.app_security.controllers
 * Created by Kevin Daniel Flores Nataren
 * File created at 05/May/2025 at 14:58
 * All rights reserved 2025.
 **/

@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUserDetailsService jwtUserDetailsService;
    private final JwtService jwtService;

    @PostMapping("login")
    public ResponseEntity<?> postToken(@RequestBody JwtRequest jwtRequest) {
        this.authenticate(jwtRequest);
        final var userDetails = jwtUserDetailsService.loadUserByUsername(jwtRequest.getEmail());
        final String token = jwtService.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(JwtRequest jwtRequest) {
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
        }catch (BadCredentialsException | DisabledException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
