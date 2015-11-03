package com.test.rest.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.test.rest.model.Address;
import com.test.rest.model.Customer;
import com.test.rest.model.FullName;
import com.test.rest.model.MaritalStatus;
import com.test.rest.model.Sex;
import com.test.rest.service.CustomerService;
import com.test.rest.service.CustomerServiceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Matchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-servlet.xml")
public class TestCustomerController  {	
	
	private MockMvc mockMvc;
	
	private Customer customer;
	
    @Before
    public void setUp() {	
		this.customer = new Customer();
		customer.setCustomerId(new Integer(1));
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
    	
    	Mockito.when(this.customerService.getCustomer(1)).thenReturn(this.customer);
    	Mockito.when(this.customerService.createCustomer(any(Customer.class))).thenReturn(true);
    	Mockito.when(this.customerService.updateCustomer(any(Customer.class))).thenReturn(true);
    	Mockito.when(this.customerService.removeCustomer(1)).thenReturn(true);
    	mockMvc =  MockMvcBuilders.standaloneSetup(this.customerController).build();
    }
    
    @Configuration
    static class CustomerControllerTestConfiguration {
	    @Bean
	    public CustomerService customerService() {
	    return Mockito.mock(CustomerServiceImpl.class);
	    }
	
	    @Bean
	    public CustomerController customerController() {
	    return new CustomerController();
	    }
	}
    @Autowired
    private CustomerController customerController;

    @Autowired
    private CustomerService customerService; 
	
	@Test
	public void testGetCustomer()throws Exception{
		 mockMvc.perform(get("/customer/1"))
         .andExpect(status().isOk())
         .andExpect(content().string("{" +
					 "\"customerId\":1," +
					  "\"fullName\":{" +
					    "\"firstName\":\"test\"," +
					    "\"middleName\":\"test\"," +
					    "\"surName\":\"test\"" +
					  "}," +
					  "\"initials\":\"S\"," +
					  "\"title\":\"Mr\"," +
					  "\"residenceAddress\":{" +
					    "\"streetNumber\":12," +
					    "\"streetName\":\"test\"," +
					    "\"suburb\":\"test\"," +
					    "\"city\":\"test\"," +
					    "\"state\":\"test\"," +
					    "\"country\":\"test\"," +
					    "\"pincode\":3166" +
					  "}," +
					  "\"sex\":\"MALE\"," +
					  "\"maritalStatus\":\"MARRIED\"," +
					  "\"creditRating\":80," +
					  "\"nabCustomer\":true" +
					"}"));		
	}
	
	@Test
	public void testCreateCustomer()throws Exception{
		 mockMvc.perform(post("/customer").contentType(MediaType.APPLICATION_JSON).content("{" +
					  "\"fullName\":{" +
					    "\"firstName\":\"test\"," +
					    "\"middleName\":\"test\"," +
					    "\"surName\":\"test\"" +
					  "}," +
					  "\"initials\":\"S\"," +
					  "\"title\":\"Mr\"," +
					  "\"residenceAddress\":{" +
					    "\"streetNumber\":12," +
					    "\"streetName\":\"test\"," +
					    "\"suburb\":\"test\"," +
					    "\"city\":\"test\"," +
					    "\"state\":\"test\"," +
					    "\"country\":\"test\"," +
					    "\"pincode\":3166" +
					  "}," +
					  "\"sex\":\"MALE\"," +
					  "\"maritalStatus\":\"MARRIED\"," +
					  "\"creditRating\":80," +
					  "\"nabCustomer\":true" +
					"}"))
         .andExpect(status().isCreated());		
	}	
	
	@Test
	public void testUpdateCustomer()throws Exception{
		 mockMvc.perform(put("/customer/1").contentType(MediaType.APPLICATION_JSON).content("{" +
				  "\"fullName\":{" +
				    "\"firstName\":\"test\"," +
				    "\"middleName\":\"test\"," +
				    "\"surName\":\"test\"" +
				  "}," +
				  "\"initials\":\"S\"," +
				  "\"title\":\"Mr\"," +
				  "\"residenceAddress\":{" +
				    "\"streetNumber\":12," +
				    "\"streetName\":\"test\"," +
				    "\"suburb\":\"test\"," +
				    "\"city\":\"test\"," +
				    "\"state\":\"test\"," +
				    "\"country\":\"test\"," +
				    "\"pincode\":3166" +
				  "}," +
				  "\"sex\":\"MALE\"," +
				  "\"maritalStatus\":\"MARRIED\"," +
				  "\"creditRating\":80," +
				  "\"nabCustomer\":true" +
				"}"))
         .andExpect(status().isOk())
         .andExpect(content().string("Customer Updated"));		
	}		
	
	@Test
	public void testDeleteCustomer()throws Exception{
		 mockMvc.perform(delete("/customer/1"))
         .andExpect(status().isOk())
         .andExpect(content().string("Customer Deleted"));		
	}	
	

}
