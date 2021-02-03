package com.restapi.foodapi.service;

import com.restapi.foodapi.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<Users> findAll();
    Optional<Users> findById(Long theId);
    Users save(Users users);
    void deleteById(Long theId);
 //   Optional<Object> findByEmail(String email);


//    ResponseEntity<Object> createUser(Users user);
//
//    ResponseEntity<Object> deleteById(Long id);
//
//    ResponseEntity<Object> updateUser(Users user, Long id);
}
