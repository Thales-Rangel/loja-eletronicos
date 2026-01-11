package com.auratech.auratech.dto;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;

import com.auratech.auratech.models.ShoppingList;

public class ShoppingListDTO {

	private Long id;
	private String name;

	private ArrayList<ProductDTO> products;
	
	public ShoppingListDTO(ShoppingList list) {
		BeanUtils.copyProperties(list, this);
	}

	public ShoppingListDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<ProductDTO> products) {
		this.products = products;
	}

}
