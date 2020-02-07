package com.example.Hotel_Order.dao;

import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.UUID;

import com.example.Hotel_Order.entity.HotelOrderEntity;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;


/**
 * HotelOrderDaoImpl
 */
@Repository
public class HotelOrderDaoImpl implements HotelOrderDao {

    NamedParameterJdbcTemplate template;

    public HotelOrderDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public int addHotelOrder(HotelOrderEntity hotelOrderEntity) throws ParseException {

        UUID uuid = UUID.randomUUID();


        /* hotelorderid
hotelid
orderId*/

        try {
            String sql = "insert into hotel_order values(:hotelorderid,:hotelid,:orderid)";

            SqlParameterSource param = new MapSqlParameterSource().addValue("hotelorderid", uuid.toString())
                    .addValue("hotelid", hotelOrderEntity.getHotelId())
                    .addValue("orderid", hotelOrderEntity.getOrderId());
                    
            return template.update(sql, param);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return 0;
        }

    }
}