package com.example.Hotel_Order.service;

import java.text.ParseException;

import com.example.Hotel_Order.entity.HotelOrderEntity;

/**
 * HotelOrderService
 */
public interface HotelOrderService {

    public int addHotelOrder(HotelOrderEntity hotelOrderEntity)throws ParseException;
}