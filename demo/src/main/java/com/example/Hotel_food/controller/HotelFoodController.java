package com.example.Hotel_food.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import com.example.Food.entity.FoodEntity;
import com.example.Hotel_food.entity.HotelFoodEntity;
import com.example.Hotel_food.service.HotelFoodService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HotelFoodController
 */
@RestController
@RequestMapping(path = "/hotelfood")
public class HotelFoodController {

    @Resource
    HotelFoodService hotelFoodService;

    /*
     * @PostMapping(value = "/addhotelfood")
     * 
     * public FoodEntity addFood(@RequestBody String parameters) throws
     * JsonParseException, JsonMappingException, IOException { //
     * logger.debug("POST:CustomerController:addCustomer::parameters:: //
     * "+parameters); ObjectMapper mapper = new ObjectMapper(); FoodEntity
     * foodEntity = mapper.readValue(parameters, FoodEntity.class); return
     * foodEntity; } // HotelFoodEntity hotelFoodEntity =
     * mapper.readValue(parameters, HotelFoodEntity.class);
     * 
     * 
     * 
     * try { int result = hotelFoodService.addHotelFood(hotelFoodEntity,foodEntity);
     * if (result == 0)//500 { System.out.println("Exception Occur"); return
     * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
     * body("Exception occur"); } else if (result == 1)//200 {
     * System.out.println("add success"); return
     * ResponseEntity.status(HttpStatus.OK).body("FoodItem added successfully ");
     * 
     * }
     * 
     * } catch (Exception e) {
     * 
     * return
     * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error occured"
     * ); } return null; }
     */

// add new hotel food
    @PostMapping(value = "/addhotelfood")
    public ResponseEntity<?> addHotelFood(@RequestBody String parameter)
            throws JsonParseException, JsonMappingException, IOException {
        // logger.debug("POST:CustomerController:addCustomer::parameters::
        // "+parameters);
        /*
         * String str1=objectNode.get("str1").asText(); String
         * str2=objectNode.get("str2").asText();
         */

        ObjectMapper mapper = new ObjectMapper();
        HotelFoodEntity hotelFoodEntity = mapper.readValue(parameter, HotelFoodEntity.class);

        try {
            int result = hotelFoodService.addHotelFood(hotelFoodEntity);
            if (result == 0)// 500
            {
                System.out.println("Exception Occur");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occur");
            } else if (result == 1)// 200
            {
                System.out.println("add success");
                return ResponseEntity.status(HttpStatus.OK).body("FoodItem added successfully ");

            }

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error occured");
        }
        return null;
    }

// get all details of hotel_food by hotelid
    @GetMapping(value = "/getdetailsbyhotelid/{parameters}")
    public List<HotelFoodEntity> getdetailByName(@PathVariable String parameters)
            throws JsonParseException, JsonMappingException, IOException, ParseException {
       // System.out.println("in foodgetdetailcontroller");
         List<HotelFoodEntity> listOfHotelFoodEntities = hotelFoodService.getDetailsByHotelId(parameters) ;
        return listOfHotelFoodEntities;
    }
    

    
}