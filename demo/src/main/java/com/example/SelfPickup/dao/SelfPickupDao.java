package com.example.SelfPickup.dao;

import java.text.ParseException;

import com.example.SelfPickup.entity.SelfPickupEntity;

/**
 * SelfPickupDao
 */
public interface SelfPickupDao {

    public int addSelfPickup(SelfPickupEntity selfPickupEntity)throws ParseException;
}