package com.example.Hotel.entity;

import java.sql.Date;
import java.sql.Time;

/**
 * HotelEntity
 */
public class HotelEntity {

    String hotelId;
    String hotelPassword;
    String hotelEmailId;
    String hotelContNo;
    String hotelName;
    String hotelAddress;
    String hotelLocality;
    String hotelLandmark;
    String hotelCity;
    String hotelState;
    Time openAt;
    Time closeAt;
    float approximateCost;
    Date hotelOpeningDate;
    boolean expressDelivery;
    String hotelStatus;
    String[] hotelMenuType;
    Integer[] hotelFacility;
    String[] hotelCuisine;
    boolean notification=false;
    Integer[] hotelRating;
    String[] hotelReview;
    

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelPassword() {
        return hotelPassword;
    }

    public void setHotelPassword(String hotelPassword) {
        this.hotelPassword = hotelPassword;
    }

    public String getHotelEmailId() {
        return hotelEmailId;
    }

    public void setHotelEmailId(String hotelEmailId) {
        this.hotelEmailId = hotelEmailId;
    }

    public String getHotelContNo() {
        return hotelContNo;
    }

    public void setHotelContNo(String hotelContNo) {
        this.hotelContNo = hotelContNo;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelLocality() {
        return hotelLocality;
    }

    public void setHotelLocality(String hotelLocality) {
        this.hotelLocality = hotelLocality;
    }

    public String getHotelLandmark() {
        return hotelLandmark;
    }

    public void setHotelLandmark(String hotelLandmark) {
        this.hotelLandmark = hotelLandmark;
    }

    public String getHotelCity() {
        return hotelCity;
    }

    public void setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity;
    }

    public String getHotelState() {
        return hotelState;
    }

    public void setHotelState(String hotelState) {
        this.hotelState = hotelState;
    }

    public Time getOpenAt() {
        return openAt;
    }

    public void setOpenAt(Time openAt) {
        this.openAt = openAt;
    }

    public Time getCloseAt() {
        return closeAt;
    }

    public void setCloseAt(Time closeAt) {
        this.closeAt = closeAt;
    }

    public float getApproximateCost() {
        return approximateCost;
    }

    public void setApproximateCost(float approximateCost) {
        this.approximateCost = approximateCost;
    }

    public Date getHotelOpeningDate() {
        return hotelOpeningDate;
    }

    public void setHotelOpeningDate(Date hotelOpeningDate) {
        this.hotelOpeningDate = hotelOpeningDate;
    }

    public boolean isExpressDelivery() {
        return expressDelivery;
    }

    public void setExpressDelivery(boolean expressDelivery) {
        this.expressDelivery = expressDelivery;
    }

    public String getHotelStatus() {
        return hotelStatus;
    }

    public void setHotelStatus(String hotelStatus) {
        this.hotelStatus = hotelStatus;
    }

    public String[] getHotelMenuType() {
        return hotelMenuType;
    }

    public void setHotelMenuType(String[] hotelMenuType) {
        this.hotelMenuType = hotelMenuType;
    }

    public Integer[] getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(Integer[] hotelRating) {
        this.hotelRating = hotelRating;
    }

    public String[] getHotelReview() {
        return hotelReview;
    }

    public void setHotelReview(String[] hotelReview) {
        this.hotelReview = hotelReview;
    }

    public Integer[] getHotelFacility() {
        return hotelFacility;
    }

    public void setHotelFacility(Integer[] hotelFacility) {
        this.hotelFacility = hotelFacility;
    }

    public String[] getHotelCuisine() {
        return hotelCuisine;
    }

    public void setHotelCuisine(String[] hotelCuisine) {
        this.hotelCuisine = hotelCuisine;
    }

    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }
}