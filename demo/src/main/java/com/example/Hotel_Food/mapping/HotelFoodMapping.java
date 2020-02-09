package com.example.Hotel_Food.mapping;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.example.Hotel_Food.entity.HotelFoodEntity;

import org.springframework.jdbc.core.RowMapper;

/**
 * HotelFoodMapping
 */
public class HotelFoodMapping implements RowMapper<HotelFoodEntity> {

    @Override
    public HotelFoodEntity mapRow(ResultSet rs, int arg) throws SQLException {

        HotelFoodEntity hotelFoodEntity = new HotelFoodEntity();
        ResultSetMetaData meta = rs.getMetaData();

        for (int i = 0; i < meta.getColumnCount(); i++) {
            // System.out.println(">>> Name :" + meta.getColumnLabel(i+1));
            String fieldName = meta.getColumnName(i + 1);

            switch (fieldName) {
                
            case"hotelfoodid":
            hotelFoodEntity.setHotelFoodId(rs.getString("hotelfoodid"));
            break;

            case "hotelid" :
            hotelFoodEntity.setHotelId(rs.getString("hotelid"));
            break;

            case "foodid" :
            hotelFoodEntity.setFoodId(rs.getString("foodid"));
            break;

            case "foodspeciality" :
            hotelFoodEntity.setFoodSpeciality(rs.getString("foodspeciality"));
            break;

            case "size" :
            hotelFoodEntity.setSize(rs.getString("size"));
            break;

            case "price" :
            hotelFoodEntity.setPrice(rs.getFloat("price"));
            break;

            }
        }
        return hotelFoodEntity;
    }



    
}