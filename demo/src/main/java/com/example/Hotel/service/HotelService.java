package com.example.Hotel.service;

import java.util.List;

import com.example.Hotel.entity.HotelEntity;

/**
 * HotelService
 */
public interface HotelService {

    public List<HotelEntity> getDetailByName(String hotelName);

    public List<HotelEntity> getDetails();

    public List<HotelEntity> getDetailsByHotelFacility(int index);

    public List<HotelEntity> getDetailsByHotelMenuType(String type);

    public List<HotelEntity> getDetailsByHotelId(String hotelId);

    public List<HotelEntity> getDetailsByHotelEmailId(String hotelEmailId);

    public List<HotelEntity> getDetailsByExpressDelivery();

    public List<HotelEntity> getDetailsByNearBy(String locality);

    public List<HotelEntity> getDetailsByHotelCuisine(int index);

    public int addHotel(HotelEntity hotelEntity);

    public int loginHotel(String email,String psw);
}