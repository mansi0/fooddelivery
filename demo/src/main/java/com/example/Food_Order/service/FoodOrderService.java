package com.example.Food_Order.service;

import java.text.ParseException;
import java.util.List;

import com.example.Food_Order.entity.FoodOrderEntity;

/**
 * FoodOrderService
 */
public interface FoodOrderService {

    public int addFoodOrder(FoodOrderEntity foodOrderEntity) throws ParseException;

    public List<FoodOrderEntity> getDetailsByOrderId(String orderId) throws ParseException;

    public int deleteFoodOrder (String orderId) throws ParseException;

    public int deleteFoodOrderByHFId (String hotelFoodId) throws ParseException;
}