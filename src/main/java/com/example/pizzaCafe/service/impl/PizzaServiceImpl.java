package com.example.pizzaCafe.service.impl;

import com.example.pizzaCafe.entity.Pizza;
import com.example.pizzaCafe.entity.User;
import com.example.pizzaCafe.repository.PizzaRepository;
import com.example.pizzaCafe.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PizzaServiceImpl implements PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;
    @Override
    public Pizza createPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    @Override
    public List<Pizza> getAll() {
        return pizzaRepository.findAll();
    }

    @Override
    public Pizza getById(Long id) {
        return pizzaRepository.findById(id).orElse(null);
    }

    @Override
    public Pizza updatePizza(Pizza pizza) {
        Pizza pizzaForUpdate = getById(pizza.getId());

        if (pizza.getPizzaName() != null) pizzaForUpdate.setPizzaName(pizza.getPizzaName());
        if (pizza.getPrice() != null) pizzaForUpdate.setPrice(pizza.getPrice());
        if (pizza.getComposition() != null) pizzaForUpdate.setComposition(pizza.getComposition());

        return pizzaRepository.save(pizzaForUpdate);
    }

    @Override
    public Pizza deleteById(Long id) {
        Pizza pizzaForDelete = getById(id);
        if (pizzaForDelete != null) pizzaRepository.delete(pizzaForDelete);

        return pizzaForDelete;
    }
}
