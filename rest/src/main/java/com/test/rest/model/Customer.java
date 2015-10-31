package com.test.rest.model;

import java.io.Serializable;

public class Customer implements Serializable {
	
	private Integer customerId;
	private FullName fullName;
	private String initials;
	private String title;
	private Address residenceAddress;
	private Sex sex;
	private MaritalStatus maritalStatus;
	private Integer creditRating;
	private Boolean nabCustomer;
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public FullName getFullName() {
		return fullName;
	}
	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}
	public String getInitials() {
		return initials;
	}
	public void setInitials(String initials) {
		this.initials = initials;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Address getResidenceAddress() {
		return residenceAddress;
	}
	public void setResidenceAddress(Address residenceAddress) {
		this.residenceAddress = residenceAddress;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Integer getCreditRating() {
		return creditRating;
	}
	public void setCreditRating(Integer creditRating) {
		this.creditRating = creditRating;
	}
	public Boolean getNabCustomer() {
		return nabCustomer;
	}
	public void setNabCustomer(Boolean nabCustomer) {
		this.nabCustomer = nabCustomer;
	}
}
