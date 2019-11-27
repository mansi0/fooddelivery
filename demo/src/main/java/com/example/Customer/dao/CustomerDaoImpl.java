package com.example.Customer.dao;

import java.util.List;

import com.example.Customer.entity.CustomerEntity;
import com.example.Customer.mapping.CustomerMapping;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * CustomerDaoImpl
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {
    NamedParameterJdbcTemplate template;

    public CustomerDaoImpl(NamedParameterJdbcTemplate template) {
        this.template=template;

    }

    @Override
    public List<CustomerEntity> getDetail() {

        String sql="select * from CustomerEntity";
        List<CustomerEntity> listOfCustomer=template.query(sql,new CustomerMapping());

        return listOfCustomer;
    } 
    
}