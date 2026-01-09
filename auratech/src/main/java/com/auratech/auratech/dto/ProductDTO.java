package com.auratech.auratech.dto;

import org.springframework.beans.BeanUtils;

import com.auratech.auratech.models.Product;

public class ProductDTO {

	private Long id;
	private String name;
	private String brand;
	private String description;
	private int quantity;
	private float price;

	public ProductDTO(Product product) {
		BeanUtils.copyProperties(product, this);
	}

	public ProductDTO() {
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
