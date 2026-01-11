package com.auratech.auratech.models;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;

import com.auratech.auratech.dto.ClientDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Client extends Users {

	private String address;

	@ManyToOne
	private ArrayList<ShoppingList> lists;

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

	public ArrayList<ShoppingList> getLists() {
		return lists;
	}

	public void setLists(ArrayList<ShoppingList> lists) {
		this.lists = lists;
	}

}
