package com.example.Food_Order.dao;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import com.example.Food_Order.entity.FoodOrderEntity;
import com.example.Food_Order.mapping.FoodOrderMapping;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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
    public List<FoodOrderEntity> getDetailsByOrderId(String orderId) throws ParseException {
        String sql ="select * from food_order where orderid=:orderid";

        SqlParameterSource param = new MapSqlParameterSource().addValue("orderid", orderId);


      List<FoodOrderEntity> foodOrderEntities = template.query(sql, param, new FoodOrderMapping());


      return foodOrderEntities;
    }

    @Override
    public int deleteFoodOrder(String orderId) throws ParseException {
        String sql= "delete from food_order where orderId=:orderId";
        SqlParameterSource param = new MapSqlParameterSource().addValue("orderId", orderId);
        return template.update(sql, param);
        
    }


    @Override
    public int addFoodOrder(FoodOrderEntity foodOrderEntity) throws ParseException {

        UUID uuid = UUID.randomUUID();

        try {
            String sql = "insert into food_order values(:foodorderid,:hotelfoodid,:orderid,:quantity)";

            MapSqlParameterSource param = new MapSqlParameterSource().addValue("foodorderid", uuid.toString())
                    .addValue("hotelfoodid", foodOrderEntity.getHotelFoodId())
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