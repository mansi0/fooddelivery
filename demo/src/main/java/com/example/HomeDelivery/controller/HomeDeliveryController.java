package com.example.HomeDelivery.controller;

import java.io.IOException;

import javax.annotation.Resource;

import com.example.HomeDelivery.entity.HomeDeliveryEntity;
import com.example.HomeDelivery.service.HomeDeliveryService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeDeliveryController
 */
@RestController
@RequestMapping(path = "/homedelivery")
public class HomeDeliveryController {

    @Resource
    HomeDeliveryService homeDeliveryService;

//add homedeliveryservice
    @PostMapping(value = "/addhomedelivery")
    public ResponseEntity<?> addOrder(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException, IOException {
        // logger.debug("POST:CustomerController:addCustomer::parameters::
        // "+parameters);
        ObjectMapper mapper = new ObjectMapper();
        HomeDeliveryEntity homeDeliveryEntity = mapper.readValue(parameters, HomeDeliveryEntity.class);

        try {
            int result = homeDeliveryService.addHomeDelivery(homeDeliveryEntity);
            if (result == 1)/*200*/ {
                    System.out.println("homedelivery order success");
                    return ResponseEntity.status(HttpStatus.OK).body("homedelivery added successfully ");
            }
            else if(result == 0)//500
            {
                System.out.println("error occured");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
            }
        }catch (Exception e) {
            //TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("internal server error");
        }
        return null;
    }
}