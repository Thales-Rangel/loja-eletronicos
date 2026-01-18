package com.auratech.auratech.models.shopping;

import java.util.List;

import com.auratech.auratech.dto.shopping.ShoppingCartDTO;
import com.auratech.auratech.models.Product;
import com.auratech.auratech.models.users.Client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Client client;
	@ManyToMany
	private List<Product> products;
	
	public ShoppingCart(ShoppingCartDTO cart) {
		this.id = cart.getId();

		this.client = new Client(cart.getClient());
		this.products = cart.getProducts().stream().map(Product::new).toList();
	}

	public ShoppingCart() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
