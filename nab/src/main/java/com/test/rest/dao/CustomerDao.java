package com.test.rest.dao;

import com.test.rest.model.Customer;

public interface CustomerDao {
	
	public Customer getCustomer(Integer customerId);
	
	public int insertCustomer(Customer customer);
	
	public int saveCustomer(Customer customer);
	
	public int removeCustomer(Integer customerId);

}
