package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody Customer customer){
        Customer user = customerService.addCustomer(customer);
        return "CustomerId: "+user.getCustomerId()+"\n Password: " +user.getCustomerPassword();
    }

    @GetMapping("/getCustomer")
    public List<Customer> getCustomers(){
        return customerService.getAllCustomer();
    }

}
