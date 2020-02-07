package com.example.Hotel_Order.controller;

import java.io.IOException;

import javax.annotation.Resource;

import com.example.Hotel_Order.entity.HotelOrderEntity;
import com.example.Hotel_Order.service.HotelOrderService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HotelOrderController
 */
@RestController
@RequestMapping(path = "/hotelorder")

public class HotelOrderController {

    @Resource
    HotelOrderService hotelOrderService;



    @PostMapping(value = "/addhotelorder")
    public ResponseEntity<?> addHotelFood(@RequestBody String parameter)
            throws JsonParseException, JsonMappingException, IOException {
        // logger.debug("POST:CustomerController:addCustomer::parameters::
        // "+parameters);
        /*
         * String str1=objectNode.get("str1").asText(); String
         * str2=objectNode.get("str2").asText();
         */

        ObjectMapper mapper = new ObjectMapper();
        HotelOrderEntity hotelOrderEntity = mapper.readValue(parameter, HotelOrderEntity.class);

        try {
            int result = hotelOrderService.addHotelOrder(hotelOrderEntity);
            if (result == 0)// 500
            {
                System.out.println("Exception Occur in hotelorder");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occur");
            } else if (result == 1)// 200
            {
                System.out.println("hotelorder success");
                return ResponseEntity.status(HttpStatus.OK).body("HotelOrder added successfully ");

            }

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error occured");
        }
        return null;
    }

}