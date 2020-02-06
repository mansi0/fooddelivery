package com.example.HomeDelivery.service;

import java.text.ParseException;

import javax.annotation.Resource;

import com.example.HomeDelivery.dao.HomeDeliveryDao;
import com.example.HomeDelivery.entity.HomeDeliveryEntity;

import org.springframework.stereotype.Service;

/**
 * HomeDeliveryServiceImpl
 */
@Service
public class HomeDeliveryServiceImpl implements HomeDeliveryService {

    @Resource
    HomeDeliveryDao homeDeliveryDao ;

    // add new order
    @Override
    public int addHomeDelivery(HomeDeliveryEntity homeDeliveryEntity) throws ParseException {
        int resultOfHomeDelivery = homeDeliveryDao.addHomeDelivery(homeDeliveryEntity);
        try {

                if (resultOfHomeDelivery == 1) 
                    //System.out.println("food item added successfully");
                    return 1;
                if(resultOfHomeDelivery == 0)
                    return 0;
                else return 0;

        }catch (Exception e) {
            //TODO: handle exception
            System.out.println("error in SelfpickupService");
            return 0;

        }

                
    }            
    
    
}