package com.example.Food_Order.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import com.example.Food_Order.entity.FoodOrderEntity;
import com.example.Food_Order.service.FoodOrderService;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FoodOrderController
 */

@RestController
@RequestMapping(path = "/foodorder")
public class FoodOrderController {

    @Resource
    FoodOrderService foodOrderService;

    // get all details of foodorder by orderid
    @GetMapping(value = "/getdetailsbyorderid/{parameters}")
    public List<FoodOrderEntity> getDetailsByOrderId(@PathVariable String parameters) throws ParseException {

        List<FoodOrderEntity> listOfFoodOrderEntities = foodOrderService.getDetailsByOrderId(parameters);
        return listOfFoodOrderEntities;
    }



    @PostMapping(value = "/addfoodorder")
    public ResponseEntity<?> addFoodOrder(@RequestBody String parameter)
            throws JsonParseException, JsonMappingException, IOException {
        // logger.debug("POST:CustomerController:addCustomer::parameters::
        // "+parameters);
        /*
         * String str1=objectNode.get("str1").asText(); String
         * str2=objectNode.get("str2").asText();
         */

        ObjectMapper mapper = new ObjectMapper();
        FoodOrderEntity foodOrderEntity = mapper.readValue(parameter, FoodOrderEntity.class);

        try {
            int result = foodOrderService.addFoodOrder(foodOrderEntity);
            if (result == 0)// 500
            {
                System.out.println("Exception Occur");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occur");
            } else if (result == 1)// 200
            {
                System.out.println("foodorder success");
                return ResponseEntity.status(HttpStatus.OK).body("FoodOrder added successfully ");

            }

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error occured");
        }
        return null;
    }


    @GetMapping(value="/deletefoodorder/{oid}")
    public ResponseEntity<?> deleteFoodOrder(@PathVariable String oid) throws ParseException {

        int returnVal=foodOrderService.deleteFoodOrder(oid);
        if(returnVal >= 1)/*200*/
        {
            System.out.println("deleted foodorder success"+returnVal);
                return ResponseEntity.status(HttpStatus.OK).body("foodOrder deleted successfully ");

        }
        else if (returnVal == 0)// 500
            {
                System.out.println("foodorder is not deleted");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
            }
            return null;
    }




    
}