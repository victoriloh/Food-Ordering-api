package com.restapi.foodapi.service;

import com.restapi.foodapi.entity.Menu;
import com.restapi.foodapi.entity.Order;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    List<Menu> findAll();
    Optional<Menu> findById(Long theId);
    void save(Menu menu);
    void deleteById(Long theId);
}
