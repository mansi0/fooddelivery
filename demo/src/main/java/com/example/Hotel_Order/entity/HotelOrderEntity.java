package com.example.Hotel_Order.entity;

/**
 * HotelOrderEntity
 */
public class HotelOrderEntity {

   /* hotelorderid
hotelid
orderId*/

    String hotelOrderId;
    String hotelId;
    String orderId;

    public String getHotelOrderId() {
        return hotelOrderId;
    }

    public void setHotelOrderId(String hotelOrderId) {
        this.hotelOrderId = hotelOrderId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}