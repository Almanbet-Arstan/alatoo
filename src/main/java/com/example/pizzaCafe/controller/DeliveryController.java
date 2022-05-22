package com.example.pizzaCafe.controller;


import com.example.pizzaCafe.entity.Delivery;
import com.example.pizzaCafe.service.DeliveryService;
import com.example.pizzaCafe.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping
    public List<Delivery> getAll(){
        return deliveryService.getAll();
    }

    @GetMapping("/{id}")
    public Delivery getById(@PathVariable Long id){
        return deliveryService.getById(id);
    }

    @PostMapping
    public Delivery createDelivery(@RequestBody Delivery delivery){
        return deliveryService.createDelivery(delivery);
    }

    @PutMapping
    public Delivery updateDelivery(@RequestBody Delivery delivery){
        return deliveryService.updateDelivery(delivery);
    }

    @DeleteMapping("/{id}")
    public Delivery deleteById(@PathVariable Long id){
        return deliveryService.deleteById(id);
    }
}
