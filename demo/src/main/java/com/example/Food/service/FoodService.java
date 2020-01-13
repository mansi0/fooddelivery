package com.example.Food.service;

import java.text.ParseException;
import java.util.List;

import com.example.Food.entity.FoodEntity;

/**
 * FoodService
 */
public interface FoodService {
    
    public List<FoodEntity> getDetails(FoodEntity foodEntity);

    public int addFood(FoodEntity foodEntity) throws ParseException;
}