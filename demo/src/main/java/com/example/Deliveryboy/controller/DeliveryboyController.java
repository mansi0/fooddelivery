package com.example.Deliveryboy.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import com.example.Deliveryboy.entity.DeliveryboyEntity;
import com.example.Deliveryboy.service.DeliveryboyService;
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
 * DeliveryboyController
 */
@RestController
@RequestMapping(path = "deliveryboy")
public class DeliveryboyController {
    @Resource DeliveryboyService deliveryboyService;
    
    static final Logger logger = LoggerFactory.getLogger(DeliveryboyController.class);
    @GetMapping(value = "details")
    public List<DeliveryboyEntity> getDetails() {


        List<DeliveryboyEntity> listOfDeliveryboy=deliveryboyService.getDetail();
        return listOfDeliveryboy;
    }

    
    @PostMapping(value = "/add")
    public ResponseEntity<?> addDeliveryboy(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException ,IOException{
       // logger.debug("POST:DeliveryboyController:addDeliveryboy::parameters:: "+parameters);
        ObjectMapper mapper=new ObjectMapper();
        DeliveryboyEntity deliveryboyEntity=mapper.readValue(parameters, DeliveryboyEntity.class);
        System.out.println("delivery boy in controller ::"+deliveryboyEntity);

        try {
          int result=deliveryboyService.addDeliveryboy(deliveryboyEntity);
         if(result== -1)
              return ResponseEntity.status(HttpStatus.OK).body("delivery boy Already Exist");
         else if(result ==0)
             return ResponseEntity.status(HttpStatus.OK).body("Exception occur");
         else if(result ==1)
            return ResponseEntity.status(HttpStatus.OK).body("Deliveryboy added successfully ");
        
        }
        catch(Exception e) {
             logger.error("POST:DeliveryboyController:addDeliveryboy::error:: "+e.getStackTrace());
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error occured");
      }
     return null;
    }
} 
