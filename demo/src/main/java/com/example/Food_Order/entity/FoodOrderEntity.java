package com.example.Food_Order.entity;

/**
 * FoodOrderEntity
 */
public class FoodOrderEntity {

  /*  foodorderid
foodid
orderId
quantity*/

    String foodOrderId;
    String hotelFoodId;
    String orderId;
    int quantity;

    public String getFoodOrderId() {
        return foodOrderId;
    }

    public void setFoodOrderId(String foodOrderId) {
        this.foodOrderId = foodOrderId;
    }

    public String getHotelFoodId() {
        return hotelFoodId;
    }

    public void setHotelFoodId(String hotelFoodId) {
        this.hotelFoodId = hotelFoodId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}