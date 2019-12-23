package com.example.Customer.service;

import java.util.List;

import com.example.Customer.entity.CustomerEntity;

/**
 * CustomerService
 */
public interface CustomerService {

    public List<CustomerEntity> getDetail();
    public int addCustomer(CustomerEntity customerEntity);
    public int loginCustomer(String email,String psw);
}