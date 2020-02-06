package com.example.HomeDelivery.dao;

import java.text.ParseException;

import com.example.HomeDelivery.entity.HomeDeliveryEntity;

/**
 * HomeDeliveryDao
 */
public interface HomeDeliveryDao {

    public int addHomeDelivery(HomeDeliveryEntity homeDeliveryEntity)throws ParseException;
}