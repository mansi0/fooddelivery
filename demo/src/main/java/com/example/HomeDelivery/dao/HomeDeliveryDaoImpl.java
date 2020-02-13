package com.example.HomeDelivery.dao;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import com.example.HomeDelivery.entity.HomeDeliveryEntity;
import com.example.HomeDelivery.mapping.HomeDeliveryMapping;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 * HomeDeliveryDaoImpl
 */
@Repository
public class HomeDeliveryDaoImpl implements HomeDeliveryDao {

    NamedParameterJdbcTemplate template;

    public HomeDeliveryDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;

    }


    @Override
    public List<HomeDeliveryEntity> getDetailsByOrderId(String orderId) throws ParseException {
        
        String sql ="select * from homedelivery where orderid=:orderid";

        SqlParameterSource param = new MapSqlParameterSource().addValue("orderid", orderId);


      List<HomeDeliveryEntity> homeDeliveryEntities = template.query(sql, param, new HomeDeliveryMapping());


      return homeDeliveryEntities;
    
    }

    @Override
    public int updateOrderByStatus(HomeDeliveryEntity homeDeliveryEntity) throws ParseException {
        String sql = "update homedelivery set status=:status where orderid=:orderid";
        SqlParameterSource param = new MapSqlParameterSource()
        .addValue("status", homeDeliveryEntity.getStatus())
        .addValue("orderid",homeDeliveryEntity.getOrderId());
        
        return template.update(sql, param);
        
    }
    

    
    /*homeDeliveryId
address
locality
landmark
city
state
status
orderId
deliveryboyid*/
 

    @Override
    public int addHomeDelivery(HomeDeliveryEntity homeDeliveryEntity) {

        UUID uuid = UUID.randomUUID();

        try {
            String sql = "insert into homedelivery values(:homedeliveryid,:address,:locality,:landmark,:city,:state,:status,:orderid)";

            
            SqlParameterSource param = new MapSqlParameterSource().addValue("homedeliveryid", uuid.toString())
                    .addValue("address", homeDeliveryEntity.getAddress())
                    .addValue("locality", homeDeliveryEntity.getLocality())
                    .addValue("landmark", homeDeliveryEntity.getLandmark())
                    .addValue("city", homeDeliveryEntity.getCity())
                    .addValue("state", homeDeliveryEntity.getState())
                    .addValue("status", homeDeliveryEntity.getStatus())
                    .addValue("orderid", homeDeliveryEntity.getOrderId());
                    

            return template.update(sql, param);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("HomeDeliveryDaoImpl::addHomedelivery" + e.getMessage());
            return 0;
        }

    }


    
}