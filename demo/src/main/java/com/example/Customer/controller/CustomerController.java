package com.example.Customer.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.example.Customer.entity.CustomerEntity;
import com.example.Customer.mapping.CustomerMapping;
import com.example.Customer.service.CustomerService;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.PathVariableMapMethodArgumentResolver;

/**
 * CustomerController
 */
@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    @Resource
    CustomerService customerService;

    static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    // get all details
    @GetMapping(value = "/details")
    public List<CustomerEntity> getDetails() {

        List<CustomerEntity> listOfCustomer = customerService.getDetail();
        return listOfCustomer;
    }

    // get details by emailid
    @GetMapping(value = "/getcustomerbyemailid/{parameters}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerEntity> getDetailsByEmailId(@PathVariable String parameters) {
       // System.out.println(parameters);
       // parameters = parameters + ".com";
        System.out.println(parameters);
        List<CustomerEntity> listOfCustomer = customerService.getDetailsByEmailId(parameters);
        return listOfCustomer;

    }

    // get details by customerid
    @GetMapping(value = "/getcustomerbycustomerid/{parameters}")
    public List<CustomerEntity> getDetailsByCustomerId(@PathVariable String parameters) {
       // System.out.println(parameters);
       // parameters = parameters + ".com";
        System.out.println(parameters);
        List<CustomerEntity> listOfCustomer = customerService.getDetailsByCustomerId(parameters);
        return listOfCustomer;

    }

    //get details by emailid using post method
    @PostMapping(value = "/getbyemailid", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerEntity> getByEmailId(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException, IOException {
        // logger.debug("POST:CustomerController:addCustomer::parameters::
        // "+parameters);
        //ObjectMapper mapper = new ObjectMapper();
        //CustomerEntity customerEntity = mapper.readValue(parameters, CustomerEntity.class);
//
        //try {
        //    int result = customerService.addCustomer(customerEntity);
        List<CustomerEntity> listOfCustomer = customerService.getDetailsByEmailId(parameters);
        return listOfCustomer;



        }
    


    // addcustomer
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addCustomer(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException, IOException {
        // logger.debug("POST:CustomerController:addCustomer::parameters::
        // "+parameters);
        ObjectMapper mapper = new ObjectMapper();
        CustomerEntity customerEntity = mapper.readValue(parameters, CustomerEntity.class);

        try {
            int result = customerService.addCustomer(customerEntity);
            if (result == -1)/* 400 */ {
                Map<String, Object> body = new HashMap<String, Object>();

                body.put("message", "Customer already exist");
                body.put("status", HttpStatus.BAD_REQUEST.value());
                System.out.println("customer already exists");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
            } else if (result == 0)// 500
            {
                System.out.println("Exception Occur");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occur");
            } else if (result == 1)// 200
            {
                System.out.println("add success");
                return ResponseEntity.status(HttpStatus.OK).body("Customer added successfully ");

            }

        } catch (Exception e) {
            logger.error("POST:CustomerController:addCustomer::error:: " + e.getStackTrace());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error occured");
        }
        return null;
    }
    /*
     * @RequestMapping(value = "/login", method = RequestMethod.GET) public String
     * login(Model model, String error, String logout) { if (error != null)
     * model.addAttribute("errorMsg", "Your username and password are invalid.");
     * 
     * if (logout != null) model.addAttribute("msg",
     * "You have been logged out successfully.");
     * 
     * return "login"; }
     */
    /*
     * @GetMapping("/index") public String greetingForm(Model model) {
     * model.addAttribute("greeting", new CustomerMapping()); return "greeting"; }
     * 
     * @PostMapping("/index") public String greetingSubmit(@ModelAttribute
     * CustomerEntity customerEntity) { return "result"; }
     */

    /*
     * @PostMapping(path = "/logincustomer/{email}/{psw}") public ResponseEntity<?>
     * loginCustomer(@PathVariable ("email") String email , @PathVariable ("psw")
     * String psw) throws JsonParseException, JsonMappingException, IOException { //
     * logger.debug("POST:CustomerController:addCustomer::parameters::
     */

    @PostMapping(value = "/logincustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> loginCustomer(@RequestBody String parameters)
            throws JsonParseException, JsonMappingException, IOException {
        // logger.debug("POST:CustomerController:addCustomer::parameters::
        // "+parameters);
        ObjectMapper mapper = new ObjectMapper();
        CustomerEntity customerEntity = mapper.readValue(parameters, CustomerEntity.class);
        String email = customerEntity.getEmailId();
        String psw = customerEntity.getPassword();
        // "+parameters);
        try {

            int result = customerService.loginCustomer(email, psw);
            if (result == -1)// 404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer Not Found");
            if (result == 0)// 400
            {
                Map<String, Object> body = new HashMap<String, Object>();

                body.put("message", "Invalid Password");
                body.put("status", HttpStatus.BAD_REQUEST.value());

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
            }

            if (result == 1)// 200
                return ResponseEntity.status(HttpStatus.OK).body("Valid Customer");
            if (result == -2)// 500
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occur");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occur");
        }
        return null;

    }

}
