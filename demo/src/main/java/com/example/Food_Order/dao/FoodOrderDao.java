package com.example.Food_Order.dao;

import java.text.ParseException;

import com.example.Food_Order.entity.FoodOrderEntity;

/**
 * FoodOrderDao
 */
public interface FoodOrderDao {

    public int addFoodOrder(FoodOrderEntity foodOrderEntity) throws ParseException;
}