package com.example.SelfPickup.entity;

import java.sql.Date;

/**
 * SelfPickUpEntity
 */
public class SelfPickupEntity {

    /*selfPickUpId
pickUpTime
pickUpDate
orderId

selfPickUpId
orderId
status
pickUpTime
pickUpDate
*/

    String selfPickupId;
    Date pickUpDate;
    String pickUpTime;
    String orderId;
    int status;

    public String getSelfPickupId() {
        return selfPickupId;
    }

    public void setSelfPickupId(String selfPickupId) {
        this.selfPickupId = selfPickupId;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    

    
}