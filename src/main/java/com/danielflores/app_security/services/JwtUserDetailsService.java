package com.danielflores.app_security.services;

import com.danielflores.app_security.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/***
 * Project: Spring security course
 * Package: com.danielflores.app_security.security
 * Created by Kevin Daniel Flores Nataren
 * File created at 05/May/2025 at 13:46
 * All rights reserved 2025.
 **/

@Service
@AllArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository.findByEmail(username).map(c -> {
           final var authorities = c.getRoles().stream()
                   .map(r -> new SimpleGrantedAuthority(r.getName()))
                   .collect(Collectors.toList());
            return new User(c.getEmail(), c.getPassword(), authorities);
        }).orElseThrow(() -> new UsernameNotFoundException("User not exists"));
    }
}
