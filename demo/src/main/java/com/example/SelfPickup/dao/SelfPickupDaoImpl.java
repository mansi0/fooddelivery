package com.example.SelfPickup.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import com.example.SelfPickup.entity.SelfPickupEntity;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 * SelfPickupDaoImpl
 */
@Repository
public class SelfPickupDaoImpl implements SelfPickupDao {

    NamedParameterJdbcTemplate template;

    public SelfPickupDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;

    }

     /*selfPickUpId
pickUpTime
pickUpDate
orderId*/
     

    @Override
    public int addSelfPickup(SelfPickupEntity selfPickupEntity ) {

        UUID uuid = UUID.randomUUID();

        try {
            String sql = "insert into selfpickup values(:selfpickupid,:pickuptime,:pickupdate,:orderid)";

            DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
            Date date = new Date();
            // long epoch = System.currentTimeMillis()/1000;
            DateFormat parser = new SimpleDateFormat("yyyy-mm-dd");
            Date parsedDate = parser.parse(dateFormat.format(date));

            /*SimpleDateFormat sdf;
            sdf = new SimpleDateFormat("hh:mm");
            try {
                date = sdf.parse(a.getString("time").toString());
                System.out.println("onCreate: " + date);
                System.out.println( "onCreate: " + a.getString("time"));
            } catch (ParseException e) {
                e.printStackTrace();
            }*/

            Calendar cal = Calendar.getInstance();

            Date datet=cal.getTime();
        
            DateFormat dateFormatt = new SimpleDateFormat("HH:mm:ss");
        
            Date formattedDate=dateFormatt.parse(dateFormatt.format(datet));
        
            System.out.println("Current time of the day using Calendar - 24 hour format: "+ formattedDate);

            SqlParameterSource param = new MapSqlParameterSource().addValue("selfpickupid", uuid.toString())
                    .addValue("pickuptime", formattedDate)
                    .addValue("pickupdate", parsedDate)
                    .addValue("orderid", selfPickupEntity.getOrderId());
                    
            return template.update(sql, param);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("SelfPIckupDaoImpl::addSelfPickup" + e.getMessage());
            return 0;
        }

    }

    
}