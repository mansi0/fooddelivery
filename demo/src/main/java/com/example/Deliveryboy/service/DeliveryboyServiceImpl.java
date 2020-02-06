package com.example.Deliveryboy.service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import com.example.Deliveryboy.dao.DeliveryboyDao;
import com.example.Deliveryboy.entity.DeliveryboyEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import java.lang.Object.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;;

/**
 * DeliveryboyServiceImpl
 */
@Service
public class DeliveryboyServiceImpl implements DeliveryboyService {

  @Autowired
  private JavaMailSender JavaMailSender;
  @Resource
  DeliveryboyDao deliveryboyDao;

  Logger logger = LoggerFactory.getLogger(DeliveryboyServiceImpl.class);
  private ExecutorService executor = Executors.newSingleThreadExecutor();

  @Override
  public List<DeliveryboyEntity> getDetail() {

    List<DeliveryboyEntity> listOfDeliveryboy = deliveryboyDao.getDetail();
    return listOfDeliveryboy;
  }


  @Override
  public List<DeliveryboyEntity> getDetailsByEmailId(String emailId) {
    List<DeliveryboyEntity> listOfDeliveryboy = deliveryboyDao.getDetailsByEmailId(emailId);
    return listOfDeliveryboy;
  
  }

  @Override
  public List<DeliveryboyEntity> getDetailsByDeliveryboyId(String deliveryboyId) {
    List<DeliveryboyEntity> listOfDeliveryboy = deliveryboyDao.getDetailsByEmailId(deliveryboyId);
    return listOfDeliveryboy;
  
  }


  public int checkDuplicationOfEmail(DeliveryboyEntity deliveryboyEntity) {

    try {
      // String email = user.getEmail();
      List<DeliveryboyEntity> listOfDeliveryboy = deliveryboyDao.checkDuplicationOfEmail(deliveryboyEntity);
      System.out.println(listOfDeliveryboy.size());
      if (listOfDeliveryboy.size() > 0) {

        System.out.println("this email already exist:: " + deliveryboyEntity.getDeliveryboyEmailId());
        return 1;
        // return ResponseEntity.status(HttpStatus.OK).body("delivery boy Already
        // Exits");
      }
    } catch (Exception e) {

      logger.error(
          "SERVICE::DeliveryboyServiceImpl::addDeliveryboy::checkDuplicationForEmail::error:: " + e.getMessage());
    }
    return 0;

  }

  public int addDeliveryboy(DeliveryboyEntity deliveryboyEntity) {

    int resultOfDuplication = checkDuplicationOfEmail(deliveryboyEntity);
    System.out.println(resultOfDuplication);

    if (resultOfDuplication == 0) {
      String password = deliveryboyEntity.getDeliveryboyPassword();

      try {

        String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        logger.debug("SERVICE::DeliveryboyServiceImp::addDeliveryboy::encryptedPassword:: " + encryptedPassword);

        deliveryboyEntity.setDeliveryboyPassword(encryptedPassword);
        int addDeliveryboyResponse = deliveryboyDao.addDeliveryboy(deliveryboyEntity);

        if (addDeliveryboyResponse > 0) {
          Future<Integer> response = sendGreetingEmail(deliveryboyEntity.getDeliveryboyName(),
              deliveryboyEntity.getDeliveryboyEmailId());
          logger.debug("SERVICE::UserServiceImp::addUser::response:: " + addDeliveryboyResponse);
          return 1;
        }
         else {

          logger.debug("SERVICE::DeliveryboyServiceImp::addDeliveryboy::Delivery boy not get added");
          return 0;

        }

        
      } catch (Exception e) {

        logger.error("SERVICE::DeliveryboyServiceImp::addDeliveryboy::error:: " + e.getMessage());
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
        message += "<br>&nbsp;&nbsp;Welcome in Taste On Way journey,Thanx for joining our buiseness. We also feel pround to work with you.Your loyalty and sincerity will go a long way to help us make you proud of us.";
        message += "<br><br><br> Thanks, <br> Taste On Way Team.</html>";

        logger.debug("SERVICE::UserServiceImp::sendGreetingEmail::message:: " + message);

        MimeMessage mimeMessage = JavaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

                
        helper.setTo(email);
        
        helper.setSubject("Work with Taste On Way");
        
        helper.setText(message, true);
        
        try {

          JavaMailSender.send(mimeMessage);
        } 
        catch (Exception e) {
          
          return 0;
        }

        logger.debug("SERVICE::UserServiceImp::sendGreetingEmail::sendMessage Successfully");

        // Fetch user by emailId
        List<DeliveryboyEntity> listOfUser = deliveryboyDao.fetchByEmailId(email);
        DeliveryboyEntity deliveryboyEntity = listOfUser.get(0);

        String deliveryboyUUID = deliveryboyEntity.getDeliveryboyId();

        deliveryboyEntity.setNotification(true);
        deliveryboyEntity.setDeliveryboyId(deliveryboyUUID);
        deliveryboyDao.updateDeliveryboy(deliveryboyEntity);

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

  @Override
      public int loginDeliveryboy(String email, String psw) {

        try {

         List<DeliveryboyEntity> listOfDeliveryboy = deliveryboyDao.fetchByEmailId(email);
          if(listOfDeliveryboy.size() == 0) 
             return -1;
          else if(listOfDeliveryboy.size()>0) {

           DeliveryboyEntity deliveryboyEntity=new DeliveryboyEntity();
           deliveryboyEntity=listOfDeliveryboy.get(0);

            BCryptPasswordEncoder bCrypt =new BCryptPasswordEncoder();
            boolean isPasswordMatches = bCrypt.matches(psw, deliveryboyEntity.getDeliveryboyPassword());
            System.out.println("value :"+ isPasswordMatches);

           if(isPasswordMatches) {
                return 1;
           }
           else return 0;

        }
      }
      catch(Exception e) {
        return -2;
      }
      return -2;
    }


}