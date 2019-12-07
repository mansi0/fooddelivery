package com.example.Customer.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import com.example.Customer.entity.CustomerEntity;
import com.example.Customer.service.CustomerService;
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
 * CustomerController
 */
@RestController
@RequestMapping(path = "customer")
public class CustomerController {
    @Resource CustomerService customerService;
    
    static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @GetMapping(value = "details")
    public List<CustomerEntity> getDetails() {


        List<CustomerEntity> listOfCustomer=customerService.getDetail();
        return listOfCustomer;
    }

    
    @PostMapping(value = "/add")
    public ResponseEntity<?> addCustomer(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException ,IOException{
       // logger.debug("POST:CustomerController:addCustomer::parameters:: "+parameters);
        ObjectMapper mapper=new ObjectMapper();
        CustomerEntity customerEntity=mapper.readValue(parameters, CustomerEntity.class);
        System.out.println("customer in controller ::"+customerEntity);

        try {
          int result=customerService.addCustomer(customerEntity);
         if(result== -1)
              return ResponseEntity.status(HttpStatus.OK).body("customer Already Exist");
         else if(result ==0)
             return ResponseEntity.status(HttpStatus.OK).body("Exception occur");
         else if(result ==1)
            return ResponseEntity.status(HttpStatus.OK).body("Customer added successfully ");
        
        }
        catch(Exception e) {
             logger.error("POST:CustomerController:addCustomer::error:: "+e.getStackTrace());
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error occured");
      }
     return null;
    }
} 
