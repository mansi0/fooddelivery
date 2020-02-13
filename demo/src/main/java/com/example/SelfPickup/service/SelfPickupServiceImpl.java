package com.example.SelfPickup.service;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import com.example.SelfPickup.dao.SelfPickupDao;
import com.example.SelfPickup.entity.SelfPickupEntity;

import org.springframework.stereotype.Service;

/**
 * SelfPickupServiceImpl
 */
@Service
public class SelfPickupServiceImpl implements SelfPickupService {

    @Resource
    SelfPickupDao selfPickupDao;

    @Override
    public List<SelfPickupEntity> getDetailsByOrderId(String orderId) throws ParseException {
        List<SelfPickupEntity> lSelfPickupEntities=selfPickupDao.getDetailsByOrderId(orderId);
        return lSelfPickupEntities;
    
    }

    @Override
    public int updateOrderByStatus(SelfPickupEntity selfPickupEntity) throws ParseException {
        int resultOfOrder=selfPickupDao.updateOrderByStatus(selfPickupEntity);
        return resultOfOrder;
        
    }


    // add new order
    @Override
    public int addSelfPickup(SelfPickupEntity selfPickupEntity) throws ParseException {
        int resultOfSelfPickup = selfPickupDao.addSelfPickup(selfPickupEntity);
        try {

                if (resultOfSelfPickup == 1) 
                    //System.out.println("food item added successfully");
                    return 1;
                if(resultOfSelfPickup == 0)
                    return 0;
                else return 0;

        }catch (Exception e) {
            //TODO: handle exception
            System.out.println("error in SelfpickupService");
            return 0;

        }

                
    }            
    

    
}