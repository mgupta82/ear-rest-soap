package com.test.rest.service;

import com.test.rest.model.Customer;

public interface CustomerService {

	public Customer getCustomer(Integer customerId);
	
	public boolean createCustomer(Customer customer);
	
	public boolean updateCustomer(Customer customer);
	
	public boolean removeCustomer(Integer customerId);	

}
