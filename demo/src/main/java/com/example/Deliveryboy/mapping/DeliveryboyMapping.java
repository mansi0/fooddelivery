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

        deliveryboyEntity.setDeliveryboyId(rs.getString("deliveryboyid"));
        deliveryboyEntity.setDeliveryboyName(rs.getString("deliveryboyname"));
        deliveryboyEntity.setDeliveryboyAddress(rs.getString("deliveryboyaddress"));
        deliveryboyEntity.setDeliveryboyEmailId(rs.getString("deliveryboyemailid"));
        deliveryboyEntity.setDeliveryboyContNo(rs.getString("deliveryboycontno"));
        deliveryboyEntity.setDeliveryboySalary(rs.getFloat("deliveryboysalary"));
        deliveryboyEntity.setDeliveryArea(rs.getString("deliveryArea"));
        deliveryboyEntity.setDeliveryboyStatus(rs.getString("deliveryBoyStatus"));
        deliveryboyEntity.setDeliveryboyPassword(rs.getString("deliveryBoypassword"));
        deliveryboyEntity.setNoOfDays(rs.getInt("noofdays"));
        deliveryboyEntity.setDeliveryboyShift(rs.getString("deliveryboyshift"));
        deliveryboyEntity.setNoOfDelivery(rs.getInt("noofdelivery"));
        deliveryboyEntity.setAccountDate(rs.getDate("accountdate"));
        deliveryboyEntity.setNotification(rs.getBoolean("notification"));
        
     return deliveryboyEntity;
    }

    
}