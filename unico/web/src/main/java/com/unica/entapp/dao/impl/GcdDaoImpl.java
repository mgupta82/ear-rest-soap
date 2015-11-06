package com.unica.entapp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.unica.entapp.dao.GcdDao;
import com.unica.entapp.model.NumberPair;

@Repository("gcdDao")
public class GcdDaoImpl implements GcdDao {
	
	private static final String CREATE = "INSERT INTO number_pair(first_number,second_number) values (?,?)";
	private static final String READ = "Select first_number,second_number from number_pair order by id";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private class GcdDaoRowMapper implements RowMapper<NumberPair>{

		@Override
		public NumberPair mapRow(ResultSet rs, int rowNum) throws SQLException {
			NumberPair numberPair = new NumberPair();
			numberPair.setFirst(rs.getInt("FIRST_NUMBER"));
			numberPair.setSecond(rs.getInt("SECOND_NUMBER"));
			return numberPair;
		}
	}

	@Override
	public String insertRecord(NumberPair numberPair) {
		Object[] paramsForInsert = new Object[]{numberPair.getFirst(),numberPair.getSecond()};
		int insertRow = jdbcTemplate.update(CREATE,paramsForInsert);
		return null;
	}
	
	public List<NumberPair> getAllpairs(){
		List<NumberPair> lst = jdbcTemplate.query(READ, new GcdDaoRowMapper());
		return lst;
		
	}

}
