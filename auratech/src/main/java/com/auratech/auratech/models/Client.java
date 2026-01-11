package com.auratech.auratech.models;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;

import com.auratech.auratech.dto.ClientDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Client extends Users {

	private String address;

	@ManyToMany
	private ArrayList<List> lists;

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

	public ArrayList<List> getLists() {
		return lists;
	}

	public void setLists(ArrayList<List> lists) {
		this.lists = lists;
	}

}
