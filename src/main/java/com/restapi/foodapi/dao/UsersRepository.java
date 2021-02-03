package com.restapi.foodapi.dao;

import com.restapi.foodapi.entity.Roles;
import com.restapi.foodapi.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users , Long> {
    Optional<Users> findByEmail(String email);
}
