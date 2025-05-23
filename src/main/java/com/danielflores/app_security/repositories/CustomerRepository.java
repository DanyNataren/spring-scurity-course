package com.danielflores.app_security.repositories;

import com.danielflores.app_security.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.Optional;

/***
 * Project: Spring security course
 * Package: com.danielflores.app_security.repositories
 * Created by Kevin Daniel Flores Nataren
 * File created at 05/May/2025 at 15:02
 * All rights reserved 2025.
 **/
public interface CustomerRepository extends CrudRepository<CustomerEntity, BigInteger> {
    Optional<CustomerEntity> findByEmail(String email);
}
