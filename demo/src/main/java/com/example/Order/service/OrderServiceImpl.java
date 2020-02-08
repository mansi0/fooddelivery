package com.example.Order.service;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import com.example.Order.dao.OrderDao;
import com.example.Order.entity.OrderEntity;

import org.springframework.stereotype.Service;

/**
 * orderServiceImpl
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderDao orderDao;


    @Override
    public List<OrderEntity> getDetailsByTime(int hrs,int min,String date) throws ParseException {
        List<OrderEntity> listOfOrderEntities = orderDao.getDetailsByTime(hrs,min,date);
        return listOfOrderEntities;
    }

    // add new order
    @Override
    public int addOrder(OrderEntity orderEntity) throws ParseException {
        int resultOfOrder = orderDao.addOrder(orderEntity);
        try {

                if (resultOfOrder == 1) 
                    //System.out.println("food item added successfully");
                    return 1;
                if(resultOfOrder == 0)
                    return 0;
                else return 0;

        }catch (Exception e) {
            //TODO: handle exception
            System.out.println("error in orderService");
            return 0;

        }

                
    }            
                
}

