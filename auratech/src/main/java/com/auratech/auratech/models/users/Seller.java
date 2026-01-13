package com.auratech.auratech.models.users;

import org.springframework.beans.BeanUtils;

import com.auratech.auratech.dto.users.SellerDTO;

import jakarta.persistence.Entity;

@Entity
public class Seller extends Users {
	
	private String sector;
	
	

	public Seller(SellerDTO dto) {
		BeanUtils.copyProperties(dto, this);
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

}
