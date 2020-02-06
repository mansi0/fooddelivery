package com.example.HomeDelivery.dao;

import java.util.UUID;

import com.example.HomeDelivery.entity.HomeDeliveryEntity;

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

    /*
     homeDeliveryId
homeDeliveryAddress
orderId
deliveryboyid
     */

    @Override
    public int addHomeDelivery(HomeDeliveryEntity homeDeliveryEntity) {

        UUID uuid = UUID.randomUUID();

        try {
            String sql = "insert into homedelivery values(:homedeliveryid,:homedeliveryaddress,:orderid,:deliveryboyid)";

            
            SqlParameterSource param = new MapSqlParameterSource().addValue("homedeliveryid", uuid.toString())
                    .addValue("homedeliveryaddress", homeDeliveryEntity.getHomeDeliveryAddress())
                    .addValue("orderid", homeDeliveryEntity.getOrderId())
                    .addValue("deliveryboyid", homeDeliveryEntity.getDeliveryboyId());

            return template.update(sql, param);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("HomeDeliveryDaoImpl::addHomedelivery" + e.getMessage());
            return 0;
        }

    }


    
}