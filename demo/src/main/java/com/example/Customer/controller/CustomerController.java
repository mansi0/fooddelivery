package com.example.Customer.controller;

import java.util.List;

import javax.annotation.Resource;

import com.example.Customer.entity.CustomerEntity;
import com.example.Customer.service.CustomerService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CustomerController
 */
@RestController
@RequestMapping(path = "customer")
public class CustomerController {
    @Resource CustomerService customerService;
    @GetMapping(value = "details")
    public List<CustomerEntity> getDetails() {


        List<CustomerEntity> listOfCustomer=customerService.getDetail();
        return listOfCustomer;
    }
    
}