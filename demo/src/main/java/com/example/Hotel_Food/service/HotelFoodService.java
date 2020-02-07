package com.example.Hotel_Food.service;

import java.text.ParseException;
import java.util.List;

import com.example.Food.entity.FoodEntity;
import com.example.Hotel_Food.entity.HotelFoodEntity;

/**
 * HotelFoodService
 */
public interface HotelFoodService {

    public int addHotelFood(HotelFoodEntity hotelFoodEntity) throws ParseException;

    public List<HotelFoodEntity> getDetailsByHotelId(String hotelId) throws ParseException;
}