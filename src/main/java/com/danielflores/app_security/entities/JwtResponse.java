package com.danielflores.app_security.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * Project: Spring security course
 * Package: com.danielflores.app_security.entities
 * Created by Kevin Daniel Flores Nataren
 * File created at 05/May/2025 at 15:03
 * All rights reserved 2025.
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JwtResponse {
    private String token;
}
