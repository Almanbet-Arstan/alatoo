package com.example.pizzaCafe.controller;

import com.example.pizzaCafe.entity.Image;
import com.example.pizzaCafe.entity.User;
import com.example.pizzaCafe.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping
    public List<Image> getAll() {
        return imageService.getAll();
    }

    @PostMapping
    public Image saveImage(File file) {
        return imageService.saveImage(file);
    }

    @GetMapping("/{id}")
    public byte[] getById(@PathVariable Long id){
        return imageService.getById(id);
    }
}
