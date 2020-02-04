package com.example.Customer.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.example.Customer.entity.CustomerEntity;
import com.example.Customer.mapping.CustomerMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 * CustomerDaoImpl
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {
  NamedParameterJdbcTemplate template;

  Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

  public CustomerDaoImpl(NamedParameterJdbcTemplate template) {
    this.template = template;

  }

  @Override
  public List<CustomerEntity> getDetail() {

    String sql = "select * from Customer";
    List<CustomerEntity> listOfCustomer = template.query(sql, new CustomerMapping());

    return listOfCustomer;
  }

  @Override
  public List<CustomerEntity> getDetailsByEmailId(String emailId) {
    String sql="select * from customer where emailid=:emailid";
    SqlParameterSource param = new MapSqlParameterSource().addValue("emailid", emailId);

    List<CustomerEntity> listOfCustomer = template.query(sql, param, new CustomerMapping());
    return listOfCustomer;
  }




  @Override
  public List<CustomerEntity> checkDuplicationOfEmail(CustomerEntity customerEntity) {

    List<CustomerEntity> listOfCustomer = new ArrayList<CustomerEntity>();

    try {

      String sql = "select * from customer where emailId = :emailId";
      SqlParameterSource param = new MapSqlParameterSource().addValue("emailId", customerEntity.getEmailId());

      listOfCustomer = template.query(sql, param, new CustomerMapping());
      logger.debug("DAO::CustomerDaoImp::getDetail::listOfCustomer::listOfCustomer:: " + listOfCustomer);

      return listOfCustomer;
    } catch (Exception e) {
      logger.error("DAO::CustomerDaoImp::checkDuplicateEmail::error:: " + e.getMessage());
      logger.error("DAO::CustomerDaoImp::checkDuplicateEmail::error:: " + e.getStackTrace());
      throw e;
    }
  }

  /**
   * function addCustomer
   * 
   * @param customer
   * @return int
   * @throws ParseException
   * @throws Exception
   */
  @Override
  public int addCustomer(CustomerEntity customerEntity) throws ParseException {

    UUID uuid = UUID.randomUUID();
    DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
    Date date = new Date();
    // long epoch = System.currentTimeMillis()/1000;
    DateFormat parser = new SimpleDateFormat("yyyy-mm-dd");
    Date parsedDate = parser.parse(dateFormat.format(date));

    try {

      String sql = "insert into customer values(:customerid,:name,:address,:locality,:landmark,:city,:state,:emailid,:contno,:password,:accountdate)";
      logger.debug("DAO::CustomerDaoImp::addCustomer::sql:: " + sql);
      SqlParameterSource param = new MapSqlParameterSource().addValue("customerid", uuid.toString())
          .addValue("name", customerEntity.getName()).addValue("address", customerEntity.getAddress())
          .addValue("locality", customerEntity.getLocality()).addValue("landmark", customerEntity.getLandmark())
          .addValue("city", customerEntity.getCity()).addValue("state", customerEntity.getState())
          // .addValue("accounttype", customerEntity.getAccountType())
          .addValue("emailid", customerEntity.getEmailId())

          .addValue("contno", customerEntity.getContNo()).addValue("password", customerEntity.getPassword())
          .addValue("accountdate", parsedDate);

      logger.debug("DAO::CustomerDaoImp::addCustomer::param:: " + param);

      return template.update(sql, param);
    } catch (Exception e) {
      logger.error("DAO::CustomerDaoImp::addCustomer::error****:: " + e.getMessage());
      logger.error("DAO::CustomerDaoImp::addCustomer::error:: " + e.getStackTrace());

      throw e;
    }

  }

  @Override
  public void updateCustomer(CustomerEntity customerEntity) {

    try {

      String sql = "update customer set notification = :notification where customerid = :customerid";

      SqlParameterSource param = new MapSqlParameterSource().addValue("notification", customerEntity.isNotification())
          .addValue("customerid", customerEntity.getCustomerId());

      logger.debug("DAO::CustomerDao::updateCustomer::sql:: " + sql);
      // logger.debug("DAO::UserDao::updateUser::param:: " +
      // ObjectPrinter.print(param));

      template.update(sql, param);

    } catch (Exception e) {
      logger.error("DAO::CustomerDao::updateCustomer::error:: " + e.getMessage());
      e.printStackTrace();
    }
  }

  @Override
  public List<CustomerEntity> fetchByEmailId(String email) {

    List<CustomerEntity> listOfCustomer = new ArrayList<CustomerEntity>();

    try {

      String sql = "select * from customer where emailid = :emailid";

      SqlParameterSource param = new MapSqlParameterSource().addValue("emailid", email);

      // System.out.println("sql :: " + sql);
      listOfCustomer = template.query(sql, param, new CustomerMapping());

      // System.out.println("listof user :: " + listOfUser);
      logger.debug("DAO::CustomerDaoImp::fetchByEmail::listOfCustomer:: " + listOfCustomer);

      return listOfCustomer;
    } catch (Exception e) {

      throw e;
    }

  }


    
}