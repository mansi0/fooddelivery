package com.example.Hotel_Order.service;

import java.text.ParseException;

import javax.annotation.Resource;

import com.example.Hotel_Order.dao.HotelOrderDao;
import com.example.Hotel_Order.entity.HotelOrderEntity;

import org.springframework.stereotype.Service;

/**
 * HotelOrderServiceImpl
 */
@Service
public class HotelOrderServiceImpl implements HotelOrderService {

    @Resource
    HotelOrderDao hotelOrderdDao;

    @Override
    public int addHotelOrder(HotelOrderEntity hotelOrderEntity) throws ParseException {

        // we call add foodService to add food items and it will return foodid
        // String foodIdByFoodService = foodService.addFood(foodEntity);
        // hotelFoodEntity.setFoodId(foodIdByFoodService);

        try {

            int addHotelOrderResponce = hotelOrderdDao.addHotelOrder(hotelOrderEntity);
            //System.out.println(addHotelFoodResponce);

            if (addHotelOrderResponce > 0) {

                return 1;

            } else {

                return 0;
            }
        } catch (Exception e) {
            System.out.println("hotelorderserviceimpl::addhotelorder" + e.getMessage());
            return 0;
            // TODO: handle exception
        }

    }


    
}