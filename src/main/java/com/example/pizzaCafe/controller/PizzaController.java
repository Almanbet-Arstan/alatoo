package com.example.pizzaCafe.controller;

import com.example.pizzaCafe.entity.Pizza;
import com.example.pizzaCafe.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pizza")
public class PizzaController {
    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public List<Pizza> getAll(){
        return pizzaService.getAll();
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model){
        Pizza pizza = pizzaService.getById(id);
        model.addAttribute(pizza);
        return "pizza";
    }

    @PostMapping
    public Pizza createPizza(@RequestBody Pizza pizza){
        return pizzaService.createPizza(pizza);
    }

    @PutMapping
    public Pizza updatePizza(@RequestBody Pizza pizza){
        return pizzaService.updatePizza(pizza);
    }

    @DeleteMapping("/{id}")
    public Pizza deleteById(@PathVariable Long id){
        return pizzaService.deleteById(id);
    }
}
