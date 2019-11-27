package com.example.Customer.dao;

import java.util.List;

import com.example.Customer.entity.CustomerEntity;

/**
 * CustomerDao
 */
public interface CustomerDao {

    public List<CustomerEntity> getDetail();
}