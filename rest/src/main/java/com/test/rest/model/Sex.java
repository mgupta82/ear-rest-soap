package com.test.rest.model;

public enum Sex {
	MALE("MALE"),
	FEMALE("FEMALE");
	
	private String  gender;
	
	Sex(String gender) {
		this.gender = gender;
	}
	
	public String  toString(){
		return this.gender;
	}
	
}
