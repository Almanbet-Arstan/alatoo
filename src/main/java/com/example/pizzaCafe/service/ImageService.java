package com.example.pizzaCafe.service;

import com.example.pizzaCafe.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface ImageService {
    List<Image> getAll();
    String saveImageInCloudinary(File file);
    Image saveImageInDB(String url);
    Image saveImage(File file);
    byte[] getById(Long id);
}
