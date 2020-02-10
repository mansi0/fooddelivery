package com.example.Hotel.dao;

import java.text.ParseException;
import java.util.List;

import com.example.Hotel.entity.HotelEntity;

/**
 * HotelDao
 */
public interface HotelDao {

    public List<HotelEntity> getDetailByName(String hotelName);

    public List<HotelEntity> getDetails();

    public List<HotelEntity> getDetailsByHotelId(String hotelId);

    public List<HotelEntity> getDetailsByHotelEmailId(String hotelEmailId);

    public List<HotelEntity> getDetailsByHotelFacility(int index);

    public List<HotelEntity> getDetailsByHotelCuisine(int index);

    public List<HotelEntity> getDetailsByHotelMenuType(String type);

    public List<HotelEntity> getDetailsByExpressDelivery();

    public List<HotelEntity> getDetailsByNearBy(String locality);

    public List<HotelEntity> checkDuplicationOfEmail(HotelEntity hotelEntity);

    public int addHotel(HotelEntity hotelEntity) throws ParseException;

    public void updateHotel(HotelEntity hotelEntity);

    public List<HotelEntity> fetchByEmailId(String email);
}