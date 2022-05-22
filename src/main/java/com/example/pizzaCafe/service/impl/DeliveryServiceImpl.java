package com.example.pizzaCafe.service.impl;

import com.example.pizzaCafe.entity.Delivery;
import com.example.pizzaCafe.entity.Order;
import com.example.pizzaCafe.repository.DeliveryRepository;
import com.example.pizzaCafe.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Override
    public Delivery createDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public List<Delivery> getAll() {
        return deliveryRepository.findAll();
    }

    @Override
    public Delivery getById(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    @Override
    public Delivery updateDelivery(Delivery delivery) {
        Delivery deliveryForUpdate = getById(delivery.getId());

        if (delivery.getAddress() != null) deliveryForUpdate.setAddress(delivery.getAddress());

        return deliveryRepository.save(deliveryForUpdate);
    }

    @Override
    public Delivery deleteById(Long id) {
        Delivery deliveryForDelete = getById(id);
        if (deliveryForDelete != null) deliveryRepository.delete(deliveryForDelete);

        return deliveryForDelete;
    }
}
