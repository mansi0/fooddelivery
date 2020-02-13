package com.example.SelfPickup.mapping;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.example.SelfPickup.entity.SelfPickupEntity;

import org.springframework.jdbc.core.RowMapper;

/**
 * SelfPickupMapping
 */
public class SelfPickupMapping implements RowMapper<SelfPickupEntity> {

    @Override
    public SelfPickupEntity mapRow(ResultSet rs, int arg) throws SQLException {

        SelfPickupEntity selfPickupEntity = new SelfPickupEntity();
        ResultSetMetaData meta = rs.getMetaData();

        for (int i = 0; i < meta.getColumnCount(); i++) {
            // System.out.println(">>> Name :" + meta.getColumnLabel(i+1));
            String fieldName = meta.getColumnName(i + 1);
            
             /*selfPickUpId
pickUpTime
pickUpDate
orderId*/
             

            switch (fieldName) {

            case "selfpickupid":
                selfPickupEntity.setSelfPickupId(rs.getString("selfpickupid"));
                break;
            case "pickuptime":
                selfPickupEntity.setPickUpTime(rs.getString("pickuptime"));
                break;
            case "pickupdate":
                selfPickupEntity.setPickUpDate(rs.getDate("pickupdate"));
                break;
            case "orderid":
                selfPickupEntity.setOrderId(rs.getString("orderid"));
                break;
            case "status" :
                selfPickupEntity.setStatus(rs.getInt("status"));
                break;
                
            }
        }
        return selfPickupEntity;
    }


    
}