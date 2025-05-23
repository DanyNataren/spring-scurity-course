package com.danielflores.app_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/***
 * Project: Spring security course
 * Package: com.danielflores.app_security.security
 * Created by Kevin Daniel Flores Nataren
 * File created at 05/May/2025 at 12:59
 * All rights reserved 2025.
 **/
@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeRequests -> {
            authorizeRequests.requestMatchers("/loans", "/balances", "/accounts", "/cards").authenticated()
                    .anyRequest().permitAll();
        }).formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
