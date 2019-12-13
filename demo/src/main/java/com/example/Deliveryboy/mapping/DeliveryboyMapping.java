package com.example.Deliveryboy.mapping;
import com.example.Deliveryboy.entity.DeliveryboyEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * CustomerMapping
 */
public class DeliveryboyMapping implements RowMapper<DeliveryboyEntity> {
    @Override
    public DeliveryboyEntity mapRow(ResultSet rs,int arg) throws SQLException {

        DeliveryboyEntity deliveryboyEntity=new DeliveryboyEntity();

        deliveryboyEntity.setDeliveryboyid(rs.getString("deliveryboyid"));
        deliveryboyEntity.setDeliveryboyname(rs.getString("deliveryboyname"));
        deliveryboyEntity.setDeliveryboyaddress(rs.getString("deliveryboyaddress"));
        deliveryboyEntity.setDeliveryboyemailid(rs.getString("deliveryboyemailid"));
        deliveryboyEntity.setDeliveryboycontno(rs.getString("deliveryboycontno"));
        deliveryboyEntity.setDeliveryboysalary(rs.getFloat("deliveryboysalary"));
        deliveryboyEntity.setDeliveryArea(rs.getString("deliveryArea"));
        deliveryboyEntity.setDeliveryBoyStatus(rs.getString("deliveryBoyStatus"));
        deliveryboyEntity.setDeliveryBoyPassword(rs.getString("deliberyBoypassword"));
        deliveryboyEntity.setNoofdays(rs.getInt("noofdays"));
        deliveryboyEntity.setDeliveryboyshift(rs.getString("deliveryboyshift"));
        deliveryboyEntity.setNoofdelivery(rs.getInt("noofdelivery"));
        deliveryboyEntity.setNotification(rs.getBoolean("notification"));
        
     return deliveryboyEntity;
    }

    
}