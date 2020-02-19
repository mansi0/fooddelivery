package com.example.Deliveryboy.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.example.Deliveryboy.entity.DeliveryboyEntity;
import com.example.Deliveryboy.mapping.DeliveryboyMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 * DeliveryboyDaoImpl
 */
@Repository
public class DeliveryboyDaoImpl implements DeliveryboyDao {
  NamedParameterJdbcTemplate template;

  Logger logger = LoggerFactory.getLogger(DeliveryboyDaoImpl.class);

  public DeliveryboyDaoImpl(NamedParameterJdbcTemplate template) {
    this.template = template;

  }

  @Override
  public List<DeliveryboyEntity> getDetail() {

    String sql = "select * from deliveryboy";
    List<DeliveryboyEntity> listOfDeliveryboy = template.query(sql, new DeliveryboyMapping());

    return listOfDeliveryboy;
  }

  @Override
  public List<DeliveryboyEntity> getDetailsByEmailId(String emailId) {
    String sql="select * from deliveryboy where deliveryboyemailid=:deliveryboyemailid";
    SqlParameterSource param = new MapSqlParameterSource().addValue("deliveryboyemailid", emailId);

    List<DeliveryboyEntity> listOfDeliveryboyEntities = template.query(sql, param, new DeliveryboyMapping());
    return listOfDeliveryboyEntities;
  }


  @Override
  public List<DeliveryboyEntity> getDetailsByDeliveryboyId(String deliveryboyId) {
    String sql="select * from deliveryboy where deliveryboyid=:deliveryboyid";
    SqlParameterSource param = new MapSqlParameterSource().addValue("deliveryboyid", deliveryboyId);

    List<DeliveryboyEntity> listOfDeliveryboyEntities = template.query(sql, param, new DeliveryboyMapping());
    return listOfDeliveryboyEntities;
  }

  @Override
  public int updateOrderByStatus(DeliveryboyEntity deliveryboyEntity) throws ParseException {
        String sql = "update deliveryboy set deliveryboystatus=:deliveryboystatus where deliveryboyid=:deliveryboyid";
        SqlParameterSource param = new MapSqlParameterSource()
        .addValue("deliveryboystatus", deliveryboyEntity.getDeliveryboyStatus())
        .addValue("deliveryboyid", deliveryboyEntity.getDeliveryboyId());
        
        return template.update(sql, param);
        
    }

    @Override
    public int updateOrderByActivity(DeliveryboyEntity deliveryboyEntity) throws ParseException {
      
      String sql = "update deliveryboy set deliveryboyactivity=:deliveryboyactivity where deliveryboyid=:deliveryboyid";
      SqlParameterSource param = new MapSqlParameterSource()
      .addValue("deliveryboyactivity", deliveryboyEntity.getDeliveryboyActivity())
      .addValue("deliveryboyid", deliveryboyEntity.getDeliveryboyId());
      
      return template.update(sql, param);
      
    }

    @Override
    public int updateOrderByPendingAmount(DeliveryboyEntity deliveryboyEntity) throws ParseException {
      String sql = "update deliveryboy set pendingamount=:pendingamount where deliveryboyid=:deliveryboyid";
      SqlParameterSource param = new MapSqlParameterSource()
      .addValue("pendingamount", deliveryboyEntity.getDeliveryboyActivity())
      .addValue("deliveryboyid", deliveryboyEntity.getDeliveryboyId());
      
      return template.update(sql, param);
      
    }

    @Override
    public List<DeliveryboyEntity> getDetailsByActivity() throws ParseException {

      List<DeliveryboyEntity> listOfDeliveryboy = new ArrayList<DeliveryboyEntity>();

    try {

      String sql = "select * from deliveryboy where deliveryboystatus = "+1+" and deliveryboyactivity="+0;

     // SqlParameterSource param = new MapSqlParameterSource()
     // .addValue("deliveryboyEmailId",deliveryboyEntity.getDeliveryboyEmailId());

      listOfDeliveryboy = template.query(sql, new DeliveryboyMapping());

      return listOfDeliveryboy;
    }
    catch (Exception e) {
      logger.error("DAO::DeliveryboyDaoImp::checkDuplicateEmail::error:: " + e.getMessage());
      logger.error("DAO::DeliveryboyDaoImp::checkDuplicateEmail::error:: " + e.getStackTrace());
      throw e;
    }
      
    }


