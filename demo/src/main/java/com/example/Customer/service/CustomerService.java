package com.example.Customer.service;

import java.util.List;

import com.example.Customer.entity.CustomerEntity;

/**
 * CustomerService
 */
public interface CustomerService {

    public List<CustomerEntity> getDetail();
    public List<CustomerEntity> getDetailsByEmailId(CustomerEntity customerEntity);
    public List<CustomerEntity> getDetailsByCustomerId(String customerId);
    public int addCustomer(CustomerEntity customerEntity);
    public int loginCustomer(String email,String psw);
}