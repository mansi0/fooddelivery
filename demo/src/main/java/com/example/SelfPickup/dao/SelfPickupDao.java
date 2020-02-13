package com.example.SelfPickup.dao;

import java.text.ParseException;
import java.util.List;

import com.example.SelfPickup.entity.SelfPickupEntity;

/**
 * SelfPickupDao
 */
public interface SelfPickupDao {

    public int addSelfPickup(SelfPickupEntity selfPickupEntity)throws ParseException;

    public List<SelfPickupEntity> getDetailsByOrderId(String orderId) throws ParseException;

    public int updateOrderByStatus(SelfPickupEntity selfPickupEntity)throws ParseException;
}