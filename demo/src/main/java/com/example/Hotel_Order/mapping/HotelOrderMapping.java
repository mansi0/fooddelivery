package com.example.Hotel_Order.mapping;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.example.Hotel_Order.entity.HotelOrderEntity;

import org.springframework.jdbc.core.RowMapper;

/**
 * HotelOrderMapping
 */

 /* hotelorderid
hotelid
orderId*/

public class HotelOrderMapping implements RowMapper<HotelOrderEntity> {


    @Override
    public HotelOrderEntity mapRow(ResultSet rs, int arg) throws SQLException {

        HotelOrderEntity hotelOrderEntity = new HotelOrderEntity();
        ResultSetMetaData meta = rs.getMetaData();

        for (int i = 0; i < meta.getColumnCount(); i++) {
            // System.out.println(">>> Name :" + meta.getColumnLabel(i+1));
            String fieldName = meta.getColumnName(i + 1);

            switch (fieldName) {
                
            case"hotelorderid":
            hotelOrderEntity.setHotelOrderId(rs.getString("hotelorderid"));
            break;

            case"hotelid":
            hotelOrderEntity.setHotelId(rs.getString("hotelid"));
            break;

            case"orderid":
            hotelOrderEntity.setOrderId(rs.getString("orderid"));
            break;
            }
        }

        return hotelOrderEntity;
    }

    

    
}