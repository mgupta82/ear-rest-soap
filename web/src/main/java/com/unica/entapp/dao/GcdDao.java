package com.unica.entapp.dao;

import java.util.List;

import com.unica.entapp.model.NumberPair;

public interface GcdDao {
	
	public String insertRecord(NumberPair numberPair);
	
	public List<NumberPair> getAllpairs();

}
