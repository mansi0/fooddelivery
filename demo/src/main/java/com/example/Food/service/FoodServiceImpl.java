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

    public String checkDuplicationOfFood(FoodEntity foodEntity) {
        try {
            List<FoodEntity> listOfFoodEntities = foodDao.checkDuplicationOfFood(foodEntity);
            FoodEntity foodEntity2 = new FoodEntity();
            foodEntity2 = listOfFoodEntities.get(0);
            if (listOfFoodEntities.size() > 0)
                return foodEntity2.getFoodid();
            else {
                return "0";
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String addFood(FoodEntity foodEntity) throws ParseException {
    
        try {
            
        
        String resultOfFood = checkDuplicationOfFood(foodEntity);
    
        
        if(resultOfFood == "0") {
            int resultOfFoodId = foodDao.addFood(foodEntity);
            if(resultOfFoodId == 1) {
                System.out.println("food item added successfully");
                List<FoodEntity> listOfFoodEntities = foodDao.fetchByFoodName(foodEntity.getFoodname());               
                FoodEntity foodEntity2 = new FoodEntity();
                foodEntity2=listOfFoodEntities.get(0);
                return foodEntity2.getFoodid() ;
            }
            else
                System.out.println("food item not added successfully");
        }
    } catch (Exception e) {
        //TODO: handle exception
        System.out.println(e.getMessage());
        throw e;
    }
        return null;
    }

}