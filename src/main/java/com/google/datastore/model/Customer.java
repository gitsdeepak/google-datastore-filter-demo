package com.google.datastore.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Customer {

	@Id
	private String customerId;
	private String name;
	private String contactNumber;
	private String address;

	public Customer() {
	}

	public Customer(String customerId, String name, String contactNumber, String address) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.contactNumber = contactNumber;
		this.address = address;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
