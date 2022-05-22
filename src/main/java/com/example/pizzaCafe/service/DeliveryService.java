package com.example.pizzaCafe.service;

import com.example.pizzaCafe.entity.Delivery;

import java.util.List;

public interface DeliveryService {
    Delivery createDelivery(Delivery delivery);
    List<Delivery> getAll();
    Delivery getById(Long id);
    Delivery updateDelivery(Delivery delivery);
    Delivery deleteById(Long id);
}
