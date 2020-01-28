package com.example.Imageloading.controller;

import java.io.IOException;

import java.util.List;


import javax.annotation.Resource;

import com.example.Imageloading.entity.ImageEntity;
import com.example.Imageloading.service.ImageLoadingService;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * ImageLoadingController
 */
@RestController
@RequestMapping(path = "/image")
public class ImageLoadingController {

    @Resource
    ImageLoadingService imageLoadingService;

    @GetMapping(value="/getimage")
    public List<ImageEntity> getImage() {
        
        List<ImageEntity> imageEntities = imageLoadingService.getImage();
        
        return imageEntities;
    }

    @PostMapping(value="/addimage")
    public ResponseEntity<?> addImage(@RequestBody String parameters) 
    throws JsonParseException, JsonMappingException, IOException{


        System.out.println("+++++++++++++"+parameters);
        ObjectMapper mapper = new ObjectMapper();
        com.example.Imageloading.entity.ImageEntity imageEntity = mapper.readValue(parameters, ImageEntity.class);
        

        try {
            int result = imageLoadingService.addImage(imageEntity);
            if (result == 1)/*200*/ {

               // Map<String, Object> body = new HashMap()<String, Object>();

                /*body.put("message", "Customer already exist");
                body.put("status", HttpStatus.BAD_REQUEST.value());*/
                System.out.println("image added successfully");

                return ResponseEntity.status(HttpStatus.OK).body("image added successfully");
            } 
            else if (result == 0)//500
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occur");
            return null;
        }
        catch(Exception r) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occur"); 

        }
        

        
        
        
    }
    
}