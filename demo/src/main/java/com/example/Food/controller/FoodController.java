package com.example.Food.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.example.Food.entity.FoodEntity;
import com.example.Food.service.FoodService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FoodController
 */
@RestController
@RequestMapping(path = "/food")
public class FoodController {

    @Resource
    FoodService foodService;

    //get all details of food
    @GetMapping(value = "/getfooddetail")
    public List<FoodEntity> getDetails() {

        List<FoodEntity> listOfFood = foodService.getDetails();
        return listOfFood;
    }

    //get food details by food name
    @GetMapping(value = "/getdetail/{parameters}")
    public List<FoodEntity> getdetailByName(@PathVariable String parameters)
    throws JsonParseException,JsonMappingException,IOException {
       // System.out.println("in foodgetdetailcontroller");
         List<FoodEntity> listOFoodEntities = foodService.getDetailsByName(parameters) ;
        return listOFoodEntities;
    }

    //get food details by food id
    @GetMapping(value = "/getdetailbyid/{parameters}")
    public List<FoodEntity> getdetailById(@PathVariable String parameters)
    throws JsonParseException,JsonMappingException,IOException {
       // System.out.println("in foodgetdetailcontroller");
         List<FoodEntity> listOFoodEntities = foodService.getDetailsById(parameters) ;
        return listOFoodEntities;
    }

    //addfood
    @PostMapping(value = "/addfood")
    public ResponseEntity<?> addFood(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException, IOException {
        // logger.debug("POST:CustomerController:addCustomer::parameters::
        // "+parameters);
        ObjectMapper mapper = new ObjectMapper();
        FoodEntity foodEntity = mapper.readValue(parameters, FoodEntity.class);

        try {
            int result = foodService.addFood(foodEntity);
            if (result == -1)/*400*/ {
                Map<String, Object> body = new HashMap<String, Object>();

                body.put("message", "Food already exist");
                body.put("status", HttpStatus.BAD_REQUEST.value());
                System.out.println("food already exists");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
            }
             else if (result == 0)//500
             {
                System.out.println("Exception Occur");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occur");
             }
            else if (result == 1)//200
            {
                System.out.println("add success");
                return ResponseEntity.status(HttpStatus.OK).body("Food added successfully ");
                
            }

        } catch (Exception e) {
            System.out.println("Exception Occur");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error occured");
        }
        return null;
    }
}