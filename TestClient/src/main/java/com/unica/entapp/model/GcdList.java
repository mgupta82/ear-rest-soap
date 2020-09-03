package com.unica.entapp.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class GcdList {
	
	private List<Integer> gcds;

	@XmlElement
	public List<Integer> getGcds() {
		return gcds;
	}

	public void setGcds(List<Integer> gcds) {
		this.gcds = gcds;
	}
	
	

}
