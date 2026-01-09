package com.auratech.auratech.models;

import jakarta.persistence.Entity;

@Entity
public class Client extends Users {
	
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
