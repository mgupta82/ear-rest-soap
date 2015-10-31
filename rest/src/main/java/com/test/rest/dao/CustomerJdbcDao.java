package com.test.rest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.test.rest.model.Address;
import com.test.rest.model.Customer;
import com.test.rest.model.FullName;

@Repository("customerDao")
public class CustomerJdbcDao implements CustomerDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public class CustomerRowMapper implements RowMapper<Customer>{

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			FullName fullName = new FullName();
			fullName.setFirstName(rs.getString("first_name"));
			fullName.setMiddleName(rs.getString("middle_name"));
			fullName.setSurName(rs.getString("sur_name"));
			customer.setFullName(fullName);
			customer.setCreditRating(rs.getInt("credit_rating"));
			customer.setCustomerId(rs.getInt("customer_id"));
			customer.setInitials(rs.getString("initials"));
			//customer.setMaritalStatus(rs.getString("marital_status"));
			customer.setNabCustomer(rs.getBoolean("nab_customer"));
			Address address = new Address();
			address.setStreetNumber(rs.getInt("street_number"));
			address.setStreetName(rs.getString("street_name"));
			address.setSuburb(rs.getString("suburb"));
			address.setCity(rs.getString("city"));
			address.setState(rs.getString("state"));
			address.setPincode(rs.getInt("pincode"));
			address.setCountry(rs.getString("country"));
			customer.setResidenceAddress(new Address());
			//customer.setSex(rs.getString("sex"));
			customer.setTitle(rs.getString("title"));
			return customer;
		}
		
	}
	
	@Override
	public Customer getCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		return false;
	}

}
