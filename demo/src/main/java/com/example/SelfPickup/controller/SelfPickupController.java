package com.example.SelfPickup.controller;

import java.io.IOException;

import javax.annotation.Resource;

import com.example.SelfPickup.entity.SelfPickupEntity;
import com.example.SelfPickup.service.SelfPickupService;
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
 * SelfPickUpController
 */

@RestController
@RequestMapping(path = "/selfpickup")
public class SelfPickupController {


    @Resource
    SelfPickupService selfPickupService;
//add selfpickup
    @PostMapping(value = "/addselfpickup")
    public ResponseEntity<?> addOrder(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException, IOException {
        // logger.debug("POST:CustomerController:addCustomer::parameters::
        // "+parameters);
        ObjectMapper mapper = new ObjectMapper();
        SelfPickupEntity selfPickupEntity = mapper.readValue(parameters, SelfPickupEntity.class);

        try {
            int result = selfPickupService.addSelfPickup(selfPickupEntity);
            if (result == 1)/*200*/ {
                    System.out.println("selfpickup order success");
                    return ResponseEntity.status(HttpStatus.OK).body("Selfpickup added successfully ");
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