package com.example.Hotel_food.service;

import java.text.ParseException;

import com.example.Food.entity.FoodEntity;
import com.example.Hotel_food.entity.HotelFoodEntity;

/**
 * HotelFoodService
 */
public interface HotelFoodService {

    public int addHotelFood(HotelFoodEntity hotelFoodEntity) throws ParseException;

}