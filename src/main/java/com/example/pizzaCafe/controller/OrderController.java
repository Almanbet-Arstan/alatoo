package com.example.pizzaCafe.controller;

import com.example.pizzaCafe.entity.Order;
import com.example.pizzaCafe.service.OrderService;
import com.example.pizzaCafe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id){
        return orderService.getById(id);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @PutMapping
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    public Order deleteById(@PathVariable Long id){
        return orderService.deleteById(id);
    }
}
