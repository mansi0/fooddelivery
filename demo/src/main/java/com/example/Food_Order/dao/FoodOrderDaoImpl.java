package com.example.Food_Order.dao;

import java.text.ParseException;
import java.util.UUID;

import com.example.Food_Order.entity.FoodOrderEntity;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

/**
 * FoodOrderDaoImpl
 */
@Repository
public class FoodOrderDaoImpl implements FoodOrderDao {

    NamedParameterJdbcTemplate template;

    public FoodOrderDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

     /*  foodorderid
foodid
orderId
quantity*/


    @Override
    public int addFoodOrder(FoodOrderEntity foodOrderEntity) throws ParseException {

        UUID uuid = UUID.randomUUID();

        try {
            String sql = "insert into food_order values(:foodorderid,:foodid,:orderid,:quantity)";

            MapSqlParameterSource param = new MapSqlParameterSource().addValue("foodorderid", uuid.toString())
                    .addValue("foodid", foodOrderEntity.getFoodId())
                    .addValue("orderid", foodOrderEntity.getOrderId())
                    .addValue("quantity", foodOrderEntity.getQuantity());
                    

            return template.update(sql, param);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return 0;
        }

    }


    
 

}