package com.danielflores.app_security.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * Project: Spring security course
 * Package: com.danielflores.app_security.entities
 * Created by Kevin Daniel Flores Nataren
 * File created at 05/May/2025 at 15:00
 * All rights reserved 2025.
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtRequest {
    private String email;
    private String password;
}
