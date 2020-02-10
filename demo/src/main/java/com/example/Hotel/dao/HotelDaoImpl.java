package com.example.Hotel.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.example.Hotel.entity.HotelEntity;
import com.example.Hotel.mapping.HotelMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 * HotelDaoImpl
 */
@Repository

public class HotelDaoImpl implements HotelDao {

  NamedParameterJdbcTemplate template;

  Logger logger = LoggerFactory.getLogger(HotelDaoImpl.class);

  public HotelDaoImpl(NamedParameterJdbcTemplate template) {
    this.template = template;

  }


  @Override
  public List<HotelEntity> getDetailByName(String hotelName) {

    String sql = "select * from hotel where hotelName=:hotelName";
    SqlParameterSource param = new MapSqlParameterSource().addValue("hotelName", hotelName);
    List<HotelEntity> listOfHotel = template.query(sql,param, new HotelMapping());

    return listOfHotel;
  }
  @Override
  public List<HotelEntity> getDetails() {
    String sql = "select * from hotel";
    List<HotelEntity> listOfHotel = template.query(sql, new HotelMapping());

    return listOfHotel;
  }

  @Override
  public List<HotelEntity> getDetailsByHotelId(String hotelId) {
    String sql ="select * from hotel where hotelid=:hotelid";
    SqlParameterSource param = new MapSqlParameterSource().addValue("hotelid", hotelId);

    List<HotelEntity> listOfHotel = template.query(sql,param, new HotelMapping());
    return listOfHotel;
  }

  @Override
  public List<HotelEntity> getDetailsByHotelEmailId(String hotelEmailId) {
    String sql ="select * from hotel where hotelemailid=:hotelEmailId";
    SqlParameterSource param = new MapSqlParameterSource().addValue("hotelEmailId", hotelEmailId);

    List<HotelEntity> listOfHotel = template.query(sql,param, new HotelMapping());
    return listOfHotel;
  }

  @Override
  public List<HotelEntity> getDetailsByHotelFacility(int index) {
    String sql ="select * from hotel where hotelfacility["+index+"]='1'";
   // SqlParameterSource param = new MapSqlParameterSource().addValue("hotelfacility",index);
    List<HotelEntity> listOfHotel = template.query(sql, new HotelMapping());
    return listOfHotel;

  }

  @Override
  public List<HotelEntity> getDetailsByHotelCuisine(int index) {
    String sql ="select * from hotel where hotelcuisine["+index+"]='1'";
   // SqlParameterSource param = new MapSqlParameterSource().addValue("hotelfacility",index);
    List<HotelEntity> listOfHotel = template.query(sql, new HotelMapping());
    return listOfHotel;
  }

  @Override
  public List<HotelEntity> getDetailsByHotelMenuType(String type) {
    String sql ="select * from hotel where hotelmenutype=:hotelmenutype";
    SqlParameterSource param = new MapSqlParameterSource().addValue("hotelmenutype",type);
    List<HotelEntity> listOfHotel = template.query(sql,param, new HotelMapping());
    return listOfHotel;
  }

  @Override
  public List<HotelEntity> getDetailsByExpressDelivery() {

    boolean val=true;
    String sql ="select * from hotel where expressdelivery=:expressdelivery";
    SqlParameterSource param = new MapSqlParameterSource().addValue("expressdelivery",val);
    List<HotelEntity> listOfHotel = template.query(sql,param, new HotelMapping());
    return listOfHotel;
    
  }

  @Override
  public List<HotelEntity> getDetailsByNearBy(String locality) {
    
    String sql ="select * from hotel where hotellocality=:hotellocality";
    SqlParameterSource param = new MapSqlParameterSource().addValue("hotellocality",locality);
    List<HotelEntity> listOfHotel = template.query(sql,param, new HotelMapping());
    return listOfHotel;
  }

  @Override
  public List<HotelEntity> checkDuplicationOfEmail(HotelEntity hotelEntity) {

    List<HotelEntity> listOfHotel = new ArrayList<HotelEntity>();

    try {

      String sql = "select * from hotel where hotelEmailId = :hotelEmailId" ;
      SqlParameterSource param = new MapSqlParameterSource().addValue("hotelEmailId", hotelEntity.getHotelEmailId());

      listOfHotel = template.query(sql, param, new HotelMapping());
      logger.debug("DAO::HotelDaoImp::getDetail::listOfHotel::listOfHotel:: " + listOfHotel);

      return listOfHotel;
    } 
    catch (Exception e) {
      logger.error("DAO::HotelDaoImp::checkDuplicateEmail::error:: " + e.getMessage());
      logger.error("DAO::HotelDaoImp::checkDuplicateEmail::error:: " + e.getStackTrace());
      throw e;
    }
  }

