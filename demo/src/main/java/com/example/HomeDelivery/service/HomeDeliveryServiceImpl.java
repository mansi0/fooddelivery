package com.example.HomeDelivery.service;

import java.text.ParseException;
import java.util.List;

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

    @Override
    public List<HomeDeliveryEntity> getDetailsByOrderId(String orderId) throws ParseException {
        List<HomeDeliveryEntity> lHomeDeliveryEntities=homeDeliveryDao.getDetailsByOrderId(orderId);
        return lHomeDeliveryEntities;
    
    }

    @Override
    public int updateOrderByStatus(HomeDeliveryEntity homeDeliveryEntity) throws ParseException {
       int resultOfHomeDelivery=homeDeliveryDao.updateOrderByStatus(homeDeliveryEntity);
       return resultOfHomeDelivery; 
    }

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