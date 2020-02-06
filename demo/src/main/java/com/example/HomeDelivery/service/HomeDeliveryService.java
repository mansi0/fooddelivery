package com.example.HomeDelivery.service;

import java.text.ParseException;

import com.example.HomeDelivery.entity.HomeDeliveryEntity;

/**
 * HomeDeliveryService
 */
public interface HomeDeliveryService {

    public int addHomeDelivery(HomeDeliveryEntity homeDeliveryEntity)throws ParseException;
}