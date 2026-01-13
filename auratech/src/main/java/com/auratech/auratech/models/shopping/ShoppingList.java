package com.auratech.auratech.models.shopping;

import java.util.List;

import com.auratech.auratech.dto.shopping.ShoppingListDTO;
import com.auratech.auratech.models.Product;
import com.auratech.auratech.models.users.Client;

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
		this.id = dto.getId();
		this.name = dto.getName();

		this.client = new Client(dto.getClient());
		this.products = dto.getProducts().stream().map(Product::new).toList();
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
