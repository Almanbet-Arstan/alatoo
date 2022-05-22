package com.example.pizzaCafe.controller;

import com.example.pizzaCafe.entity.Image;
import com.example.pizzaCafe.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.sql.Blob;
import java.sql.SQLException;

@Controller
public class MainController {
    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("pizzas",pizzaService.getAll());
        return "index";
    }
}
