package com.example.Customer.service;

import java.util.List;

import javax.annotation.Resource;

import com.example.Customer.dao.CustomerDao;
import com.example.Customer.entity.CustomerEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.crypto.bcrypt.BCrypt;
//import java.lang.Object.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;;

/**
 * CustomerServiceImpl
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    @Resource CustomerDao customerDao;

    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    
    @Override
    public List<CustomerEntity> getDetail() {


        
        List<CustomerEntity> listOfCustomer=customerDao.getDetail();
        return listOfCustomer;
    }
    public int checkDuplicationOfEmail(CustomerEntity customerEntity) {

        try{
        //String email = user.getEmail();
          List<CustomerEntity> listOfUser = customerDao.checkDuplicationOfEmail(customerEntity);
          if(listOfUser.size() > 0) {
    
            System.out.println("this email already exist:: " + customerEntity.getEmailId());
            return 1;
            //return ResponseEntity.status(HttpStatus.OK).body("Customer Already Exits");
          }
        }
        catch(Exception e) {
    
          logger.error("SERVICE::CustomerServiceImpl::addCustomer::checkDuplicationForEmail::error:: " + e.getMessage());
        }
          return 0;
        
      }
      public int addCustomer(CustomerEntity customerEntity) {
    
        
        int resultOfDuplication = checkDuplicationOfEmail(customerEntity);
    
        if(resultOfDuplication == 0) {
          String password = customerEntity.getPassword();
        
          try {
          
            String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            logger.debug("SERVICE::CustomerServiceImp::addCustomer::encryptedPassword:: " + encryptedPassword);
          
            customerEntity.setPassword(encryptedPassword);
            int addCustomerResponse = customerDao.addCustomer(customerEntity);
    
            if(addCustomerResponse > 0) {
           //   Future<Integer> response = sendGreetingEmail(customerEntity.getName(), customerEntity.getEmailId());
             logger.debug("SERVICE::UserServiceImp::addUser::response:: " + addCustomerResponse); 
            }
            else {
    
            logger.debug("SERVICE::CustomerServiceImp::addCustomer::Customer not get added");
            return -1; 
            }
    
          return 1;
        }
        catch(Exception e) {
    
          logger.error("SERVICE::CustomerServiceImp::addCustomer::error:: " + e.getMessage());
          return 0;
        }
      }
        else 
          return -1;
      }
    
    
}