  /**
   * function addHotel
   * 
   * @param hotel
   * @return int
   * @throws ParseException
   * @throws Exception
   */
  @Override
  public int addHotel(HotelEntity hotelEntity) throws ParseException {

    UUID uuid = UUID.randomUUID();
    DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
    Date date = new Date();
    // long epoch = System.currentTimeMillis()/1000;
    DateFormat parser = new SimpleDateFormat("yyyy-mm-dd");
    Date parsedDate = parser.parse(dateFormat.format(date));

    try {

      String sql = "insert into hotel values(:hotelid,:hotelpassword,:hotelemailid,:hotelcontno,:hotelname,:hoteladdress,:hotellocality,:hotellandmark,:hotelcity,:hotelstate,:openat,:closeat,:approximatecost,:hotelopeningdate,:expressdelivery,:hotelstatus,:hotelmenutype,:hotelfacility,:hotelcuisine,:hotelimage)";
      logger.debug("DAO::HotelDaoImp::addHotel::sql:: " + sql);
     /* int[] numbers = new int[hotelEntity.hotelFacility.length];
      for (int i = 0; i < hotelEntity.hotelFacility.length; i++) {
        // Note that this is assuming valid input
        // If you want to check then add a try/catch
        // and another index for the numbers if to continue adding the others (see
        // below)
        numbers[i] = Integer.parseInt(hotelEntity.hotelFacility[i]);
      }*/
      SqlParameterSource param = new MapSqlParameterSource().addValue("hotelid", uuid.toString())
          .addValue("hotelpassword", hotelEntity.getHotelPassword())
          .addValue("hotelemailid", hotelEntity.getHotelEmailId()).addValue("hotelcontno", hotelEntity.getHotelContNo())
          .addValue("hotelname", hotelEntity.getHotelName()).addValue("hoteladdress", hotelEntity.getHotelAddress())
          .addValue("hotellocality", hotelEntity.getHotelLocality())
          .addValue("hotellandmark", hotelEntity.getHotelLandmark()).addValue("hotelcity", hotelEntity.getHotelCity())

          .addValue("hotelstate", hotelEntity.getHotelState()).addValue("openat", hotelEntity.getOpenAt())
          .addValue("closeat", hotelEntity.getCloseAt()).addValue("approximatecost", hotelEntity.getApproximateCost())
          .addValue("hotelopeningdate", hotelEntity.getHotelOpeningDate())
          .addValue("expressdelivery", hotelEntity.isExpressDelivery())
          .addValue("hotelstatus", hotelEntity.getHotelStatus())
          .addValue("hotelmenutype", hotelEntity.getHotelMenuType())
          .addValue("hotelfacility", hotelEntity.getHotelFacility())
          .addValue("hotelcuisine", hotelEntity.getHotelCuisine())
          .addValue("hotelimage", hotelEntity.getHotelImage());

      logger.debug("DAO::HotelDaoImp::addHotel::param:: " + param);

      return template.update(sql, param);
    } catch (Exception e) {
      logger.error("DAO::HotelDaoImp::addHotel::error****:: " + e.getMessage());
      logger.error("DAO::HotelDaoImp::addHotel::error:: " + e.getStackTrace());

      throw e;
    }

  }

  @Override
  public void updateHotel(HotelEntity hotelEntity) {

    try {

      String sql = "update hotel set notification = :notification where hotelid = :hotelid";

      SqlParameterSource param = new MapSqlParameterSource().addValue("notification", hotelEntity.isNotification())
          .addValue("hotelid", hotelEntity.getHotelId());

      logger.debug("DAO::HotelDao::updateHotel::sql:: " + sql);
      // logger.debug("DAO::UserDao::updateUser::param:: " +
      // ObjectPrinter.print(param));

      template.update(sql, param);

    } catch (Exception e) {
      logger.error("DAO::HotelDao::updateHotel::error:: " + e.getMessage());
      e.printStackTrace();
    }
  }

  @Override
  public List<HotelEntity> fetchByEmailId(String email) {

    List<HotelEntity> listOfHotel = new ArrayList<HotelEntity>();

    try {

      String sql = "select * from hotel where hotelemailid = :hotelemailid";

      SqlParameterSource param = new MapSqlParameterSource().addValue("hotelemailid", email);

      // System.out.println("sql :: " + sql);
      listOfHotel = template.query(sql, param, new HotelMapping());

      // System.out.println("listof user :: " + listOfUser);
      logger.debug("DAO::HotelDaoImp::fetchByEmail::listOfHotel:: " + listOfHotel);

      return listOfHotel;
    } catch (Exception e) {

      throw e;
    }

  }

}