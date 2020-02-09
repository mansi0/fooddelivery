package com.example.Hotel_Food.dao;

import java.text.ParseException;
import java.util.List;

import com.example.Hotel_Food.entity.HotelFoodEntity;

/**
 * HotelFoodDao
 */
public interface HotelFoodDao {

    
    public int addHotelFood(HotelFoodEntity hotelFoodEntity) throws ParseException;

    public List<HotelFoodEntity> getDetailsByHotelId(String hotelId) throws ParseException;

    public List<HotelFoodEntity> getDetailsByFoodId(String foodId) throws ParseException;

    public List<HotelFoodEntity> getDetailsByHotelFoodId(String hotelFoodId) throws ParseException;
}