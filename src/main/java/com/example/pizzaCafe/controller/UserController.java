package com.example.pizzaCafe.controller;

import com.example.pizzaCafe.entity.User;
import com.example.pizzaCafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String signup(Model model) {
        User user = new User();
        model.addAttribute("newUser", user);
        return "signup";
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public User deleteById(@PathVariable Long id){
        return userService.deleteById(id);
    }
}
