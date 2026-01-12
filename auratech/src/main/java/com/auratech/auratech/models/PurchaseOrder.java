package com.auratech.auratech.models;

import java.util.List;

import com.auratech.auratech.dto.PurchaseOrderDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float totalPrice;

	@ManyToOne
	private Client client;
	@ManyToMany
	private List<Product> products;

	public PurchaseOrder(PurchaseOrderDTO dto) {
		this.id = dto.getId();
		this.totalPrice = dto.getTotalPrice();

		this.client = new Client(dto.getClient());
		this.products = dto.getProducts().stream().map(Product::new).toList();
	}

	public PurchaseOrder() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
