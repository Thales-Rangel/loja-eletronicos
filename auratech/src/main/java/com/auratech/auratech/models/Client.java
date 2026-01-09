package com.auratech.auratech.models;

import org.springframework.beans.BeanUtils;

import com.auratech.auratech.dto.ClientDTO;

import jakarta.persistence.Entity;

@Entity
public class Client extends Users {

	private String address;

	public Client(ClientDTO client) {
		BeanUtils.copyProperties(client, this);
	}

	public Client() {
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
