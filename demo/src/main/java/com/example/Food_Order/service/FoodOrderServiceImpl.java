package com.example.Food_Order.service;

import java.text.ParseException;

import javax.annotation.Resource;

import com.example.Food_Order.dao.FoodOrderDao;
import com.example.Food_Order.entity.FoodOrderEntity;

import org.springframework.stereotype.Service;

/**
 * FoodOrderServiceImpl
 */
@Service
public class FoodOrderServiceImpl implements FoodOrderService {

    @Resource
    FoodOrderDao foodOrderDao;

    @Override
    public int addFoodOrder(FoodOrderEntity foodOrderEntity) throws ParseException {

        // we call add foodService to add food items and it will return foodid
        // String foodIdByFoodService = foodService.addFood(foodEntity);
        // hotelFoodEntity.setFoodId(foodIdByFoodService);

        try {

            int addFoodOrderResponce = foodOrderDao.addFoodOrder(foodOrderEntity);
            //System.out.println(addHotelFoodResponce);

            if (addFoodOrderResponce > 0) {

                return 1;

            } else {

                return 0;
            }
        } catch (Exception e) {
            System.out.println("hotelfoodserviceimpl::addhotelfood" + e.getMessage());
            return 0;
            // TODO: handle exception
        }

    }

    
}