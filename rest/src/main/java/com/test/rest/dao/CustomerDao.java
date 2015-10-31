package com.test.rest.dao;

import com.test.rest.model.Customer;

public interface CustomerDao {
	
	public Customer getCustomer(Integer customerId);
	
	public Customer insertCustomer(Customer customer);
	
	public boolean saveCustomer(Customer customer);
	
	public boolean removeCustomer(Integer customerId);

}
