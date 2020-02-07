package com.example.Hotel.service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import com.example.Food.entity.FoodEntity;
import com.example.Hotel.dao.HotelDao;
import com.example.Hotel.entity.HotelEntity;

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
 * HotelServiceImpl
 */
@Service
public class HotelServiceImpl implements HotelService {

  @Autowired
  private JavaMailSender JavaMailSender;

  @Resource
  HotelDao hotelDao;

  Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);
  private ExecutorService executor = Executors.newSingleThreadExecutor();

  @Override
  public List<HotelEntity> getDetailByName(String hotelName) {
    List<HotelEntity> listOfHotel = hotelDao.getDetailByName(hotelName);
    return listOfHotel;
  }

  @Override
  public List<HotelEntity> getDetails() {
    List<HotelEntity> listOfHotel = hotelDao.getDetails();
    return listOfHotel;
  }

  @Override
  public List<HotelEntity> getDetailsByHotelId(String hotelId) {
    List<HotelEntity> listOfHotel = hotelDao.getDetailsByHotelId(hotelId);
    return listOfHotel;
  }

  @Override
  public List<HotelEntity> getDetailsByHotelEmailId(String hotelEmailId) {
  List<HotelEntity> listOfHotel = hotelDao.getDetailsByHotelEmailId(hotelEmailId);
    return listOfHotel;
  }


  @Override
  public List<HotelEntity> getDetailsByHotelFacility(int index) {
    List<HotelEntity> listOfHotel = hotelDao.getDetailsByHotelFacility(index);
    return listOfHotel;
  }

  @Override
  public List<HotelEntity> getDetailsByHotelCuisine(int index) {
    List<HotelEntity> listOfHotel = hotelDao.getDetailsByHotelFacility(index);
    return listOfHotel;
  }

  @Override
  public List<HotelEntity> getDetailsByHotelMenuType(String type) {
    List<HotelEntity> listOfHotel = hotelDao.getDetailsByHotelMenuType(type);
    return listOfHotel;
  }

  @Override
  public List<HotelEntity> getDetailsByNearBy(String locality) {
    List<HotelEntity> listOfHotel = hotelDao.getDetailsByNearBy(locality);
    return listOfHotel;
  
  }

  public int checkDuplicationOfEmail(HotelEntity hotelEntity) {

    try {
      // String email = user.getEmail();
      List<HotelEntity> listOfHotel = hotelDao.checkDuplicationOfEmail(hotelEntity);

      if (listOfHotel.size() > 0) {

        System.out.println("this email already exist:: " + hotelEntity.getHotelEmailId());
        return 1;
        // return ResponseEntity.status(HttpStatus.OK).body("hotel Already Exits");
      }
    }

    catch (Exception e) {

      logger.error("SERVICE::HotelServiceImpl::addHotel::checkDuplicationForEmail::error:: " + e.getMessage());
    }
    return 0;

  }

  public int addHotel(HotelEntity hotelEntity) {

    int resultOfDuplication = checkDuplicationOfEmail(hotelEntity);

    if (resultOfDuplication == 0) {
      String password = hotelEntity.getHotelPassword();

      try {

        String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        logger.debug("SERVICE::HotelServiceImp::addHotel::encryptedPassword:: " + encryptedPassword);

        hotelEntity.setHotelPassword(encryptedPassword);
        int addHotelResponse = hotelDao.addHotel(hotelEntity);

        if (addHotelResponse > 0) {
          Future<Integer> response = sendGreetingEmail(hotelEntity.getHotelName(), hotelEntity.getHotelEmailId());
          logger.debug("SERVICE::UserServiceImp::addUser::response:: " + addHotelResponse);
        } else {

          logger.debug("SERVICE::HotelServiceImp::addHotel::Hotel not get added");

        }

        return 1;
      }

      catch (Exception e) {

        logger.error("SERVICE::HotelServiceImp::addHotel::error:: " + e.getMessage());
        return 0;
      }
    } else
      return -1;
  }

  public Future<Integer> sendGreetingEmail(String name, String email) {

    try {
      return executor.submit(() -> {

        String message = String.format("<html>Hi <b>%s</b>,", name);

        message += "<br>&nbsp;&nbsp;Welcome in Taste on way system,thanx for coming with our buiseness,Our partnership will create a global food network.";
        message += "<br>&nbsp;&nbsp;    Your feedback and loyalty will go a long way to help us make you proud of us.";
        message += "<br><br><br> Thanks, <br> Taste on Way Team.</html>";

        logger.debug("SERVICE::UserServiceImp::sendGreetingEmail::message:: " + message);

        MimeMessage mimeMessage = JavaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        helper.setTo(email);
        helper.setSubject("Sign Up");
        helper.setText(message, true);

        try {
          JavaMailSender.send(mimeMessage);
        }

        catch (Exception e) {
          System.out.println(">>>>>>>>>>>>> ERRROR " + e);
        }

        logger.debug("SERVICE::UserServiceImp::sendGreetingEmail::sendMessage Successfully");

        // Fetch user by emailId
        List<HotelEntity> listOfUser = hotelDao.fetchByEmailId(email);
        HotelEntity hotelEntity = listOfUser.get(0);

        String hotelUUID = hotelEntity.getHotelId();

        hotelEntity.setNotification(true);
        hotelEntity.setHotelId(hotelUUID);
        hotelDao.updateHotel(hotelEntity);

        return 1;
      });

    }

    catch (Exception e) {

      logger.error("SERVICE::UserServiceImp::sendGreetingEmail::error:: " + e.getMessage());
      e.printStackTrace();

      return executor.submit(() -> {
        return 0;
      });
    }
  }

  @Override
  public int loginHotel(String email, String psw) {

    try {

      List<HotelEntity> listOfHotelEntities = hotelDao.fetchByEmailId(email);
      if (listOfHotelEntities.size() == 0)
        return -1;
      else if (listOfHotelEntities.size() > 0) {

        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity = listOfHotelEntities.get(0);

        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        boolean isPasswordMatches = bCrypt.matches(psw, hotelEntity.getHotelPassword());
        System.out.println("value :" + isPasswordMatches);

        if (isPasswordMatches) {
          return 1;
        } else
          return 0;

      }
    } catch (Exception e) {
      return -2;
    }
    return -2;
  }

}