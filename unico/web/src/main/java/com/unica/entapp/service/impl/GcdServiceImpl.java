package com.unica.entapp.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unica.entapp.dao.GcdDao;
import com.unica.entapp.jms.GcdMessenger;
import com.unica.entapp.model.GcdList;
import com.unica.entapp.model.NumberPair;

@Service("gcdService")
public class GcdServiceImpl implements com.unica.entapp.service.GcdService {
	
	@Autowired
	GcdDao gcdDao;
	
	@Autowired
	GcdMessenger gcdMessenger;

	@Override
	@Transactional
	public void insertInputPair(int first, int second) throws Exception {
		NumberPair numberPair = new NumberPair(first,second);
		gcdDao.insertRecord(numberPair);
		gcdMessenger.send(numberPair);
	}

	@Override
	public List<NumberPair> getAllNumberPair() throws Exception {
		List<NumberPair> lst = gcdDao.getAllpairs();
		return lst;
	}

	@Override
	public GcdList getGcdList() throws Exception {
		List<NumberPair> lst = gcdDao.getAllpairs();
		List<Integer> gcds = new ArrayList<Integer>();
		Iterator<NumberPair> itr = lst.iterator();
		NumberPair numberPair = null;
		while(itr.hasNext()){
			numberPair = (NumberPair)itr.next();
			gcds.add(getGcd(numberPair));
		}
		GcdList gcdList = new GcdList();
		gcdList.setGcds(gcds);
		return gcdList;
	}

	@Override
	public int getInputPair() throws Exception {
		NumberPair numberPair = gcdMessenger.receive();
		return getGcd(numberPair);
	}
	
	private int getGcd(NumberPair numberPair) {
	    BigInteger b1 = BigInteger.valueOf(numberPair.getFirst());
	    BigInteger b2 = BigInteger.valueOf(numberPair.getSecond());
	    BigInteger gcd = b1.gcd(b2);
	    return gcd.intValue();
	}

	@Override
	public int getGcdSum() throws Exception {
		List<NumberPair> lst = gcdDao.getAllpairs();
		List<Integer> gcds = new ArrayList<Integer>();
		Iterator<NumberPair> itr = lst.iterator();
		int sum=0;
		NumberPair numberPair = null;
		while(itr.hasNext()){
			numberPair = (NumberPair)itr.next();
			sum = sum + getGcd(numberPair);
		}
		return sum;
	}	
	


}
