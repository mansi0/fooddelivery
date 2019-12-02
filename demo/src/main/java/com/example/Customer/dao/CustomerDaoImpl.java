package com.example.Customer.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.Customer.entity.CustomerEntity;
import com.example.Customer.mapping.CustomerMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        this.template=template;

    }

    @Override
    public List<CustomerEntity> getDetail() {

        String sql="select * from Customer";
        List<CustomerEntity> listOfCustomer=template.query(sql,new CustomerMapping());

        return listOfCustomer;
    } 
    @Override
     public List<CustomerEntity> checkDuplicationOfEmail(CustomerEntity customerEntity) {

    List<CustomerEntity> listOfCustomer = new ArrayList<CustomerEntity>();
    
    try {

      String sql = "select customerId from customer where emailId = :emailId";
      SqlParameterSource param = new MapSqlParameterSource()
        .addValue("emailId", customerEntity.getEmailId());
      
      listOfCustomer = template.query(sql, param, new CustomerMapping());
      logger.debug("DAO::CustomerDaoImp::getDetail::listOfCustomer::listOfCustomer:: " + listOfCustomer);
      
      return listOfCustomer;
    }
    catch(Exception e) {

        logger.error("DAO::CustomerDaoImp::checkDuplicateEmail::error:: " + e.getStackTrace());
      throw e;
    }
  }
  /**
   * function addUser
   * @param user
   * @return void
   * @throws Exception
   */
  @Override
  public int addCustomer(CustomerEntity customerEntity) {

    UUID uuid = UUID.randomUUID();
   // long epoch = System.currentTimeMillis()/1000;

    try {

      String sql = "insert into customer values(:customerid,:name,:address,:locality,:landmark,:city,:state,:accounttype,:emailid,:contno,:password,:accountdate)";
      logger.debug("DAO::CustomerDaoImp::addCustomer::sql:: " + sql);
      SqlParameterSource param = new MapSqlParameterSource()
        .addValue("customerid", uuid.toString())
        .addValue("name", customerEntity.getName())
        .addValue("address", customerEntity.getAddress())
        .addValue("locality", customerEntity.getLocality())
        .addValue("landmark", customerEntity.getLandmark())
        .addValue("city", customerEntity.getCity())
        .addValue("state", customerEntity.getState())
        .addValue("accounttype", customerEntity.getAccountType())
        .addValue("emailid", customerEntity.getEmailId())

        .addValue("contno", customerEntity.getContNo())
        .addValue("password", customerEntity.getPassword())
        .addValue("accountdate", customerEntity.getAccountDate());

       
          
        logger.debug("DAO::CustomerDaoImp::addCustomer::param:: " + param);

    
      return template.update(sql, param);
    }
    catch(Exception e) {
      logger.error("DAO::CustomerDaoImp::addCustomer::error****:: " + e.getMessage());
      logger.error("DAO::CustomerDaoImp::addCustomer::error:: " + e.getStackTrace());
      
      throw e;
    }

  }

    
}