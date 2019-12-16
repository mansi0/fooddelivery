package com.example.Hotel.mapping;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.Hotel.entity.HotelEntity;

import org.springframework.jdbc.core.RowMapper;

/**
 * HotelMapping
 */
public class HotelMapping implements RowMapper<HotelEntity> {

    @Override
    public HotelEntity mapRow(ResultSet rs, int arg) throws SQLException {

        HotelEntity hotelEntity = new HotelEntity();

        hotelEntity.setHotelId(rs.getString("hotelid"));
        hotelEntity.setHotelPassword(rs.getString("hotelpassword"));
        hotelEntity.setHotelEmailId(rs.getString("hotelemailid"));
        hotelEntity.setHotelContNo(rs.getString("hotelcontno"));
        hotelEntity.setHotelName(rs.getString("hotelname"));
        hotelEntity.setHotelAddress(rs.getString("hoteladdress"));
        hotelEntity.setHotelLocality(rs.getString("hotellocality"));
        hotelEntity.setHotelLandmark(rs.getString("hotellandmark"));
        hotelEntity.setHotelCity(rs.getString("hotelcity"));
        hotelEntity.setHotelState(rs.getString("hotelstate"));

        hotelEntity.setOpenAt(rs.getTime("openat"));
        hotelEntity.setCloseAt(rs.getTime("closeat"));
        hotelEntity.setApproximateCost(rs.getFloat("approximatecost"));
        hotelEntity.setHotelOpeningDate(rs.getDate("hotelopeningdate"));
        hotelEntity.setExpressDelivery(rs.getBoolean("expressdelivery"));
        hotelEntity.setHotelStatus(rs.getString("hotelstatus"));

        Array hotelMenuTypeArray = rs.getArray("hotelmenutype");
        String[] hotelMenuTypeStrings = (String[]) hotelMenuTypeArray.getArray();
        hotelEntity.setHotelMenuType(hotelMenuTypeStrings);

       
        Array hotelFacilityArray = rs.getArray("hotelfacility");
        String[] hotelFacilityStrings = (String[]) hotelFacilityArray.getArray();
        hotelEntity.setHotelFacility(hotelFacilityStrings);

        Array hotelCuisineArray = rs.getArray("hotelcuisine");
        String[] hotelCuisineStrings = (String[]) hotelCuisineArray.getArray();
        hotelEntity.setHotelCuisine(hotelCuisineStrings);

        hotelEntity.setNotification(rs.getBoolean("notification"));
        Array hotelRatingArray = rs.getArray("hotelrating");
        String[] hotelRatingStrings = (String[]) hotelRatingArray.getArray();
        hotelEntity.setHotelRating(hotelRatingStrings);

        Array hotelReviewArray = rs.getArray("hotelreview");
        String[] hotelReviewStrings = (String[]) hotelReviewArray.getArray();
        hotelEntity.setHotelMenuType(hotelReviewStrings);

        return hotelEntity;
    }
}