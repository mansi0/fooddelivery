package com.example.HomeDelivery.service;

import java.text.ParseException;
import java.util.List;

import com.example.HomeDelivery.entity.HomeDeliveryEntity;

/**
 * HomeDeliveryService
 */
public interface HomeDeliveryService {

    public int addHomeDelivery(HomeDeliveryEntity homeDeliveryEntity)throws ParseException;

    public List<HomeDeliveryEntity> getDetailsByOrderId(String orderId) throws ParseException;

    public int updateOrderByStatus(HomeDeliveryEntity homeDeliveryEntity)throws ParseException;

}