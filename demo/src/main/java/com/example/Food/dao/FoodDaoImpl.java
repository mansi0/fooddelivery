package com.example.Food.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.Food.entity.FoodEntity;
import com.example.Food.mapping.FoodMapping;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 * FoodDaoImpl
 */
@Repository
public class FoodDaoImpl implements FoodDao {

    NamedParameterJdbcTemplate template;

    public FoodDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;

    }

    @Override
    public List<FoodEntity> checkDuplicationOfFood(FoodEntity FoodEntity) {

        List<FoodEntity> listOfFoodEntities = new ArrayList<FoodEntity>();

        try {

            String sql = "select * from food where foodname = :foodname";
            SqlParameterSource param = new MapSqlParameterSource().addValue("foodname", FoodEntity.getFoodname());

            listOfFoodEntities = template.query(sql, param, new FoodMapping());

            return listOfFoodEntities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;

        }
    }

    @Override
    public int addFood(FoodEntity foodEntity) throws ParseException {
        UUID uuid = UUID.randomUUID();

        try {
            String sql = "insert into food values(:foodid,:foodname,:foodtype,:category)";

            SqlParameterSource param = new MapSqlParameterSource().addValue("foodid", uuid.toString())
                    .addValue("foodname", foodEntity.getFoodname()).addValue("foodtype", foodEntity.getFoodtype())
                    .addValue("category", foodEntity.getCategory());

            return template.update(sql, param);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return 0;
        }

    }


    @Override
  public List<FoodEntity> fetchByFoodName(String foodName) {

    List<FoodEntity> listOfFoodEntities = new ArrayList<FoodEntity>();

    try {

      String sql = "select * from food where foodname = :foodname";

      SqlParameterSource param = new MapSqlParameterSource().addValue("foodname", foodName);

      
      listOfFoodEntities = template.query(sql, param, new FoodMapping());

      

      return listOfFoodEntities;
    } catch (Exception e) {

      throw e;
    }

  }



}