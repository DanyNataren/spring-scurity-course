package com.danielflores.app_security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

/***
 * Project: Spring security course
 * Package: com.danielflores.app_security.entities
 * Created by Kevin Daniel Flores Nataren
 * File created at 05/May/2025 at 14:59
 * All rights reserved 2025.
 **/

@Entity(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerEntity {
    @Id
    private BigInteger id;
    private String email;
    @Column(name = "pwd")
    private String password;
    @Column(name = "rol")
    private String role;
}
