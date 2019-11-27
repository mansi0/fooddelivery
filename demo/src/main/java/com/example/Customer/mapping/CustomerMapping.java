package com.example.Customer.mapping;
import com.example.Customer.entity.CustomerEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * CustomerMapping
 */
public class CustomerMapping implements RowMapper<CustomerEntity> {
    @Override
    public CustomerEntity mapRow(ResultSet rs,int arg) throws SQLException {

        CustomerEntity customerEntity=new CustomerEntity();

        customerEntity.setCustomerid(rs.getInt("customerid"));
        customerEntity.setName(rs.getString("name"));
        return customerEntity;
    }

    
}