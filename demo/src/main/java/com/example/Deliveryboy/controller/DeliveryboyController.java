package com.example.Deliveryboy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.example.Deliveryboy.entity.DeliveryboyEntity;
import com.example.Deliveryboy.service.DeliveryboyService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    @Resource
    DeliveryboyService deliveryboyService;

    static final Logger logger = LoggerFactory.getLogger(DeliveryboyController.class);

    @GetMapping(value = "details")
    public List<DeliveryboyEntity> getDetails() {

        List<DeliveryboyEntity> listOfDeliveryboy = deliveryboyService.getDetail();
        return listOfDeliveryboy;
    }

    @PostMapping(value = "/adddeliveryboy")
    public ResponseEntity<?> addDeliveryboy(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException, IOException {
        // logger.debug("POST:DeliveryboyController:addDeliveryboy::parameters::
        // "+parameters);
        ObjectMapper mapper = new ObjectMapper();
        DeliveryboyEntity deliveryboyEntity = mapper.readValue(parameters, DeliveryboyEntity.class);
        //System.out.println("delivery boy in controller ::" + deliveryboyEntity);

        try {
            int result = deliveryboyService.addDeliveryboy(deliveryboyEntity);
            if (result == -1)//400
            {
                Map<String, Object> body = new HashMap<String, Object>();

                body.put("message", "DeliveryBoy already exist already exist");
                body.put("status", HttpStatus.BAD_REQUEST.value());

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
            }
            else if (result == 0)//500
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occur");
            else if (result == 1)//200
                return ResponseEntity.status(HttpStatus.OK).body("Deliveryboy added successfully ");

        } catch (Exception e) {
            logger.error("POST:DeliveryboyController:addDeliveryboy::error:: " + e.getStackTrace());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error occured");
        }
        return null;
    }

    @PostMapping(value = "/logindeliveryboy", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> loginCustomer(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException, IOException {
        // logger.debug("POST:CustomerController:addCustomer::parameters::
        // "+parameters);
        ObjectMapper mapper = new ObjectMapper();
        DeliveryboyEntity customerEntity = mapper.readValue(parameters, DeliveryboyEntity.class);
        String email=customerEntity.getDeliveryboyEmailId();
        String psw=customerEntity.getDeliveryboyPassword();       
        // "+parameters);
        try {
            System.out.println(email  +","+  psw+"cccccccc");
            int result= deliveryboyService.loginDeliveryboy(email, psw);
            if(result==-1)//404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deliveryboy Not Found");
            if(result==0)//400
            {
                Map<String, Object> body = new HashMap<String, Object>();

                body.put("message", "Invalid Password");
                body.put("status", HttpStatus.BAD_REQUEST.value());

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
            }
             
            if(result==1)//200
                return ResponseEntity.status(HttpStatus.OK).body("Valid Entry");
            if(result==-2)//500
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occur");
                
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occur");
        }
        return null;

    }
}
