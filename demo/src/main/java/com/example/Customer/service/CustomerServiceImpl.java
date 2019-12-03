package com.example.Customer.service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import com.example.Customer.dao.CustomerDao;
import com.example.Customer.entity.CustomerEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.crypto.bcrypt.BCrypt;
//import java.lang.Object.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;;

/**
 * CustomerServiceImpl
 */
@Service
public class CustomerServiceImpl implements CustomerService{


  @Autowired
  private JavaMailSender JavaMailSender;
    @Resource CustomerDao customerDao;

    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private ExecutorService executor = Executors.newSingleThreadExecutor();
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
              Future<Integer> response = sendGreetingEmail(customerEntity.getName(), customerEntity.getEmailId());
             logger.debug("SERVICE::UserServiceImp::addUser::response:: " + addCustomerResponse); 
            }
            else {
    
            logger.debug("SERVICE::CustomerServiceImp::addCustomer::Customer not get added");
             
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
      public Future<Integer> sendGreetingEmail(String name, String email) {
   
        try {
          return executor.submit(() -> {
    
            String message = String.format("<html>Hi <b>%s</b>,", name);
            message += "<br>&nbsp;&nbsp;Thanks for signing up for ChatApp. We are very excited to have you.";
            message += "<br><br><br> Thanks, <br> ChatApp Team.</html>";
    
            logger.debug("SERVICE::UserServiceImp::sendGreetingEmail::message:: " + message);
    
            MimeMessage mimeMessage = JavaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            
            helper.setTo(email);
            helper.setSubject("Sign Up");     
            helper.setText(message, true);
    
            try {
              JavaMailSender.send(mimeMessage);	  
            } catch (Exception e) {
              System.out.println(">>>>>>>>>>>>> ERRROR " +e);
            }
            
            logger.debug("SERVICE::UserServiceImp::sendGreetingEmail::sendMessage Successfully");
    
            // Fetch user by emailId
            List<CustomerEntity> listOfUser = customerDao.fetchByEmailId(email);
            CustomerEntity customerEntity = listOfUser.get(0);
    
            String customerUUID = customerEntity.getCustomerid();
    
           // customerEntity.setNotification(true);
            customerEntity.setCustomerid(customerUUID);
           // customerDao.updateUser(customerEntity);
    
            return 1;
          });
    
        } catch (Exception e) {
          
          logger.error("SERVICE::UserServiceImp::sendGreetingEmail::error:: " + e.getMessage());
          e.printStackTrace();
    
          return executor.submit(() -> {
            return 0;
          });
        }
      }
    
    
}