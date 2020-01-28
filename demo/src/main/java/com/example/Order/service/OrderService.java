package com.example.Order.service;

import java.text.ParseException;

import com.example.Order.entity.OrderEntity;

/**
 * orderService
 */
public interface OrderService {

    public int addOrder(OrderEntity orderEntity) throws ParseException;
}