package com.example.pizzaCafe.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.pizzaCafe.entity.Image;
import com.example.pizzaCafe.repository.ImageRepository;
import com.example.pizzaCafe.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;


    @Override
    public List<Image> getAll() {
        return imageRepository.findAll();
    }

    private static final String CLOUDINARY_URL = "cloudinary://441976649634836:AMuIYGRLtbXOVImWP1K0HiL4TvM@dkxnbt14i";

    @Override
    public String saveImageInCloudinary(File file) {

        try {
            Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);
            Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());

            return ((String) uploadResult.get("url"));


        } catch (IOException e) {
            System.out.println("ImageService.createImage: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Image saveImageInDB(String url) {
        Image image = new Image();
        image.setUrl(url);
        Image savedImage = imageRepository.save(image);
        image.setId(savedImage.getId());
        return image;
    }

    @Override
    public Image saveImage(File file) {
        String imageUrl = saveImageInCloudinary(file);
        return saveImageInDB(imageUrl);
    }

    @Override
    public byte[] getById(Long id) {
        Image image = imageRepository.findById(id).orElse(null);
        File file = new File(image.getUrl());
        try {
            byte[] fileContent = Files.readAllBytes(file.toPath());
            return fileContent;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
