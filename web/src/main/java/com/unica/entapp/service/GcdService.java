package com.unica.entapp.service;

import java.util.List;

import com.unica.entapp.model.GcdList;
import com.unica.entapp.model.NumberPair;

public interface GcdService {
	public void insertInputPair(int first,int second) throws Exception;
	
	public List<NumberPair> getAllNumberPair() throws Exception;
	
	public GcdList getGcdList() throws Exception;
	
	public int getInputPair() throws Exception;
	
	public int getGcdSum() throws Exception;
}
