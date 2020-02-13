package com.example.HomeDelivery.entity;

/**
 * HomeDeliveryEntity
 */
public class HomeDeliveryEntity {

    /*homeDeliveryId
address
locality
landmark
city
state
status
orderId
deliveryboyid*/

    String homeDeliveryId;
    String address;
    String locality;
    String landmark;
    String city;
    String state;
    int status;
    String orderId;
    String deliveryboyId;

    public String getHomeDeliveryId() {
        return homeDeliveryId;
    }

    public void setHomeDeliveryId(String homeDeliveryId) {
        this.homeDeliveryId = homeDeliveryId;
    }

   
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDeliveryboyId() {
        return deliveryboyId;
    }

    public void setDeliveryboyId(String deliveryboyId) {
        this.deliveryboyId = deliveryboyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}