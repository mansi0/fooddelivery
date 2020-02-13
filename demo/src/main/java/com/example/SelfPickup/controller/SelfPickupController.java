package com.example.SelfPickup.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import com.example.SelfPickup.entity.SelfPickupEntity;
import com.example.SelfPickup.service.SelfPickupService;
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
 * SelfPickUpController
 */

@RestController
@RequestMapping(path = "/selfpickup")
public class SelfPickupController {

    @Resource
    SelfPickupService selfPickupService;

    // add selfpickup
    @PostMapping(value = "/addselfpickup")
    public ResponseEntity<?> addOrder(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException, IOException {
        // logger.debug("POST:CustomerController:addCustomer::parameters::
        // "+parameters);
        ObjectMapper mapper = new ObjectMapper();
        SelfPickupEntity selfPickupEntity = mapper.readValue(parameters, SelfPickupEntity.class);

        try {
          //  System.out.println("in spk contro");
            int result = selfPickupService.addSelfPickup(selfPickupEntity);
            if (result == 1)/* 200 */ {
                System.out.println("selfpickup order success");
                return ResponseEntity.status(HttpStatus.OK).body("Selfpickup added successfully ");
            } else if (result == 0)// 500
            {
                System.out.println("error occured");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
            }
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("internal server error");
        }
        return null;
    }

    // get all details of selfpickup by orderid
    @GetMapping(value = "/getdetailsbyorderid/{parameters}")
    public List<SelfPickupEntity> getDetailsByOrderId(@PathVariable String parameters) throws ParseException {

        List<SelfPickupEntity> listOfSelfPickupEntities = selfPickupService.getDetailsByOrderId(parameters);
        return listOfSelfPickupEntities;
    }

    // update order by status

  @PostMapping(value = "/updateselfpickupbystatus")
    public ResponseEntity<?>updateOrderByStatus(@RequestBody String parameters) throws
    JsonParseException, JsonMappingException, IOException { 
       ObjectMapper mapper = new ObjectMapper();
        SelfPickupEntity selfPickupEntity = mapper.readValue(parameters, SelfPickupEntity.class);
  
        try {
             int result = selfPickupService.updateOrderByStatus(selfPickupEntity); 
             if (result== 1)/* 200*/{
                System.out.println("updated selfpickup for status"); return
                ResponseEntity.status(HttpStatus.OK).body("selfpickup updated successfully "); 
            }
            else if (result == 0)// 500
            {
                System.out.println("order is not updated for status"); return
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error"); 
            }
        }catch(Exception e){
             // TODO: handleexception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("internal server error"); 
        }return null;
    }
}