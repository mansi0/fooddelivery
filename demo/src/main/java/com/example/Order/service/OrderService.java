package com.example.Order.service;

import java.text.ParseException;
import java.util.List;

import com.example.Order.entity.OrderEntity;

/**
 * orderService
 */
public interface OrderService {

    public List<OrderEntity> getDetailsByTime(int hrs,int min,String date) throws ParseException;

    public int addOrder(OrderEntity orderEntity) throws ParseException;
}