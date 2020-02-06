package com.example.SelfPickup.service;

import java.text.ParseException;

import com.example.SelfPickup.entity.SelfPickupEntity;

/**
 * SelfPickupService
 */
public interface SelfPickupService {

    public int addSelfPickup(SelfPickupEntity selfPickupEntity)throws ParseException;
}