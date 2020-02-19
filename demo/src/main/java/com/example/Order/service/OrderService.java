package com.example.Order.service;

import java.text.ParseException;
import java.util.List;

import com.example.Order.entity.OrderEntity;

/**
 * orderService
 */
public interface OrderService {

    public List<OrderEntity> getDetailsByTime(int hrs,int min,String date) throws ParseException;

    public List<OrderEntity>getDetails()throws ParseException;

    public float getDetailsByTotalOfDay()throws ParseException;

    public List<OrderEntity> getDetailsByHotelId(String hotelId) throws ParseException;

    public int addOrder(OrderEntity orderEntity) throws ParseException;

    public int updateOrderByTotal(OrderEntity orderEntity) throws ParseException;

   // public int updateOrderByStatus(OrderEntity orderEntity) throws ParseException;

    public int deleteOrder (String orderId) throws ParseException;
}