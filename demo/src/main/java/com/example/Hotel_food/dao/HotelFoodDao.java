package com.example.Hotel_food.dao;

import java.text.ParseException;
import java.util.List;

import com.example.Hotel_food.entity.HotelFoodEntity;

/**
 * HotelFoodDao
 */
public interface HotelFoodDao {

    
    public int addHotelFood(HotelFoodEntity hotelFoodEntity) throws ParseException;

    public List<HotelFoodEntity> getDetailsByHotelId(String hotelId) throws ParseException;
}