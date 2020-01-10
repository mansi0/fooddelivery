package com.example.Food.entity;

/**
 * FoodEntity
 */
public class FoodEntity {

    String foodid;
    String foodname;
    int foodtype;
    String category;

    public String getFoodid() {
        return foodid;
    }

    public void setFoodid(String foodid) {
        this.foodid = foodid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(int foodtype) {
        this.foodtype = foodtype;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}