package com.example.HomeDelivery.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import com.example.HomeDelivery.entity.HomeDeliveryEntity;
import com.example.HomeDelivery.service.HomeDeliveryService;
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



     // get all details of homedelivery by orderid
     @GetMapping(value = "/getdetailsbyorderid/{parameters}")
     public List<HomeDeliveryEntity> getDetailsByOrderId(@PathVariable String parameters) 
     throws ParseException {
 
         List<HomeDeliveryEntity> homeDeliveryEntities = homeDeliveryService.getDetailsByOrderId(parameters);
         return homeDeliveryEntities;
     }
 
     // update order by status
 
   @PostMapping(value = "/updatehomedeliverybystatus")
     public ResponseEntity<?>updateOrderByStatus(@RequestBody String parameters) throws
     JsonParseException, JsonMappingException, IOException { 
        ObjectMapper mapper = new ObjectMapper();
         HomeDeliveryEntity homeDeliveryEntity = mapper.readValue(parameters, HomeDeliveryEntity.class);
   
         try {
              int result = homeDeliveryService.updateOrderByStatus(homeDeliveryEntity); 
              if (result== 1)/* 200*/{
                 System.out.println("updated homedelivery for status"); return
                 ResponseEntity.status(HttpStatus.OK).body("homedelivery updated successfully "); 
             }
             else if (result == 0)// 500
             {
                 System.out.println("homedelivery is not updated for status"); return
                 ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error"); 
             }
         }catch(Exception e){
              // TODO: handleexception
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("internal server error"); 
         }return null;
     }

     //update homedelivery by delivery boy id by orderid
     @PostMapping(value = "/updatehomedeliverybydeliveryboyid")
     public ResponseEntity<?>updateOrderByDeliveryboyId(@RequestBody String parameters) throws
     JsonParseException, JsonMappingException, IOException { 
        ObjectMapper mapper = new ObjectMapper();
         HomeDeliveryEntity homeDeliveryEntity = mapper.readValue(parameters, HomeDeliveryEntity.class);
   
         try {
              int result = homeDeliveryService.updateOrderByDeliveryboyId(homeDeliveryEntity); 
              if (result== 1)/* 200*/{
                 System.out.println("updated homedelivery for deliveryboyid"); return
                 ResponseEntity.status(HttpStatus.OK).body("homedelivery updated successfully "); 
             }
             else if (result == 0)// 500
             {
                 System.out.println("homedelivery is not updated for deliveryboyid"); return
                 ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error"); 
             }
         }catch(Exception e){
              // TODO: handleexception
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("internal server error"); 
         }return null;
     }
}