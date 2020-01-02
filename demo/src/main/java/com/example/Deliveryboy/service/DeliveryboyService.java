package com.example.Deliveryboy.service;

import java.util.List;

import com.example.Deliveryboy.entity.DeliveryboyEntity;

/**
 * DeliveryboyService
 */
public interface DeliveryboyService {

    public List<DeliveryboyEntity> getDetail();

    public int addDeliveryboy(DeliveryboyEntity deliveryboyEntity);

    public int loginDeliveryboy(String email,String psw);
}