package com.auratech.auratech.models;

import jakarta.persistence.Entity;

@Entity
public class Seller extends Users {
	
	private String sector;

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

}
