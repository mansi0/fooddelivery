package com.example.Hotel_food.entity;

/**
 * HotelFoodEntity
 */
public class HotelFoodEntity {

String hotelFoodId;
String hotelId;
String foodId;
String foodSpeciality;
String size;
float price;

    public String getHotelFoodId() {
        return hotelFoodId;
    }

    public void setHotelFoodId(String hotelFoodId) {
        this.hotelFoodId = hotelFoodId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getFoodSpeciality() {
        return foodSpeciality;
    }

    public void setFoodSpeciality(String foodSpeciality) {
        this.foodSpeciality = foodSpeciality;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    
}