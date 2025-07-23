package com.oracle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.model.Customer;
import com.oracle.service.CustomerService;

@RestController

public class CustomerRestController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping("/addCustomer")
	public void addCustomer(@RequestBody Customer cust) {
		service.addCustomer(cust);
	}
	
	// GET: Find customer by email
    @GetMapping("/getCustomerByEmail")
    
    public Customer getCustomerByEmail(@RequestParam String email) { 
    	//-- the @RequestParam is a annotation which takes the parameter from the HPPT request
    	// and use it as a 
        return service.findCustomerByEmail(email);
    }

    // GET: Fetch all customers
    @GetMapping("/getAll")
    public List<Customer> getAllCustomers() {
        return service.findAllCustomers();
    }
    
    // PUT: Update existing customer
    @PutMapping("/updateCustomer")
    public void updateCustomer(@RequestBody Customer cust) {
        service.updateCustomer(cust);
    }

    // DELETE: Delete customer by email
    @DeleteMapping("/deleteCustomer")
    public void deleteCustomerByEmail(@RequestParam String email) {
        service.deleteCustomerByEmail(email);
    }
}
