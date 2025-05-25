package com.danielflores.app_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringSecurityCourseApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityCourseApplication.class, args);
    }
}
