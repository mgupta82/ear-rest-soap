package com.unica.entapp.web.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.unica.entapp.model.GcdList;

@WebService
@SOAPBinding(style = Style.RPC)
public interface OutputService {
	
	@WebMethod
	public int gcd();
	
	@WebMethod
	public GcdList gcdList();
	
	@WebMethod
	public int gcdSum();
}
