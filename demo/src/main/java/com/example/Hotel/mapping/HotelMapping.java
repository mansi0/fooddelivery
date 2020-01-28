package com.example.Hotel.mapping;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
        ResultSetMetaData meta = rs.getMetaData();

        for (int i = 0; i < meta.getColumnCount(); i++) {
            // System.out.println(">>> Name :" + meta.getColumnLabel(i+1));
            String fieldName = meta.getColumnName(i + 1);

            switch (fieldName) {

            case "hotelid":

                hotelEntity.setHotelId(rs.getString("hotelid"));
                break;
            case "hotelpassword":
                hotelEntity.setHotelPassword(rs.getString("hotelpassword"));
                break;
            case "hotelemailid":
                hotelEntity.setHotelEmailId(rs.getString("hotelemailid"));
                break;
            case "hotelcontno":
                hotelEntity.setHotelContNo(rs.getString("hotelcontno"));
                break;
            case "hotelname":
                hotelEntity.setHotelName(rs.getString("hotelname"));
                break;
            case "hoteladdress":
                hotelEntity.setHotelAddress(rs.getString("hoteladdress"));
                break;
            case "hotellocality":
                hotelEntity.setHotelLocality(rs.getString("hotellocality"));
                break;
            case "hotellandmark":
                hotelEntity.setHotelLandmark(rs.getString("hotellandmark"));
                break;
            case "hotelcity":
                hotelEntity.setHotelCity(rs.getString("hotelcity"));
                break;
            case "hotelstate":
                hotelEntity.setHotelState(rs.getString("hotelstate"));
                break;
            case "openat":
                hotelEntity.setOpenAt(rs.getTime("openat"));
                break;
            case "closeat":
                hotelEntity.setCloseAt(rs.getTime("closeat"));
                break;
            case "approximatecost":
                hotelEntity.setApproximateCost(rs.getFloat("approximatecost"));
                break;
            case "hotelopeningdate":
                hotelEntity.setHotelOpeningDate(rs.getDate("hotelopeningdate"));
                break;
            case "expressdelivery":
                hotelEntity.setExpressDelivery(rs.getBoolean("expressdelivery"));
                break;
            case "hotelstatus":
                hotelEntity.setHotelStatus(rs.getString("hotelstatus"));
                break;
            case "hotelmenutype": {
                /*
                 * Array hotelMenuTypeArray = rs.getArray("hotelmenutype"); if
                 * (hotelMenuTypeArray != null) { String[] hotelMenuTypeStrings = (String[])
                 * hotelMenuTypeArray.getArray();
                 * hotelEntity.setHotelMenuType(hotelMenuTypeStrings); }
                 */
                hotelEntity.setHotelMenuType(rs.getString("hotelmenutype"));
            }
                break;

            case "hotelfacility": {
                Array hotelFacilityArray = rs.getArray("hotelfacility");
                if (hotelFacilityArray != null) {
                    String[] hotelFacilityStrings = (String[]) hotelFacilityArray.getArray();
                    hotelEntity.setHotelFacility(hotelFacilityStrings);
                }
                break;
            }
            case "hotelcuisine": {
                Array hotelCuisineArray = rs.getArray("hotelcuisine");
                if (hotelCuisineArray != null) {
                    String[] hotelCuisineStrings = (String[]) hotelCuisineArray.getArray();
                    hotelEntity.setHotelCuisine(hotelCuisineStrings);
                }
                break;
            }

            case "notification":
                hotelEntity.setNotification(rs.getBoolean("notification"));
                break;

            case "hotelrating": {
                Array hotelRatingArray = rs.getArray("hotelrating");
                if (hotelRatingArray != null) {
                    String[] hotelRatingStrings = (String[]) hotelRatingArray.getArray();
                    hotelEntity.setHotelRating(hotelRatingStrings);
                }
                break;
            }
            case "hotelreview": {
                Array hotelReviewArray = rs.getArray("hotelreview");
                if (hotelReviewArray != null) {
                    String[] hotelReviewStrings = (String[]) hotelReviewArray.getArray();
                    hotelEntity.setHotelReview(hotelReviewStrings);
                }
                break;
            }

            case "hotelimage":
                hotelEntity.setHotelImage(rs.getString("hotelimage"));
                break;

            }
        }

        return hotelEntity;

    }
}