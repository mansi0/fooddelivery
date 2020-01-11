package com.example.Hotel.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.example.Hotel.entity.HotelEntity;
import com.example.Hotel.service.HotelService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.tomcat.util.http.parser.MediaType;
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

    @Resource
    HotelService hotelService;

    static final Logger logger = LoggerFactory.getLogger(HotelController.class);

    @GetMapping(value = "details")
    public List<HotelEntity> getDetails() {

        List<HotelEntity> listOfHotel = hotelService.getDetail();
        return listOfHotel;
    }

    @PostMapping(value = "/addhotel")
    public ResponseEntity<?> addHotel(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException, IOException {
        // logger.debug("POST:HotelController:addHotel::parameters:: "+parameters);
        ObjectMapper mapper = new ObjectMapper();
        HotelEntity hotelEntity = mapper.readValue(parameters, HotelEntity.class);
    
        System.out.println("hotel in controller ::" + hotelEntity);

        try {
            int result = hotelService.addHotel(hotelEntity);
            if (result == -1) //400
            {
                Map<String, Object> body = new HashMap<String, Object>();

                body.put("message", "Restaurent already exist already exist");
                body.put("status", HttpStatus.BAD_REQUEST.value());

                System.out.println("this emailid already exist for another hotel");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
            }
                
            
            else if (result == 0)//500
             {
                System.out.println("error occured");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occur");
            }
            else if (result == 1)//200
             {
                System.out.println("hotel added successfully");
                return ResponseEntity.status(HttpStatus.OK).body("hotel added successfully ");
            }

        }

        catch (Exception e) {
            logger.error("POST:HotelController:addHotel::error:: " + e.getStackTrace());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error occured");
        }
        return null;
    }

    /*

        function for images
    */
    /*@RequestMapping(value = "/image")
    public ResponseEntity<?> setImage(@RequestBody String parameters) throws JsonParseException,JsonMappingException,IOException {

        ObjectMapper mapper= new ObjectMapper();
        HotelEntity hotelEntity = mapper.readValue(parameters, HotelEntity.class);
        hotelEntity.setImage();


    }*/

    @PostMapping(value = "/loginhotel")
    public ResponseEntity<?> loginHotel(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException, IOException {
        
        ObjectMapper mapper = new ObjectMapper();
        HotelEntity hotelEntity = mapper.readValue(parameters, HotelEntity.class);
        String email=hotelEntity.getHotelEmailId();
        String psw=hotelEntity.getHotelPassword();       
        // "+parameters);
        try {
    
            int result= hotelService.loginHotel(email, psw);
            if(result==-1)//404
            {
                System.out.println("restaurent not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel Not Found");
            }
            if(result==0)//400
            {
                Map<String, Object> body = new HashMap<String, Object>();

                body.put("message", "Invalid password");
                body.put("status", HttpStatus.BAD_REQUEST.value());

                System.out.println("Invalid Password");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
            }
             
            if(result==1)//200
            {
                System.out.println("valid user");
                return ResponseEntity.status(HttpStatus.OK).body("Valid User");
            }
            if(result==-2)//500
            {
                System.out.println("Exception Occure");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occur");
            }
                
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occur");
        }
        return null;

    }
}