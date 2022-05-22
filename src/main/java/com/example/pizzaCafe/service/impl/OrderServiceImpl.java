package com.example.pizzaCafe.service.impl;

import com.example.pizzaCafe.entity.Order;
import com.example.pizzaCafe.repository.OrderRepository;
import com.example.pizzaCafe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order updateOrder(Order order) {
        Order orderForUpdate = getById(order.getId());

        if (order.getPizzas() != null) orderForUpdate.setPizzas(order.getPizzas());

        return orderRepository.save(orderForUpdate);
    }

    @Override
    public Order deleteById(Long id) {
        Order orderForDelete = getById(id);
        if (orderForDelete != null) orderRepository.delete(orderForDelete);

        return orderForDelete;
    }
}
