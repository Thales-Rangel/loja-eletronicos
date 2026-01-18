package com.auratech.auratech.dto.users;

import org.springframework.beans.BeanUtils;

import com.auratech.auratech.models.users.Seller;

public class SellerDTO {

	private String CPF;
	private String name;
	private String email;
	private String password;
	private String sector;

	public SellerDTO(Seller seller) {
		BeanUtils.copyProperties(seller, this);
	}

	public SellerDTO() {
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

}
