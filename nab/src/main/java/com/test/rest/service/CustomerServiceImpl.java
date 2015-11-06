package com.test.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.rest.dao.CustomerDao;
import com.test.rest.model.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao customerDao;

	@Override
	public Customer getCustomer(Integer customerId) {
		return customerDao.getCustomer(customerId);
	}

	@Override
	public boolean createCustomer(Customer customer) {
		if(customerDao.insertCustomer(customer)>0)
			return true;
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		if(customerDao.saveCustomer(customer)>0)
			return true;
		return false;
	}

	@Override
	public boolean removeCustomer(Integer customerId) {
		if(customerDao.removeCustomer(customerId)>0)
			return true;
		return false;
	}

}
