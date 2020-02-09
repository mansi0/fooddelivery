package com.example.Hotel_Food.dao;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import com.example.Hotel_Food.entity.HotelFoodEntity;
import com.example.Hotel_Food.mapping.HotelFoodMapping;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 * HotelFoodDaoImpl
 */
@Repository
public class HotelFoodDaoImpl implements HotelFoodDao {

    NamedParameterJdbcTemplate template;

    public HotelFoodDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public int addHotelFood(HotelFoodEntity hotelFoodEntity) throws ParseException {

        UUID uuid = UUID.randomUUID();

        try {
            String sql = "insert into hotel_food values(:hotelfoodid,:hotelid,:foodid,:foodspeciality,:price,:size)";

            SqlParameterSource param = new MapSqlParameterSource().addValue("hotelfoodid", uuid.toString())
                    .addValue("hotelid", hotelFoodEntity.getHotelId()).addValue("foodid", hotelFoodEntity.getFoodId())
                    .addValue("foodspeciality", hotelFoodEntity.getFoodSpeciality())
                    .addValue("size", hotelFoodEntity.getSize()).addValue("price", hotelFoodEntity.getPrice());

            return template.update(sql, param);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return 0;
        }

    }

    @Override
    public List<HotelFoodEntity> getDetailsByHotelId(String hotelId) throws ParseException {

        String sql = "select * from hotel_food where hotelid=:hotelId";
        SqlParameterSource param = new MapSqlParameterSource().addValue("hotelId", hotelId);

        List<HotelFoodEntity> hotelFoodEntity = template.query(sql, param, new HotelFoodMapping());

        return hotelFoodEntity;

    }


    @Override
    public List<HotelFoodEntity> getDetailsByFoodId(String foodId) throws ParseException {
        String sql = "select * from hotel_food where foodid=:foodid";
        SqlParameterSource param = new MapSqlParameterSource().addValue("foodid", foodId);

        List<HotelFoodEntity> hotelFoodEntity = template.query(sql, param, new HotelFoodMapping());

        return hotelFoodEntity;

    }

    @Override
    public List<HotelFoodEntity> getDetailsByHotelFoodId(String hotelFoodId) throws ParseException {
   
        String sql = "select * from hotel_food where hotelfoodid=:hotelfoodid";
        SqlParameterSource param = new MapSqlParameterSource().addValue("hotelfoodid", hotelFoodId);

        List<HotelFoodEntity> hotelFoodEntity = template.query(sql, param, new HotelFoodMapping());

        return hotelFoodEntity;

    }
}