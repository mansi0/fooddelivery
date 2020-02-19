package com.example.Order.dao;

import java.text.ParseException;
import java.util.List;

import com.example.Order.entity.OrderEntity;

/**
 * orderDao
 */
public interface OrderDao {

    public List<OrderEntity> getDetails() throws ParseException;

    public List<OrderEntity> getDetailsByTime(int hrs,int min,String date) throws ParseException;

    public List<OrderEntity> getDetailsByTotalOfDay() throws ParseException;

    public List<OrderEntity> getDetailsByHotelId(String hotelId) throws ParseException;

    public int addOrder(OrderEntity orderEntity)throws ParseException;

    public int updateOrderByTotal(OrderEntity orderEntity)throws ParseException;

 //   public int updateOrderByStatus(OrderEntity orderEntity)throws ParseException;

    public int deleteOrder (String orderId) throws ParseException;
    
}