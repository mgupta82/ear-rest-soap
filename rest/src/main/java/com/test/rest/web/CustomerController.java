package com.test.rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.rest.model.Address;
import com.test.rest.model.Customer;
import com.test.rest.model.FullName;
import com.test.rest.model.MaritalStatus;
import com.test.rest.model.Sex;
import com.test.rest.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/customer/{customerId}", method=RequestMethod.GET)
	public ResponseEntity<Customer> getEmployee(@PathVariable("customerId") Integer customerId){
		Customer customer = customerService.getCustomer(customerId);
		if(customer == null)
			return new ResponseEntity<>(customer,HttpStatus.NOT_FOUND);;
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@RequestMapping(value="/customer", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		if(customerService.createCustomer(customer))
			return new ResponseEntity<>(customer,HttpStatus.CREATED);
		return new ResponseEntity<>(customer,HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value="/customer/{customerId}", method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<String> updateCustomer(@PathVariable("customerId") Integer customerId,@RequestBody Customer customer){
		customer.setCustomerId(customerId);
		if(customerService.updateCustomer(customer))
			return new ResponseEntity<>("Customer Updated",HttpStatus.OK);
		return new ResponseEntity<>("Failed to update cutomer",HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value="/customer/{customerId}", method=RequestMethod.DELETE)
	public ResponseEntity<String> removeCustomer(@PathVariable("customerId") Integer customerId){
		if(customerService.removeCustomer(customerId))
			return new ResponseEntity<>("Customer Deleted",HttpStatus.OK);
		return new ResponseEntity<>("Failed to delete cutomer",HttpStatus.BAD_REQUEST);
	}	
	
}