  @Override
  public List<DeliveryboyEntity> checkDuplicationOfEmail(DeliveryboyEntity deliveryboyEntity) {

    List<DeliveryboyEntity> listOfDeliveryboy = new ArrayList<DeliveryboyEntity>();

    try {

      String sql = "select * from deliveryboy where deliveryboyEmailId = :deliveryboyEmailId";

      SqlParameterSource param = new MapSqlParameterSource().addValue("deliveryboyEmailId",
          deliveryboyEntity.getDeliveryboyEmailId());

      listOfDeliveryboy = template.query(sql, param, new DeliveryboyMapping());
      logger.debug("DAO::DeliveryboyDaoImp::getDetail::listOfDeliveryboy::listOfDeliveryboy:: " + listOfDeliveryboy);

      return listOfDeliveryboy;
    }
    catch (Exception e) {
      logger.error("DAO::DeliveryboyDaoImp::checkDuplicateEmail::error:: " + e.getMessage());
      logger.error("DAO::DeliveryboyDaoImp::checkDuplicateEmail::error:: " + e.getStackTrace());
      throw e;
    }
  }

  /**
   * function addDeliveryboy
   * 
   * @param deliveryboy
   * @return int
   * @throws ParseException
   * @throws Exception
   */
  @Override
  public int addDeliveryboy(DeliveryboyEntity deliveryboyEntity) throws ParseException {

    UUID uuid = UUID.randomUUID();
    DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
    Date date = new Date();
    // long epoch = System.currentTimeMillis()/1000;
    DateFormat parser = new SimpleDateFormat("yyyy-mm-dd");
    Date parsedDate = parser.parse(dateFormat.format(date));

    try {

      String sql = "insert into deliveryboy values (:deliveryboyid,:deliveryboyname,:deliveryboyaddress,:deliveryboyemailid,:deliveryboycontno,:deliveryarea,:deliveryboypassword,:accountdate)";

      logger.debug("DAO::DeliveryboyDaoImp::addDeliveryboy::sql:: " + sql);
      SqlParameterSource param = new MapSqlParameterSource().
        addValue("deliveryboyid", uuid.toString())
          .addValue("deliveryboyname", deliveryboyEntity.getDeliveryboyName())
          .addValue("deliveryboyaddress", deliveryboyEntity.getDeliveryboyAddress())
          .addValue("deliveryboyemailid", deliveryboyEntity.getDeliveryboyEmailId())
          .addValue("deliveryboycontno", deliveryboyEntity.getDeliveryboyContNo())
          .addValue("deliveryarea", deliveryboyEntity.getDeliveryArea())
          .addValue("deliveryboypassword", deliveryboyEntity.getDeliveryboyPassword())
          .addValue("accountdate", parsedDate);
      logger.debug("DAO::DeliveryboyDaoImp::addDeliveryboy::param:: " + param);

      return template.update(sql, param);
    } catch (Exception e) {
      logger.error("DAO::DeliveryboyDaoImp::addDeliveryboy::error****:: " + e.getMessage());
      logger.error("DAO::DeliveryboyDaoImp::addDeliveryboy::error:: " + e.getStackTrace());

      throw e;

    }

  }

  @Override
  public void updateDeliveryboy(DeliveryboyEntity deliveryboyEntity) {

    try {

      String sql = "update deliveryboy set notification = :notification where deliveryboyid = :deliveryboyid";

      SqlParameterSource param = new MapSqlParameterSource()
          .addValue("notification", deliveryboyEntity.isNotification())
          .addValue("deliveryboyid", deliveryboyEntity.getDeliveryboyId());

      logger.debug("DAO::DeliveryboyDao::updateDeliveryboy::sql:: " + sql);
      // logger.debug("DAO::UserDao::updateUser::param:: " +
      // ObjectPrinter.print(param));

      template.update(sql, param);

    } catch (Exception e) {
      logger.error("DAO::DeliveryboyDao::updateDeliveryboy::error:: " + e.getMessage());
      e.printStackTrace();
    }
  }

  @Override
  public List<DeliveryboyEntity> fetchByEmailId(String email) {

    List<DeliveryboyEntity> listOfDeliveryboy = new ArrayList<DeliveryboyEntity>();

    try {

      String sql = "select * from deliveryboy where deliveryboyemailid = :deliveryboyemailid";

      SqlParameterSource param = new MapSqlParameterSource().addValue("deliveryboyemailid", email);

      // System.out.println("sql :: " + sql);
      listOfDeliveryboy = template.query(sql, param, new DeliveryboyMapping());

      // System.out.println("listof user :: " + listOfUser);
      logger.debug("DAO::DeliveryboyDaoImp::fetchByEmail::listOfDeliveryboy:: " + listOfDeliveryboy);

      return listOfDeliveryboy;
    } catch (Exception e) {

      throw e;
    }

  }
}