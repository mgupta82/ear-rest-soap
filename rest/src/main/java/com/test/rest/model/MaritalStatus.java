package com.test.rest.model;

public enum MaritalStatus {
	NEVER_MARRIED("NEVER_MARRIED"),
	MARRIED("MARRIED"),
	DIVORCED("DIVORCED"),
	WIDOWED("WIDOWED"),
	SEPARATED("SEPARATED");
	
	private String status;
	
	private MaritalStatus(String status) {
		this.status = status;
	}
	
	public String toString(){
		return status;
	}
	
}
