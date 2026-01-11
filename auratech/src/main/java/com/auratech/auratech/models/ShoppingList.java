package com.auratech.auratech.models;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.auratech.auratech.dto.ShoppingListDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class ShoppingList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@ManyToOne
	private Client client;
	@ManyToMany
	private List<Product> products;
	
	public ShoppingList(ShoppingListDTO dto) {
		BeanUtils.copyProperties(dto, this);
	}

	public ShoppingList() {
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
