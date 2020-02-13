package com.example.SelfPickup.service;

import java.text.ParseException;
import java.util.List;

import com.example.SelfPickup.entity.SelfPickupEntity;

/**
 * SelfPickupService
 */
public interface SelfPickupService {

    public int addSelfPickup(SelfPickupEntity selfPickupEntity)throws ParseException;

    public List<SelfPickupEntity> getDetailsByOrderId(String orderId) throws ParseException;

    public int updateOrderByStatus(SelfPickupEntity selfPickupEntity) throws ParseException;
}