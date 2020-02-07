package com.example.Order.entity;

import java.sql.Date;

import ch.qos.logback.core.util.TimeUtil;

/**
 * OrderEntity
 */
public class OrderEntity {

 
    String orderId;
    String customerId;
    String hotelId;
    Date orderDate;
    String orderTime;
    

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    

   
    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
    
    
    
}