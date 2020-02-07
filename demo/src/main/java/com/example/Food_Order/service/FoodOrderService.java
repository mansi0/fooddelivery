package com.example.Food_Order.service;

import java.text.ParseException;

import com.example.Food_Order.entity.FoodOrderEntity;

/**
 * FoodOrderService
 */
public interface FoodOrderService {

    public int addFoodOrder(FoodOrderEntity foodOrderEntity) throws ParseException;
}