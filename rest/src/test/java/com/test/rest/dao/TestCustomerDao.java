package com.test.rest.dao;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.rest.model.Customer;
import com.test.rest.service.CustomerService;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("spring-servlet.xml")
public class TestCustomerDao {
	
	@Autowired
	private CustomerService customerService;

	@Test
	public void testGetCustomer(){
		Customer customer = customerService.getCustomer(new Integer(1));
		assertEquals(customer.getFullName().getFirstName(), "Mukesh");
	}
}
