package com.example.Imageloading.dao;

import java.text.ParseException;
import java.util.List;

import com.example.Imageloading.entity.ImageEntity;

/**
 * ImageLoadingdao
 */
public interface ImageLoadingdao {

    public List<ImageEntity> getImage();
    public int addImage(ImageEntity imageEntity) throws ParseException;
}