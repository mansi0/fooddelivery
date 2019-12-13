package com.example.hotel.dao;

import java.text.ParseException;
import java.util.List;

import com.example.hotel.entity.HotelEntity;

/**
 * HotelDao
 */
public interface HotelDao {

    public List<HotelEntity> getDetail();
    public List<HotelEntity> checkDuplicationOfEmail(HotelEntity hotelEntity);
    public int addHotel(HotelEntity hotelEntity)throws ParseException;
    public void updateHotel(HotelEntity hotelEntity);
    public List<HotelEntity> fetchByEmailId(String email);
}