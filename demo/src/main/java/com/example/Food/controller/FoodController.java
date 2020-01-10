package com.example.Food.controller;

import java.io.IOException;

import com.example.Food.entity.FoodEntity;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
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

   /* @PostMapping(value = "/add")
    public ResponseEntity<?> addFood(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException, IOException {
        // logger.debug("POST:CustomerController:addCustomer::parameters::
        // "+parameters);
        ObjectMapper mapper = new ObjectMapper();
        FoodController foodController = mapper.readValue(parameters, FoodEntity.class);

        try {
            int result = customerServic.addCustomer(customerEntity);*/
}