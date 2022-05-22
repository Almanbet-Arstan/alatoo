package com.example.pizzaCafe.service;

import com.example.pizzaCafe.entity.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    List<Order> getAll();
    Order getById(Long id);
    Order updateOrder(Order order);
    Order deleteById(Long id);
}
