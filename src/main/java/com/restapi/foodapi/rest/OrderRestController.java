package com.restapi.foodapi.rest;

import com.restapi.foodapi.entity.Order;
import com.restapi.foodapi.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class OrderRestController {

    private OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public List<Order> getOrder() {
        return orderService.findAll();
    }

    @GetMapping("/order/{orderId}")
    public Optional<Order> getOrderById(@PathVariable Long orderId) {
        Optional<Order> order = orderService.findById(orderId);
        if (order == null){
            throw new RuntimeException("Order id not found -" +orderId);
        }
        return order;
    }

    @PostMapping("/order")
    public Order saveId(@RequestBody Order order){
        order.setId((long) 0);
        orderService.save(order);
        return order;
    }
    @PutMapping("/order")
    public Order updateEmployee(@RequestBody Order order){
        orderService.save(order);
        return order;
    }
    @DeleteMapping("/order/{orderId}")
    public String deleteId(@PathVariable Long orderId){
        Optional<Order> order = orderService.findById(orderId);
        if (order == null){
            throw new RuntimeException("Order id not found -" +orderId);
        }
        orderService.deleteById(orderId);
        return "Deleted Order id - " + orderId;
    }

}
