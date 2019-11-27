package com.example.Customer.service;

import java.util.List;

import javax.annotation.Resource;

import com.example.Customer.dao.CustomerDao;
import com.example.Customer.entity.CustomerEntity;

import org.springframework.stereotype.Component;

/**
 * CustomerServiceimpl
 */
@Component
public class CustomerServiceimpl implements CustomerService{

    @Resource CustomerDao customerDao;
    
    @Override
    public List<CustomerEntity> getDetail() {


        
        List<CustomerEntity> listOfCustomer=customerDao.getDetail();
        return listOfCustomer;
    }
    
}