package com.example.HomeDelivery.mapping;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.example.HomeDelivery.entity.HomeDeliveryEntity;

import org.springframework.jdbc.core.RowMapper;

/**
 * HomeDeliveryMapping
 */
public class HomeDeliveryMapping implements RowMapper<HomeDeliveryEntity> {

    @Override
    public HomeDeliveryEntity mapRow(ResultSet rs, int arg) throws SQLException {

        HomeDeliveryEntity homeDeliveryEntity = new HomeDeliveryEntity();
        ResultSetMetaData meta = rs.getMetaData();

        for (int i = 0; i < meta.getColumnCount(); i++) {
            // System.out.println(">>> Name :" + meta.getColumnLabel(i+1));
            String fieldName = meta.getColumnName(i + 1);
            /*
             homeDeliveryId
homeDeliveryAddress
orderId
deliveryboyid*/

            switch (fieldName) {

            case "homedeliveryid":
                homeDeliveryEntity.setHomeDeliveryId(rs.getString("homedeliveryid"));
                break;
            case "homedeliveryaddress":
                homeDeliveryEntity.setHomeDeliveryAddress(rs.getString("homedeliveryaddress"));
                break;
            case "orderid":
                homeDeliveryEntity.setOrderId(rs.getString("orderid"));
                break;
            case "deliveryboyid":
                homeDeliveryEntity.setDeliveryboyId(rs.getString("deliveryboyid"));
                break;
            }
        }
        return homeDeliveryEntity;
    }


    
}