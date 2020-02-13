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

    @Override
    public List<OrderEntity> getDetailsByHotelId(String hotelId) throws ParseException {
        List<OrderEntity> listOfOrderEntities = orderDao.getDetailsByHotelId(hotelId);
        return listOfOrderEntities;
     
    }

    @Override
    public int deleteOrder(String orderId) throws ParseException {
        int resultOfOrder=orderDao.deleteOrder(orderId);
        return resultOfOrder;
    }

    @Override
    public int updateOrderByTotal(OrderEntity orderEntity) throws ParseException {
        int resultOfOrder=orderDao.updateOrderByTotal(orderEntity);
        return resultOfOrder;
    }
  /*  @Override
    public int updateOrderByStatus(OrderEntity orderEntity) throws ParseException {
        int resultOfOrder=orderDao.updateOrderByStatus(orderEntity);
        return resultOfOrder;
        
    }*/

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

