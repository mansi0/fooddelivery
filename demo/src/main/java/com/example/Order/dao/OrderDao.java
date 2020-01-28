package com.example.Order.dao;

import java.text.ParseException;

import com.example.Order.entity.OrderEntity;

/**
 * orderDao
 */
public interface OrderDao {

    public int addOrder(OrderEntity orderEntity)throws ParseException;
    
}