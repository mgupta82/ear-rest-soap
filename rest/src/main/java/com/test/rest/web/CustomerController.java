package com.test.rest.web;

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

@Controller
public class CustomerController {
	
	@RequestMapping(value="/customer/{customerId}", method=RequestMethod.GET)
	public @ResponseBody Customer getEmployee(@PathVariable("customerId") Integer customerId){
		Address address = new Address();
		address.setStreetNumber(708);
		address.setStreetName("19 Hanover Street");
		address.setSuburb("oakleigh");
		address.setCity("Melbourne");
		address.setState("Victoria");
		address.setPincode(3166);
		address.setCountry("Australia");
		FullName fullName = new FullName();
		fullName.setFirstName("Mukesh");
		fullName.setMiddleName("Shital");
		fullName.setSurName("Gupta");
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setFullName(fullName);
		customer.setResidenceAddress(address);
		customer.setInitials("S");
		customer.setTitle("Mr.");
		customer.setSex(Sex.MALE);
		customer.setMaritalStatus(MaritalStatus.NEVER_MARRIED);
		customer.setCreditRating(80);
		customer.setNabCustomer(true);
		return customer;
	}
	
	@RequestMapping(value="/customer", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		customer.setCustomerId(123);
		return new ResponseEntity<>(customer,HttpStatus.CREATED);
	}

	@RequestMapping(value="/customer/{customerId}", method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<String> updateCustomer(@PathVariable("customerId") Integer customerId,@RequestBody Customer customer){
		return new ResponseEntity<>("Customer Updated",HttpStatus.OK);
	}

	
}
