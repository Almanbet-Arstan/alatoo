package com.example.pizzaCafe.service;

import com.example.pizzaCafe.entity.Pizza;

import java.util.List;

public interface PizzaService {
    Pizza createPizza(Pizza pizza);
    List<Pizza> getAll();
    Pizza getById(Long id);
    Pizza updatePizza(Pizza pizza);
    Pizza deleteById(Long id);
}
