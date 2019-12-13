package com.example.Hotel.service;

import java.util.List;

import com.example.Hotel.entity.HotelEntity;

/**
 *HotelService
 */
public interface HotelService {

    public List<HotelEntity> getDetail();
    public int addHotel(HotelEntity hotelEntity);
}