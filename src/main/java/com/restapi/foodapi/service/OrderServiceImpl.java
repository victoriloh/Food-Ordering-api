package com.restapi.foodapi.service;

import com.restapi.foodapi.dao.OrderRepository;
import com.restapi.foodapi.entity.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Order> findById(Long theId) {
        return orderRepository.findById(theId);
    }

    @Override
    @Transactional
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    @Transactional
    public void deleteById(Long theId) {
        orderRepository.deleteById(theId);
    }
}
