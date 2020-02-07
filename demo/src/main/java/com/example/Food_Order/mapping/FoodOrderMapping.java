package com.example.Food_Order.mapping;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.example.Food_Order.entity.FoodOrderEntity;

/**
 * FoodOrderMapping
 */
public class FoodOrderMapping implements RowMapper<FoodOrderEntity> {

    @Override
    public FoodOrderEntity mapRow(ResultSet rs, int arg) throws SQLException {

        FoodOrderEntity foodOrderEntity = new FoodOrderEntity();
        ResultSetMetaData meta = rs.getMetaData();


  /*  foodorderid
foodid
orderId
quantity*/

        for (int i = 0; i < meta.getColumnCount(); i++) {
            // System.out.println(">>> Name :" + meta.getColumnLabel(i+1));
            String fieldName = meta.getColumnName(i + 1);

            switch (fieldName) {
                
            case"foodorderid":
            foodOrderEntity.setFoodOrderId(rs.getString("foodorderid"));
            break;

            case"foodid":
            foodOrderEntity.setFoodId(rs.getString("foodid"));
            break;

            case"orderid":
            foodOrderEntity.setOrderId(rs.getString("orderid"));
            break;

            case"quantity":
            foodOrderEntity.setQuantity(rs.getInt("quantity"));
            break;
            }
        }
        return foodOrderEntity;
    }

    
}