package com.example.Customer.dao;

import java.text.ParseException;
import java.util.List;

import com.example.Customer.entity.CustomerEntity;

/**
 * CustomerDao
 */
public interface CustomerDao {

    public List<CustomerEntity> getDetail();
    public List<CustomerEntity> getDetailsByEmailId(String emailId);
    public List<CustomerEntity> checkDuplicationOfEmail(CustomerEntity customerEntity);
    public int addCustomer(CustomerEntity customerEntity)throws ParseException;
    public void updateCustomer(CustomerEntity customerEntity);
    public List<CustomerEntity> fetchByEmailId(String email); 
}