package com.example.Food.dao;

import java.text.ParseException;
import java.util.List;

import com.example.Food.entity.FoodEntity;

/**
 * FoodDao
 */
public interface FoodDao {

    public List<FoodEntity> getDetails(String foodName);
    public List<FoodEntity> checkDuplicationOfFood(FoodEntity foodEntity);
    public int addFood(FoodEntity foodEntity)throws ParseException;
    public List<FoodEntity> fetchByFoodName(String foodName);
}