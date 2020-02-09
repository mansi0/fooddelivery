package com.example.Order.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import com.example.Order.entity.OrderEntity;
import com.example.Order.service.OrderService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderController
 */
@RestController
@RequestMapping(path = "/order")

public class OrderController {
    @Resource
    OrderService orderService;

    // get details by hours min sec
    @GetMapping(value = "/getorderbytime/{hrs}/{min}/{date}")
    public List<OrderEntity> getDetailsByTime(@PathVariable String hrs, @PathVariable String min,
            @PathVariable String date) throws ParseException {

        int h = Integer.parseInt(hrs);
        int m = Integer.parseInt(min);

        List<OrderEntity> listOfOrderEntities = orderService.getDetailsByTime(h, m, date);
        // System.out.println("*****"+listOfCustomer);
        return listOfOrderEntities;

    }

    @GetMapping(value="/deleteorder/{oid}")
    public ResponseEntity<?> deleteOrder(@PathVariable String oid) throws ParseException,
    HttpRequestMethodNotSupportedException{

        int returnVal=orderService.deleteOrder(oid);
        if(returnVal == 1)/*200*/
        {
            System.out.println("deleted order success");
                return ResponseEntity.status(HttpStatus.OK).body("Order deleted successfully ");

        }
        else if (returnVal == 0)// 500
            {
                System.out.println("order is not deleted");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
            }
            return null;
    }

    @PostMapping(value = "/addorder")
    public ResponseEntity<?> addOrder(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException, IOException {
        // logger.debug("POST:CustomerController:addCustomer::parameters::
        // "+parameters);
        ObjectMapper mapper = new ObjectMapper();
        OrderEntity orderEntity = mapper.readValue(parameters, OrderEntity.class);

        try {
            int result = orderService.addOrder(orderEntity);
            if (result == 1)/* 200 */ {
                System.out.println("added order success");
                return ResponseEntity.status(HttpStatus.OK).body("Order added successfully ");
            } else if (result == 0)// 500
            {
                System.out.println("error occured");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
            }
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("internal server error");
        }
        return null;
    }


//update order by total value
    @PostMapping(value = "/updateorderbytotal")
    public ResponseEntity<?> updateOrder(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException, IOException {
        // logger.debug("POST:CustomerController:addCustomer::parameters::
        // "+parameters);
        ObjectMapper mapper = new ObjectMapper();
        OrderEntity orderEntity = mapper.readValue(parameters, OrderEntity.class);

        try {
            int result = orderService.updateOrderByTotal(orderEntity);
            if (result == 1)/* 200 */ {
                System.out.println("updated order for total");
                return ResponseEntity.status(HttpStatus.OK).body("Order added successfully ");
            } else if (result == 0)// 500
            {
                System.out.println("order is not updated for total");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
            }
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("internal server error");
        }
        return null;
    }

    //update order by status
    @PostMapping(value = "/updateorderbystatus")
    public ResponseEntity<?> updateOrderByStatus(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException, IOException {
        // logger.debug("POST:CustomerController:addCustomer::parameters::
        // "+parameters);
        ObjectMapper mapper = new ObjectMapper();
        OrderEntity orderEntity = mapper.readValue(parameters, OrderEntity.class);

        try {
            int result = orderService.updateOrderByStatus(orderEntity);
            if (result == 1)/* 200 */ {
                System.out.println("updated order for status");
                return ResponseEntity.status(HttpStatus.OK).body("Order added successfully ");
            } else if (result == 0)// 500
            {
                System.out.println("order is not updated for status");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
            }
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("internal server error");
        }
        return null;
    }

}
