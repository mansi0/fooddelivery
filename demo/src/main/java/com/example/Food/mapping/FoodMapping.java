package com.example.Food.mapping;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.example.Food.entity.FoodEntity;

/**
 * FoodMapping
 */
public class FoodMapping implements RowMapper<FoodEntity> {

    @Override
    public FoodEntity mapRow(ResultSet rs, int arg) throws SQLException {

        FoodEntity foodEntity = new FoodEntity();
        ResultSetMetaData meta = rs.getMetaData();

        for (int i = 0; i < meta.getColumnCount(); i++) {
            // System.out.println(">>> Name :" + meta.getColumnLabel(i+1));
            String fieldName = meta.getColumnName(i + 1);

            switch (fieldName) {

            case "foodid":
            foodEntity.setFoodId(rs.getString("foodid"));
            break;

            case "foodname" :
            foodEntity.setFoodName(rs.getString("foodname"));
            break;

            case "foodtype" :
            foodEntity.setFoodType(rs.getInt("foodtype"));
            break;

            case "category" :
            foodEntity.setCategory(rs.getString("category"));
            break;
            }
        }
        return foodEntity;
    }
}


    
