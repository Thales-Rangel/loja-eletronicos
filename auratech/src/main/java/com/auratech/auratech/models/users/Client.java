package com.auratech.auratech.models.users;

import org.springframework.beans.BeanUtils;

import com.auratech.auratech.dto.users.ClientDTO;

import jakarta.persistence.Entity;

@Entity
public class Client extends Users {

	private String address;

	public Client(ClientDTO dto) {
		BeanUtils.copyProperties(dto, this);
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
