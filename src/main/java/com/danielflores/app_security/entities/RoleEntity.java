package com.danielflores.app_security.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

/***
 * Project: Spring security course
 * Package: com.danielflores.app_security.entities
 * Created by Kevin Daniel Flores Nataren
 * File created at 05/May/2025 at 12:54
 * All rights reserved 2025.
 **/

@Entity(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Column(name = "role_name")
    private String name;
    private String description;

}
