package com.unica.entapp.web.soap;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unica.entapp.model.GcdList;
import com.unica.entapp.service.GcdService;
import com.unica.entapp.web.soap.OutputService;

@Component("outputWebService")
@WebService(endpointInterface = "com.unica.entapp.web.soap.OutputService")
public class OutputWebService implements OutputService {
	
	@Autowired
	GcdService gcdService;

	@Override
	public int gcd() throws Exception{
		return gcdService.getInputPair();
	}

	@Override
	public GcdList gcdList() throws Exception {
		GcdList gcdList = gcdService.getGcdList();
		return gcdList; 
	}

	@Override
	public int gcdSum()  throws Exception {
		return gcdService.getGcdSum();
	}

}
