package com.example.HomeDelivery.dao;

import java.text.ParseException;
import java.util.List;

import com.example.HomeDelivery.entity.HomeDeliveryEntity;

/**
 * HomeDeliveryDao
 */
public interface HomeDeliveryDao {

    public int addHomeDelivery(HomeDeliveryEntity homeDeliveryEntity)throws ParseException;

    public List<HomeDeliveryEntity> getDetailsByOrderId(String orderId) throws ParseException;

    public int updateOrderByStatus(HomeDeliveryEntity homeDeliveryEntity)throws ParseException;

    public int updateOrderByDeliveryBoyId(HomeDeliveryEntity homeDeliveryEntity)throws ParseException;

}