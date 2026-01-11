package com.auratech.auratech.models;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.auratech.auratech.dto.ClientDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Client extends Users {

	private String address;

	@OneToMany
	private List<ShoppingList> lists;

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

	public List<ShoppingList> getLists() {
		return lists;
	}

	public void setLists(List<ShoppingList> lists) {
		this.lists = lists;
	}

}
