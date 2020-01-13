package com.example.Food.service;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import com.example.Customer.dao.CustomerDao;
import com.example.Food.dao.FoodDao;
import com.example.Food.entity.FoodEntity;

import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.conditional.ElseAction;

/**
 * FoodServiceImpl
 */
@Service
public class FoodServiceImpl implements FoodService {
    @Resource
    FoodDao foodDao;

    @Override
    public List<FoodEntity> getDetails(FoodEntity foodEntity) {
            List<FoodEntity> listOfFoodEntities = foodDao.getDetails(foodEntity.getFoodName());
            return listOfFoodEntities;
    }

    public int checkDuplicationOfFood(FoodEntity foodEntity) {
        try {
            List<FoodEntity> listOfFoodEntities = foodDao.checkDuplicationOfFood(foodEntity);
            
             if (listOfFoodEntities.size() > 0)
                return 1;
            else {
                return 0;
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return 0;
        
    }

    @Override
    public int addFood(FoodEntity foodEntity) throws ParseException {

        try {

            int resultOfFood = checkDuplicationOfFood(foodEntity);

            if (resultOfFood == 0) {
                int resultOfFoodId = foodDao.addFood(foodEntity);

                if (resultOfFoodId == 1) {
                    System.out.println("food item added successfully");
                    return 1;
                    /*
                     * List<FoodEntity> listOfFoodEntities =
                     * foodDao.fetchByFoodName(foodEntity.getFoodName()); FoodEntity foodEntity2 =
                     * new FoodEntity(); foodEntity2=listOfFoodEntities.get(0); return
                     * foodEntity2.getFoodId() ;
                     */
                } else {
                    System.out.println("food item not added successfully");
                    return 0;
                }
            } else {
                return -1;
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return 0;
        }

    }

}