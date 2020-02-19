package com.example.Hotel.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.example.Hotel.entity.HotelEntity;
import com.example.Hotel.service.HotelService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.sjavac.Log;

//import org.apache.tomcat.util.http.parser.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HotelController
 */
@RestController
@RequestMapping(path = "/hotel")

public class HotelController {

    @Resource
    HotelService hotelService;

    static final Logger logger = LoggerFactory.getLogger(HotelController.class);

    // get the hotel details by name
    @GetMapping(value = "/getdetail/{parameters}")
    public List<HotelEntity> getDetailByName(@PathVariable String parameters)
            throws JsonParseException, JsonMappingException, IOException {

        List<HotelEntity> listOfHotel = hotelService.getDetailByName(parameters);
        return listOfHotel;
    }

    // get count of hotel
    @GetMapping(value = "/gethoteldetails")
    public int getDetails() {

        List<HotelEntity> listOfHotel = hotelService.getDetails();
        return listOfHotel.size();
    }

    // get all details hotel
    @GetMapping(value = "/gethoteldetail")
    public List<HotelEntity> getDetail() {

        List<HotelEntity> listOfHotel = hotelService.getDetails();
        return listOfHotel;
    }


    // get all details of hotel by hotelId
    @GetMapping(value = "/getdetailsbyhotelid/{parameters}")
    public List<HotelEntity> getDetailsByHotelId(@PathVariable String parameters) {

        List<HotelEntity> listOfHotel = hotelService.getDetailsByHotelId(parameters);
        return listOfHotel;
    }

    // get all details of hotel by hotelemailid by post
    @PostMapping(value = "/getdetailsbyemailid", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotelEntity> getDetailsByHotelEmailId(@RequestBody String parameters)
            throws JsonMappingException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        HotelEntity hotelEntity = mapper.readValue(parameters, HotelEntity.class);

        List<HotelEntity> listOfHotel = hotelService.getDetailsByHotelEmailId(hotelEntity.getHotelEmailId());
        return listOfHotel;
    }

    // by facility
    @GetMapping(value = "/gethoteldetailbyhotelfacility/{parameters}")
    public List<HotelEntity> getDetailsByHotelFacility(@PathVariable String parameters) {

        // System.out.println(parameters);
        int id = Integer.parseInt(parameters);
        List<HotelEntity> listOfHotel = hotelService.getDetailsByHotelFacility(id);
        return listOfHotel;
    }

    // by cuisine
    @GetMapping(value = "/gethoteldetailbyhotelcuisine/{parameters}")
    public List<HotelEntity> getDetailsByHotelCuisine(@PathVariable String parameters) {

        // System.out.println(parameters);
        int id = Integer.parseInt(parameters);
        List<HotelEntity> listOfHotel = hotelService.getDetailsByHotelCuisine(id);
        return listOfHotel;
    }

    // bymenutype veg or nonveg or both
    @GetMapping(value = "/gethoteldetailbyhotelmenutype/{parameters}")
    public List<HotelEntity> getDetailsByHotelMenuType(@PathVariable String parameters) {
        List<HotelEntity> listOfHotel = hotelService.getDetailsByHotelMenuType(parameters);
        return listOfHotel;

    }

    // by express Delivery
    @GetMapping(value = "/gethoteldetailbyexpressdelivery")
    public List<HotelEntity> getDetailsByExpressDelivery() {
        List<HotelEntity> listOfHotel = hotelService.getDetailsByExpressDelivery();
        return listOfHotel;

    }

    // nearby
    @GetMapping(value = "/gethoteldetailbynearby/{parameters}")
    public List<HotelEntity> getDetailsByNearBy(@PathVariable String parameters) {
        List<HotelEntity> listOfHotel = hotelService.getDetailsByNearBy(parameters);
        return listOfHotel;

    }

    // addhotel
    @PostMapping(value = "/addhotel" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addHotel(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException, IOException {
        // logger.debug("POST:HotelController:addHotel::parameters:: "+parameters);
        ObjectMapper mapper = new ObjectMapper();
        HotelEntity hotelEntity = mapper.readValue(parameters, HotelEntity.class);

        System.out.println("hotel in controller ::" + hotelEntity);

        try {
            int result = hotelService.addHotel(hotelEntity);
            if (result == -1) // 400
            {
                Map<String, Object> body = new HashMap<String, Object>();

                body.put("message", "Restaurent already exist already exist");
                body.put("status", HttpStatus.BAD_REQUEST.value());

                System.out.println("this emailid already exist for another hotel");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
            }

            else if (result == 0)// 500
            {
                System.out.println("error occured");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occur");
            } else if (result == 1)// 200
            {
                System.out.println("hotel added successfully");
                return ResponseEntity.status(HttpStatus.OK).body("hotel added successfully ");
            }

        }

        catch (Exception e) {
            logger.error("POST:HotelController:addHotel::error:: " + e.getStackTrace());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error occured");
        }
        return null;
    }

    /*
     * 
     * function for images
     */
    /*
     * @RequestMapping(value = "/image") public ResponseEntity<?>
     * setImage(@RequestBody String parameters) throws
     * JsonParseException,JsonMappingException,IOException {
     * 
     * ObjectMapper mapper= new ObjectMapper(); HotelEntity hotelEntity =
     * mapper.readValue(parameters, HotelEntity.class); hotelEntity.setImage();
     * 
     * 
     * }
     */

    @PostMapping(value = "/loginhotel")
    public ResponseEntity<?> loginHotel(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        HotelEntity hotelEntity = mapper.readValue(parameters, HotelEntity.class);
        String email = hotelEntity.getHotelEmailId();
        String psw = hotelEntity.getHotelPassword();
        // "+parameters);
        try {

            int result = hotelService.loginHotel(email, psw);
            if (result == -1)// 404
            {
                System.out.println("restaurent not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel Not Found");
            }
            if (result == 0)// 400
            {
                Map<String, Object> body = new HashMap<String, Object>();

                body.put("message", "Invalid password");
                body.put("status", HttpStatus.BAD_REQUEST.value());

                System.out.println("Invalid Password");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
            }

            if (result == 1)// 200
            {
                System.out.println("valid user");
                return ResponseEntity.status(HttpStatus.OK).body("Valid User");
            }
            if (result == -2)// 500
            {
                System.out.println("Exception Occure");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occur");
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occur");
        }
        return null;

    }
}
