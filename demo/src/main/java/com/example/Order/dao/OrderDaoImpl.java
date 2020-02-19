package com.example.Order.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.example.Order.entity.OrderEntity;
import com.example.Order.mapping.OrderMapping;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 * orderDaoImpl
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    NamedParameterJdbcTemplate template;

    public OrderDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;

    }

    /*
     * orderId customerId rderDate orderTime cookingInstruction
     */

     @Override
     public List<OrderEntity> getDetails() throws ParseException {
         String sql="select * from order1";
         List<OrderEntity> listOfEntities=template.query(sql,new OrderMapping());
         return listOfEntities;
     }

    @Override
    public List<OrderEntity> getDetailsByTotalOfDay() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        Date date = new Date();

        DateFormat parser = new SimpleDateFormat("yyyy-mm-dd");
        Date parsedDate = parser.parse(dateFormat.format(date));

        String sql="select * from order1 where orderdate=:parsedDate;";
        SqlParameterSource param = new MapSqlParameterSource().addValue("parsedDate", parsedDate);

        List<OrderEntity> listOfOrderEntities = template.query(sql,param, new OrderMapping());

       return listOfOrderEntities;
    }

    @Override
    public List<OrderEntity> getDetailsByTime(int hrs,int min,String d) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        Date date = new Date();

        DateFormat parser = new SimpleDateFormat("yyyy-mm-dd");
        Date parsedDate = parser.parse(dateFormat.format(date));

        String sql = "select * from order1 where extract (HOUR from ordertime) ="+hrs+" and extract (MINUTE from ordertime)="+min+" and orderdate=:parsedDate;";
        SqlParameterSource param = new MapSqlParameterSource().addValue("parsedDate", parsedDate);

        List<OrderEntity> listOfOrderEntities = template.query(sql,param, new OrderMapping());

        return listOfOrderEntities;

    }

    @Override
    public List<OrderEntity> getDetailsByHotelId(String hotelId) throws ParseException {
        String sql="select * from order1 where hotelid=:hotelid";
        SqlParameterSource param= new MapSqlParameterSource().addValue("hotelid", hotelId);
        List<OrderEntity> lOrderEntities = template.query(sql, param,new OrderMapping());
        return lOrderEntities;
    }
     @Override
    public int deleteOrder(String orderId) throws ParseException {
        // TODO Auto-generated method stub

        String sql= "delete from order1 where orderId=:orderId";
        SqlParameterSource param = new MapSqlParameterSource().addValue("orderId", orderId);
        return template.update(sql, param);
        
    }

    @Override
    public int updateOrderByTotal(OrderEntity orderEntity) throws ParseException {
        String sql = "update order1 set total=:total,status=:status where orderid=:orderid";
        SqlParameterSource param = new MapSqlParameterSource()
        .addValue("total", orderEntity.getTotal())
        .addValue("orderid", orderEntity.getOrderId())
        .addValue("status", orderEntity.getStatus());
        
        return template.update(sql, param);
        
    }

   /* @Override
    public int updateOrderByStatus(OrderEntity orderEntity) throws ParseException {
        String sql = "update order1 set status=:status where orderid=:orderid";
        SqlParameterSource param = new MapSqlParameterSource()
        .addValue("status", orderEntity.getStatus())
        .addValue("orderid", orderEntity.getOrderId());
        
        return template.update(sql, param);
        
    }*/

    @Override
    public int addOrder(OrderEntity orderEntity) {

        UUID uuid = UUID.randomUUID();

        try {
            String sql = "insert into order1 values(:orderid,:customerid,:hotelid,:orderdate,:ordertime)";

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

            SqlParameterSource param = new MapSqlParameterSource().addValue("orderid", uuid.toString())
                    .addValue("customerid", orderEntity.getCustomerId())
                    .addValue("hotelid", orderEntity.getHotelId())
                    .addValue("orderdate", parsedDate)
                    .addValue("ordertime", formattedDate);


            return template.update(sql, param);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("FoodDaoImpl::addFood" + e.getMessage());
            return 0;
        }

    }

}