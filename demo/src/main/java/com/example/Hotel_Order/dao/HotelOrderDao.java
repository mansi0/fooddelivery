package com.example.Hotel_Order.dao;

import java.text.ParseException;

import com.example.Hotel_Order.entity.HotelOrderEntity;

/**
 * HotelOrderDao
 */
public interface HotelOrderDao {

    public int addHotelOrder(HotelOrderEntity hotelOrderEntity) throws ParseException;
}