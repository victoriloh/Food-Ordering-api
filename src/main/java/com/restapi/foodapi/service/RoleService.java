package com.restapi.foodapi.service;

import com.restapi.foodapi.entity.Roles;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Roles> findAll();
    Optional<Roles> findById(Long theId);
    String save(Roles users);
    String deleteById(Long theId);
    Optional<Object> findByEmail(String email);
}
