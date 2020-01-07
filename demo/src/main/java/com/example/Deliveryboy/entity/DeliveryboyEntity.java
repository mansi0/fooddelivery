package com.example.Deliveryboy.entity;

import java.sql.Date;

/**
 * DeliveryboyEntity
 */
public class DeliveryboyEntity {

    String deliveryboyId;
    String deliveryboyName;
    String deliveryboyAddress;
    String deliveryboyEmailId;
    String deliveryboyContNo;
    String deliveryArea;
    String deliveryboyPassword;
    String deliveryboyStatus;
    int noOfDays;
    String deliveryboyShift;
    int noOfDelivery;
    Date accountDate;
    float deliveryboySalary;
    boolean notification=false;
    

    public String getDeliveryboyId() {
        return deliveryboyId;
    }

    public void setDeliveryboyId(String deliveryboyId) {
        this.deliveryboyId = deliveryboyId;
    }

    public String getDeliveryboyName() {
        return deliveryboyName;
    }

    public void setDeliveryboyName(String deliveryboyName) {
        this.deliveryboyName = deliveryboyName;
    }

    public String getDeliveryboyAddress() {
        return deliveryboyAddress;
    }

    public void setDeliveryboyAddress(String deliveryboyAddress) {
        this.deliveryboyAddress = deliveryboyAddress;
    }

    public String getDeliveryboyEmailId() {
        return deliveryboyEmailId;
    }

    public void setDeliveryboyEmailId(String deliveryboyEmailId) {
        this.deliveryboyEmailId = deliveryboyEmailId;
    }

    public String getDeliveryboyContNo() {
        return deliveryboyContNo;
    }

    public void setDeliveryboyContNo(String deliveryboyContNo) {
        this.deliveryboyContNo = deliveryboyContNo;
    }

    public float getDeliveryboySalary() {
        return deliveryboySalary;
    }

    public void setDeliveryboySalary(float deliveryboySalary) {
        this.deliveryboySalary = deliveryboySalary;
    }

    public String getDeliveryArea() {
        return deliveryArea;
    }

    public void setDeliveryArea(String deliveryArea) {
        this.deliveryArea = deliveryArea;
    }

    public String getDeliveryboyStatus() {
        return deliveryboyStatus;
    }

    public void setDeliveryboyStatus(String deliveryboyStatus) {
        this.deliveryboyStatus = deliveryboyStatus;
    }

    public String getDeliveryboyPassword() {
        return deliveryboyPassword;
    }

    public void setDeliveryboyPassword(String deliveryboyPassword) {
        this.deliveryboyPassword = deliveryboyPassword;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public String getDeliveryboyShift() {
        return deliveryboyShift;
    }

    public void setDeliveryboyShift(String deliveryboyShift) {
        this.deliveryboyShift = deliveryboyShift;
    }

    public int getNoOfDelivery() {
        return noOfDelivery;
    }

    public void setNoOfDelivery(int noOfDelivery) {
        this.noOfDelivery = noOfDelivery;
    }

    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

   
}
