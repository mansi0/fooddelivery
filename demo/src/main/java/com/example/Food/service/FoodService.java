package com.example.Food.service;

import java.text.ParseException;

import com.example.Food.entity.FoodEntity;

/**
 * FoodService
 */
public interface FoodService {

    public String addFood(FoodEntity foodEntity) throws ParseException;
}