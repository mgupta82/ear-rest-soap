package com.unica.entapp.web.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unica.entapp.model.NumberPair;
import com.unica.entapp.service.GcdService;

@Component
@Path("/input")
public class InputService {
	
	@Autowired
	GcdService gcdService;
	
	@POST
	@Path("/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public String push(@PathParam("a") int i1, @PathParam("b") int i2) throws Exception{
		gcdService.insertInputPair(i1, i2);
		return "Number "+i1+" and "+i2+" has been added to the queue";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<NumberPair> list() throws Exception{
		List<NumberPair> lstNumbers = new ArrayList<NumberPair>();
		lstNumbers = gcdService.getAllNumberPair();
		return lstNumbers;
	}

}
