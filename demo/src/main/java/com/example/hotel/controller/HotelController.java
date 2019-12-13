package com.example.hotel.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import com.example.hotel.entity.HotelEntity;
import com.example.hotel.service.HotelService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HotelController
 */
@RestController
@RequestMapping(path = "hotel")
public class HotelController {
    @Resource HotelService hotelService;
    
    static final Logger logger = LoggerFactory.getLogger(HotelController.class);
    @GetMapping(value = "details")
    public List<HotelEntity> getDetails() {


        List<HotelEntity> listOfHotel=hotelService.getDetail();
        return listOfHotel;
    }

    
    @PostMapping(value = "/add")
    public ResponseEntity<?> addHotel(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException ,IOException{
       // logger.debug("POST:HotelController:addHotel::parameters:: "+parameters);
        ObjectMapper mapper=new ObjectMapper();
        HotelEntity hotelEntity=mapper.readValue(parameters, HotelEntity.class);
        System.out.println("hotel in controller ::"+hotelEntity);

        try {
          int result=hotelService.addHotel(hotelEntity);
         if(result== -1)
              return ResponseEntity.status(HttpStatus.OK).body("hotel Already Exist");
         else if(result ==0)
             return ResponseEntity.status(HttpStatus.OK).body("Exception occur");
         else if(result ==1)
            return ResponseEntity.status(HttpStatus.OK).body("hotel added successfully ");
        
        }
        catch(Exception e) {
             logger.error("POST:HotelController:addHotel::error:: "+e.getStackTrace());
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error occured");
      }
     return null;
    }
} 
