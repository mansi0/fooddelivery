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

        customerEntity.setCustomerId(rs.getString("customerid"));
        customerEntity.setName(rs.getString("name"));
        customerEntity.setAddress(rs.getString("address"));
        customerEntity.setLocality(rs.getString("locality"));
        customerEntity.setLandmark(rs.getString("landmark"));
        customerEntity.setCity(rs.getString("city"));
        customerEntity.setState(rs.getString("state"));
        customerEntity.setAccountType(rs.getString("accounttype"));
        customerEntity.setEmailId(rs.getString("emailid"));
        customerEntity.setContNo(rs.getString("contno"));
        customerEntity.setPassword(rs.getString("password"));
        customerEntity.setAccountDate(rs.getDate("accountdate"));
        customerEntity.setNotification(rs.getBoolean("notification"));


        return customerEntity;
    }

    
}