package com.auratech.auratech.dto;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;

import com.auratech.auratech.models.Client;

public class ClientDTO {

	private String CPF;
	private String name;
	private String email;
	private String password;
	private String address;

	private ArrayList<ShoppingListDTO> lists;

	public ClientDTO(Client client) {
		BeanUtils.copyProperties(client, this);
	}

	public ClientDTO() {

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<ShoppingListDTO> getLists() {
		return lists;
	}

	public void setLists(ArrayList<ShoppingListDTO> lists) {
		this.lists = lists;
	}

}
