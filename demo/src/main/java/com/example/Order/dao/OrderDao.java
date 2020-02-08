package com.example.Order.dao;

import java.text.ParseException;
import java.util.List;

import com.example.Order.entity.OrderEntity;

/**
 * orderDao
 */
public interface OrderDao {

    public List<OrderEntity> getDetailsByTime(int hrs,int min,String date) throws ParseException;

    public int addOrder(OrderEntity orderEntity)throws ParseException;
    
}