package com.example.Hotel_Food.service;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import com.example.Hotel_Food.dao.HotelFoodDao;
import com.example.Hotel_Food.entity.HotelFoodEntity;

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

    @Override
    public List<HotelFoodEntity> getDetailsByHotelId(String hotelId) throws ParseException {
        List<HotelFoodEntity> lHotelFoodEntities = hotelFoodDao.getDetailsByHotelId(hotelId);
        return lHotelFoodEntities;
    }

    @Override
    public List<HotelFoodEntity> getDetailsByFoodId(String foodId) throws ParseException {
        List<HotelFoodEntity> lHotelFoodEntities = hotelFoodDao.getDetailsByFoodId(foodId);
        return lHotelFoodEntities;
        
    }

    @Override
    public List<HotelFoodEntity> getDetailsByHotelFoodId(String hotelFoodId) throws ParseException {
        List<HotelFoodEntity> lHotelFoodEntities = hotelFoodDao.getDetailsByHotelFoodId(hotelFoodId);
        return lHotelFoodEntities;
        
    }
}