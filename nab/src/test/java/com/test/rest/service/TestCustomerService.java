package com.test.rest.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.rest.model.Address;
import com.test.rest.model.Customer;
import com.test.rest.model.FullName;
import com.test.rest.model.MaritalStatus;
import com.test.rest.model.Sex;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-servlet.xml")
public class TestCustomerService {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Integer getMaxCustomerId(){
		return jdbcTemplate.queryForObject("select max(CUSTOMER_ID) from customer", Integer.class);
	}
	
	@Test
	public void testCreateCustomer(){
		Customer customer = new Customer();
		FullName fullName = new FullName();
		fullName.setFirstName("test");
		fullName.setMiddleName("test");
		fullName.setSurName("test");
		customer.setFullName(fullName);
		customer.setCreditRating(80);
		customer.setInitials("S");
		customer.setMaritalStatus(MaritalStatus.valueOf("MARRIED"));
		customer.setNabCustomer(true);
		Address address = new Address();
		address.setStreetNumber(12);
		address.setStreetName("test");
		address.setSuburb("test");
		address.setCity("test");
		address.setState("test");
		address.setPincode(3166);
		address.setCountry("test");
		customer.setResidenceAddress(address);
		customer.setSex(Sex.valueOf("MALE"));
		customer.setTitle("Mr");
		assert(customerService.createCustomer(customer));
	}	

	@Test
	public void testGetCustomer(){
		Customer customer = customerService.getCustomer(getMaxCustomerId());
		assertEquals(customer.getFullName().getSurName(), "test");
	}
	
	@Test
	public void testUpdateCustomer(){
		Customer customer = customerService.getCustomer(getMaxCustomerId());
		customer.getFullName().setFirstName("test1");
		assert(customerService.updateCustomer(customer));
	}	
	
	@Test
	public void testDeleteCustomer(){
		assert(customerService.removeCustomer(getMaxCustomerId()));
	}		
	
	
}
