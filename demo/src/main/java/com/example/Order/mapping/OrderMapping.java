package com.example.Order.mapping;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.example.Order.entity.OrderEntity;

import org.springframework.jdbc.core.RowMapper;

//import javax.swing.tree.RowMapper;

/**
 * OrderMapping
 */
public class OrderMapping implements RowMapper<OrderEntity> {

    @Override
    public OrderEntity mapRow(ResultSet rs, int arg) throws SQLException {

        OrderEntity orderEntity = new OrderEntity();
        ResultSetMetaData meta = rs.getMetaData();

        for (int i = 0; i < meta.getColumnCount(); i++) {
            // System.out.println(">>> Name :" + meta.getColumnLabel(i+1));
            String fieldName = meta.getColumnName(i + 1);
            /*
             * orderId varchar orderDate date orderTime time cookingInstruction varchar
             * customerId varchar
             */

            switch (fieldName) {

            case "orderid":
                orderEntity.setOrderId(rs.getString("orderid"));
                break;
            case "customerid":
                orderEntity.setCustomerId(rs.getString("customerid"));
                break;
            case "hotelid":
                orderEntity.setHotelId(rs.getString("hotelid"));
                break;
            case "orderdate":
                orderEntity.setOrderDate(rs.getDate("orderdate"));
                break;
            case "ordertime":
                orderEntity.setOrderTime(rs.getString("ordertime"));
                break;
            case "total":
                orderEntity.setTotal(rs.getFloat("total"));
                break;
            case "status":
                orderEntity.setStatus(rs.getInt("status"));
                break;
            
            }
        }
        return orderEntity;
    }

}