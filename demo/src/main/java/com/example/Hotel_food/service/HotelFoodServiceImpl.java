package com.example.Hotel_food.service;

import java.text.ParseException;

import javax.annotation.Resource;

import com.example.Food.entity.FoodEntity;
import com.example.Food.service.FoodService;
import com.example.Hotel_food.dao.HotelFoodDao;
import com.example.Hotel_food.entity.HotelFoodEntity;

import org.springframework.stereotype.Service;

/**
 * HotelFoodServiceImpl
 */
@Service
public class HotelFoodServiceImpl implements HotelFoodService {

    @Resource
    HotelFoodDao hotelFoodDao;

    @Override
    public int addHotelFood(HotelFoodEntity hotelFoodEntity) throws ParseException {

        // we call add foodService to add food items and it will return foodid
        // String foodIdByFoodService = foodService.addFood(foodEntity);
        // hotelFoodEntity.setFoodId(foodIdByFoodService);

        try {

            int addHotelFoodResponce = hotelFoodDao.addHotelFood(hotelFoodEntity);
            System.out.println(addHotelFoodResponce);

            if (addHotelFoodResponce > 0) {

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