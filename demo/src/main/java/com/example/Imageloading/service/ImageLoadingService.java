package com.example.Imageloading.service;

import java.util.List;

import com.example.Imageloading.entity.ImageEntity;

/**
 * ImageLoadingService
 */
public interface ImageLoadingService {

    public List<ImageEntity> getImage();
    public int addImage(ImageEntity imageEntity);
    
}