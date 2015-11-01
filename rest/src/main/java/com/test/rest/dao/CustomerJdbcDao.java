package com.test.rest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.test.rest.model.Address;
import com.test.rest.model.Customer;
import com.test.rest.model.FullName;
import com.test.rest.model.MaritalStatus;
import com.test.rest.model.Sex;

@Repository("customerDao")
public class CustomerJdbcDao implements CustomerDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public static final String CREATE = "insert into customer(first_name,middle_name,sur_name,initials,title,street_number,street_name,suburb,city,state,country,pincode,sex,marital_status,credit_rating,nab_customer) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	public static final String READ = "select * from customer where customer_id=?";
	public static final String UPDATE = "update customer set first_name=?,middle_name=?,sur_name=?,initials=?,title=?,street_number=?,street_name=?,suburb=?,city=?,state=?,country=?,pincode=?,sex=?,marital_status=?,credit_rating=?,nab_customer=? where customer_id=? ";
	public static final String DELETE = "delete from customer where customer_id = ?";
	
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
			customer.setMaritalStatus(MaritalStatus.valueOf(rs.getString("marital_status")));
			customer.setNabCustomer(rs.getBoolean("nab_customer"));
			Address address = new Address();
			address.setStreetNumber(rs.getInt("street_number"));
			address.setStreetName(rs.getString("street_name"));
			address.setSuburb(rs.getString("suburb"));
			address.setCity(rs.getString("city"));
			address.setState(rs.getString("state"));
			address.setPincode(rs.getInt("pincode"));
			address.setCountry(rs.getString("country"));
			customer.setResidenceAddress(address);
			customer.setSex(Sex.valueOf(rs.getString("sex")));
			customer.setTitle(rs.getString("title"));
			return customer;
		}
		
	}
	
	@Override
	public Customer getCustomer(Integer customerId) {
		List<Customer> customers = jdbcTemplate.query(READ, new CustomerRowMapper(),new Object[]{customerId});
		if(customers == null || customers.size()==0)
			return null ;
		else
			return customers.get(0);
	}

	@Override
	public int insertCustomer(Customer customer) {
		Object[] paramsForInsert = new Object[]{customer.getFullName().getFirstName(),
												customer.getFullName().getMiddleName(),
												customer.getFullName().getSurName(),
												customer.getInitials(),
												customer.getTitle(),
												customer.getResidenceAddress().getStreetNumber(),
												customer.getResidenceAddress().getStreetName(),
												customer.getResidenceAddress().getSuburb(),
												customer.getResidenceAddress().getCity(),
												customer.getResidenceAddress().getState(),
												customer.getResidenceAddress().getCountry(),
												customer.getResidenceAddress().getPincode(),
												customer.getSex().toString(),
												customer.getMaritalStatus().toString(),
												customer.getCreditRating(),
												customer.getNabCustomer()
												};
		int rowsInserted = jdbcTemplate.update(CREATE,paramsForInsert);
		return rowsInserted;
	}

	@Override
	public int saveCustomer(Customer customer) {
		Object[] paramsForUpdate = new Object[]{customer.getFullName().getFirstName(),
				customer.getFullName().getMiddleName(),
				customer.getFullName().getSurName(),
				customer.getInitials(),
				customer.getTitle(),
				customer.getResidenceAddress().getStreetNumber(),
				customer.getResidenceAddress().getStreetName(),
				customer.getResidenceAddress().getSuburb(),
				customer.getResidenceAddress().getCity(),
				customer.getResidenceAddress().getState(),
				customer.getResidenceAddress().getCountry(),
				customer.getResidenceAddress().getPincode(),
				customer.getSex().toString(),
				customer.getMaritalStatus().toString(),
				customer.getCreditRating(),
				customer.getNabCustomer(),
				customer.getCustomerId()
				};
		int rowsUpdated = jdbcTemplate.update(UPDATE,paramsForUpdate);
		return rowsUpdated;
	}

	@Override
	public int removeCustomer(Integer customerId) {
		int rowsDeleted = jdbcTemplate.update(DELETE,new Object[]{customerId});
		return rowsDeleted;
	}

}
