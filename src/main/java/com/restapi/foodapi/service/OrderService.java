package com.restapi.foodapi.service;

import com.restapi.foodapi.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> findAll();
    Optional<Order> findById(Long theId);
    void save(Order order);
    void deleteById(Long theId);
}
