package com.restapi.foodapi.dao;

import com.restapi.foodapi.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
