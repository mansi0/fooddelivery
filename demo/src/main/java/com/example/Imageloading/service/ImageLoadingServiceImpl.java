package com.example.Imageloading.service;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import com.example.Imageloading.dao.ImageLoadingdao;
import com.example.Imageloading.entity.ImageEntity;

import org.springframework.stereotype.Service;

/**
 * ImageLoadingServiceImpl
 */
@Service
public class ImageLoadingServiceImpl implements ImageLoadingService {

    @Resource
    ImageLoadingdao imageLoadingdao;

    @Override
    public List<ImageEntity> getImage() {

        List<ImageEntity> listOfImageEntities = imageLoadingdao.getImage();
        return listOfImageEntities;
    }

    @Override
    public int addImage(ImageEntity imageEntity) {

        try {
            int addImageResponce = imageLoadingdao.addImage(imageEntity);
            return addImageResponce;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
        

     }
}