package com.example.Deliveryboy.entity;

import java.sql.Date;

/**
 * DeliveryboyEntity
 */
public class DeliveryboyEntity {

    String deliveryboyid;
    String deliveryboyname;
    String deliveryboyaddress;
    String deliveryboyemailid;
    String deliveryboycontno;
    float deliveryboysalary;
    String deliveryArea;
    String deliveryBoyStatus;
    String deliveryBoyPassword;
    int noofdays;
    String deliveryboyshift;
    int noofdelivery;
    boolean notification=false;

    public String getDeliveryboyid() {
        return deliveryboyid;
    }

    public void setDeliveryboyid(String deliveryboyid) {
        this.deliveryboyid = deliveryboyid;
    }

    public String getDeliveryboyname() {
        return deliveryboyname;
    }

    public void setDeliveryboyname(String deliveryboyname) {
        this.deliveryboyname = deliveryboyname;
    }

    public String getDeliveryboyaddress() {
        return deliveryboyaddress;
    }

    public void setDeliveryboyaddress(String deliveryboyaddress) {
        this.deliveryboyaddress = deliveryboyaddress;
    }

    public String getDeliveryboyemailid() {
        return deliveryboyemailid;
    }

    public void setDeliveryboyemailid(String deliveryboyemailid) {
        this.deliveryboyemailid = deliveryboyemailid;
    }

    public String getDeliveryboycontno() {
        return deliveryboycontno;
    }

    public void setDeliveryboycontno(String deliveryboycontno) {
        this.deliveryboycontno = deliveryboycontno;
    }

    public float getDeliveryboysalary() {
        return deliveryboysalary;
    }

    public void setDeliveryboysalary(float deliveryboysalary) {
        this.deliveryboysalary = deliveryboysalary;
    }

    public String getDeliveryArea() {
        return deliveryArea;
    }

    public void setDeliveryArea(String deliveryArea) {
        this.deliveryArea = deliveryArea;
    }

    public String getDeliveryBoyStatus() {
        return deliveryBoyStatus;
    }

    public void setDeliveryBoyStatus(String deliveryBoyStatus) {
        this.deliveryBoyStatus = deliveryBoyStatus;
    }

    public String getDeliveryBoyPassword() {
        return deliveryBoyPassword;
    }

    public void setDeliveryBoyPassword(String deliveryBoyPassword) {
        this.deliveryBoyPassword = deliveryBoyPassword;
    }

    public int getNoofdays() {
        return noofdays;
    }

    public void setNoofdays(int noofdays) {
        this.noofdays = noofdays;
    }

    public String getDeliveryboyshift() {
        return deliveryboyshift;
    }

    public void setDeliveryboyshift(String deliveryboyshift) {
        this.deliveryboyshift = deliveryboyshift;
    }

    public int getNoofdelivery() {
        return noofdelivery;
    }

    public void setNoofdelivery(int noofdelivery) {
        this.noofdelivery = noofdelivery;
    }

    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
		this.notification = notification;
    }
}
