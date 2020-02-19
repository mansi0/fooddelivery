package com.example.Deliveryboy.dao;

import java.text.ParseException;
import java.util.List;

import com.example.Deliveryboy.entity.DeliveryboyEntity;

/**
 * DeliveryboyDao
 */
public interface DeliveryboyDao {

    public List<DeliveryboyEntity> getDetail();

    public List<DeliveryboyEntity> getDetailsByEmailId(String emailId);

    public List<DeliveryboyEntity> getDetailsByDeliveryboyId(String deliveryboyId);

    public List<DeliveryboyEntity> checkDuplicationOfEmail(DeliveryboyEntity deliveryboyEntity);

    public int addDeliveryboy(DeliveryboyEntity deliveryboyEntity) throws ParseException;

    public void updateDeliveryboy(DeliveryboyEntity deliveryboyEntity);

    public int updateOrderByStatus(DeliveryboyEntity deliveryboyEntity)throws ParseException;

    public int updateOrderByActivity(DeliveryboyEntity deliveryboyEntity)throws ParseException;

    public int updateOrderByPendingAmount(DeliveryboyEntity deliveryboyEntity)throws ParseException;

    public List<DeliveryboyEntity> getDetailsByActivity() throws ParseException;

    public List<DeliveryboyEntity> fetchByEmailId(String email);
}